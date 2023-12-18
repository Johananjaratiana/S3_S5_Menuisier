CREATE SEQUENCE "public".personne_id_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".personne ( 
	id                   integer DEFAULT nextval('personne_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	prenom               varchar  NOT NULL  ,
	dtn                  date  NOT NULL  ,
	email                varchar  NOT NULL  ,
	mdp                  varchar  NOT NULL  ,
	CONSTRAINT pk_personne PRIMARY KEY ( id )
 );
