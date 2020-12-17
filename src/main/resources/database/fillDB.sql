insert into users (username, "password", email, role_name) values ('admin', '$2y$12$xX5aidoomyyeIAxVZz18ieHl.zKjAz4zzfl8ZIy8yXPCD3bD.AAli', 'admin@mail.com', 'ADMIN');
insert into users (username, "password", email, status) values ('parker', '$2y$12$WtbuGvgFuVnrLNAkMaUYoOhdNFVA7wHMemjfIXOImNARHwCvgCFrm', 'parker', 'BANNED');
insert into users (username, "password", email, first_name, last_name) values ('root', '$2y$12$.ydtvtZmcEtJAGtXz0KsIuOSCyDNQWo..n.KR5n0D0eT082VmY8EK', 'root@mail.com', 'Sych', 'Sychev');
insert into users (username, "password", email) values ('notroot', '$2y$12$WtbuGvgFuVnrLNAkMaUYoOhdNFVA7wHMemjfIXOImNARHwCvgCFrm', 'notroot');
insert into users (username, "password", email) values ('guest', '$2y$12$WtbuGvgFuVnrLNAkMaUYoOhdNFVA7wHMemjfIXOImNARHwCvgCFrm', 'guest');

insert into messages(message, user_id, created_time, updated_time) values ('hello world!', 1, '2017-08-19 14:22:11.802755+02', '2017-08-19 14:22:11.802755+02');
insert into messages(message, user_id, created_time, updated_time) values ('London is the capital of GB', 2, '2017-08-19 14:25:11.802755+02', '2017-08-19 14:25:11.802755+02');
insert into messages(message, user_id, created_time, updated_time) values ('Postgres', 3, '2017-08-19 14:30:11.802755+02', '2017-08-19 14:30:11.802755+02');
insert into messages(message, user_id, created_time, updated_time) values ('Kavabanga', 1, '2017-08-19 14:35:11.802755+02', '2017-08-19 14:37:11.802755+02');