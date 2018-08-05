insert into SYS_USER (id,username,password) values (1,"wangtao","$2a$10$fst.HQY6FNJyPP51zTOpkO3WlfIoz4NC6dDzYgXfXZcfac9jiTHm2");
insert into SYS_USER (id,username,password) values (2,"wtao","$2a$10$Lg4rhz8w9qN.c4dNVpZUd.Ed6p0AEauPH2dySWAyVNowI1SZ4pqDG");

insert into SYS_ROLE (id,name) values (1,"ROLE_ADMIN");
insert into SYS_ROLE (id,name) values (2,"ROLE_USER");


insert into SYS_USER_ROLES (SYS_USER_ID,ROLES_ID) values (1,1);
insert into SYS_USER_ROLES (SYS_USER_ID,ROLES_ID) values (2,2);