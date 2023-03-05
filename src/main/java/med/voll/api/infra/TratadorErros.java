package med.voll.api.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorErros {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErro400::new).toList());
    }

    private record DadosErro400(String campo, String mensagem) {
        public DadosErro400(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
