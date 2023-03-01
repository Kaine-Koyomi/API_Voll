alter table medicos add active tinyint;
update medicos set active=1;

alter table pacientes add active tinyint;
update pacientes set active=1;