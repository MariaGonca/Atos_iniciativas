INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');



INSERT INTO iniciativas (titulo, descripcion, inicio, fin, activa) VALUES ('Primera iniciativa','Descripción I1', '09-05-2022', '09-05-2022', true);
INSERT INTO iniciativas (titulo, descripcion, inicio, fin, activa) VALUES ('Segunda Iniciativa','Descripción I2', '09-05-2022', '19-06-2022', true);
INSERT INTO iniciativas (titulo, descripcion, inicio, fin, activa) VALUES ('Tercera Iniciativa','Descripción I3', '09-05-2022', '09-07-2022', true);
INSERT INTO iniciativas (titulo, descripcion, inicio, fin, activa) VALUES ('Cuarta Iniciativa','Descripción I4', '09-07-2022', '09-08-2022', true);



INSERT INTO `notebook`.`users` (`id`, `apellidos`, `becas`, `ceco`, `center`, `contacto`, `convenio`, `das`, `dni`, `email`, `email_atos`, `fechafct`, `fecha_nacimiento`, `finfct`, `group_proyect`, `location`, `name_group_teams`, `org_unit`, `password`, `phone`, `po`, `position_id`, `rr`, `sociedad`, `ss`, `teacher`, `tipo`, `username`, `id_iniciativa`) VALUES ('2', '6453431', '123456', '123456', '123456', '123456', '123456', '123456', '123456', '1234asd56@1234', '123456', '1111-11-11', '1111-11-11', '1111-11-11', '123456', '1234565', '12543', '123412', '$2a$10$iNtHl.EBjB3I89wMQMH.3uI.hXehSvt5IWbtG7.zvb/Dorm/1F9Kq', '123456', '123456', '123456', '123456', '123456', '123456', '123456', '123456', 'admin', '1');
INSERT INTO `notebook`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '3');
