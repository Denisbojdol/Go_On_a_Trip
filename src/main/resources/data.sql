INSERT INTO role (id, name) VALUES (NULL, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (NULL, 'ROLE_ORGANIZER');
INSERT INTO role (id, name) VALUES (NULL, 'ROLE_ADMIN');

INSERT INTO user (username, password, enabled) VALUES ( 'user1@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);
INSERT INTO user (username, password, enabled) VALUES ( 'user2@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);
INSERT INTO user (username, password, enabled) VALUES ( 'organizer@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);

