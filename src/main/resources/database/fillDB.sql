insert into users (username, "password", email, role_name) values ('admin', '$2y$12$xX5aidoomyyeIAxVZz18ieHl.zKjAz4zzfl8ZIy8yXPCD3bD.AAli', 'admin@mail.com', 'ADMIN');
insert into users (username, "password", email, status) values ('parker', '$2y$12$WtbuGvgFuVnrLNAkMaUYoOhdNFVA7wHMemjfIXOImNARHwCvgCFrm', 'parker', 'BANNED');
insert into users (username, "password", email, first_name, last_name) values ('root', '$2y$12$.ydtvtZmcEtJAGtXz0KsIuOSCyDNQWo..n.KR5n0D0eT082VmY8EK', 'root@mail.com', 'Sych', 'Sychev');
insert into users (username, "password", email) values ('notroot', '$2y$12$WtbuGvgFuVnrLNAkMaUYoOhdNFVA7wHMemjfIXOImNARHwCvgCFrm', 'notroot');
insert into users (username, "password", email) values ('guest', '$2y$12$WtbuGvgFuVnrLNAkMaUYoOhdNFVA7wHMemjfIXOImNARHwCvgCFrm', 'guest');

insert into messages(message) values ('hello world!');
insert into messages(message) values ('London is the capital of GB');
insert into messages(message) values ('Postgres');
insert into messages(message) values ('Kavabanga');