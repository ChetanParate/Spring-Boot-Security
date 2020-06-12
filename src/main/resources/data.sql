insert into users(username, password, enabled) values('chetan', 'success', true);
insert into users(username, password, enabled) values('admin', 'admin', true);
insert into users(username, password, enabled) values('user', 'pass', true);

insert into authorities(username, authority)
values('chetan','ROLE_USER');

insert into authorities(username, authority)
values('admin','ROLE_ADMIN');

insert into authorities(username, authority)
values('user','ROLE_USER');
