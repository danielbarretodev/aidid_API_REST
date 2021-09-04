/*
INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'USER');
INSERT INTO role (id, description, name) VALUES (3, 'Organization role', 'ORGANIZATION');
INSERT INTO role (id, description, name) VALUES (4, 'Collaborator role', 'COLLABORATOR');


INSERT INTO ong.user(dtype,id,password,username,email,name,phone,surname,country,solidarity_history_id) VALUES ('Collaborator',5,'$2a$10$3nCqRP9Y7p8rHEawHklLC.noAGYb5PJNtfXsslpWm/kGuUDU5vYmi','user1','user1@gmail.com','usuario',655493827,'apellido','',6);


INSERT INTO solidarity_history(id,collaborator_id,collaborator_user_name) VALUES (6,5,'user1');

INSERT INTO ong.user_roles(user_id,role_id) VALUES (5,2);


INSERT INTO ong.user(dtype,id,password,username,name,country,activity_type) VALUES ('Organization',7,'$2a$10$3nCqRP9Y7p8rHEawHklLC.noAGYb5PJNtfXsslpWm/kGuUDU5vYmi','ong1','organizacion','España','AYUDA_MEDICA');


INSERT INTO ong.user_roles(user_id,role_id) VALUES (7,3);
*/
