DROP TABLE IF EXISTS EMPLOYE;
DROP TABLE IF EXISTS UTILISATEUR;

create table EMPLOYE
(
	ID int auto_increment
		primary key,
	NOM varchar(255) null,
	PRENOM varchar(255) null,
	TELDOMICILE varchar(255) null,
	TELPORTABLE varchar(255) null,
	TELPRO varchar(255) null,
	ADRESSE varchar(255) null,
	CODEPOSTAL varchar(255) null,
	VILLE varchar(255) null,
	EMAIL varchar(255) null
);

create table UTILISATEUR
(
	ID int auto_increment
		primary key,
	USERNAME varchar(255) not null,
	PASSWORD varchar(255) not null,
	ADMIN tinyint(1) not null

);

INSERT INTO UTILISATEUR (USERNAME,PASSWORD,ADMIN)VALUES('admin','admin',true);
INSERT INTO UTILISATEUR (USERNAME,PASSWORD,ADMIN)VALUES('empl','empl',false);

