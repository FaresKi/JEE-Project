CREATE TABLE EMPLOYE
(
        ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	NOM			VARCHAR(255),
	PRENOM			VARCHAR(255),
	TELDOMICILE		VARCHAR(255),
	TELPORTABLE		VARCHAR(255),
	TELPRO			VARCHAR(255),
	ADRESSE			VARCHAR(255),
	CODEPOSTAL		VARCHAR(255),
	VILLE			VARCHAR(255),
	EMAIL			VARCHAR(255),
	CONSTRAINT primary_key_employe PRIMARY KEY (ID)

);
CREATE TABLE UTILISATEUR
  (
      ID              INT AUTO_INCREMENT,
      USERNAME		VARCHAR(255) NOT NULL,
      PASSWORD		VARCHAR(255) NOT NULL,
      ADMIN                   BOOLEAN NOT NULL,
      CONSTRAINT primary_key_ID PRIMARY KEY (ID)
  );

INSERT INTO UTILISATEUR (USERNAME,PASSWORD,ADMIN)VALUES('admin','admin',true);
INSERT INTO UTILISATEUR (USERNAME,PASSWORD,ADMIN)VALUES('empl','empl',false);

