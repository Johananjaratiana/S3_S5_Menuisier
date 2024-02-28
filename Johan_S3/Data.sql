CREATE SEQUENCE "public".categorie_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".client_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".commande_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".duration_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".duree_fabrication_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".employee_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".employement_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".grade_employee_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".grade_year_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".materiel_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".personne_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".prix_materiel_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".prix_reference_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".produit_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".quantite_outils_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".reference_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".sexe_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".stock_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".style_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".style_materiel_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".type_employee_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".unite_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".volume_id_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".categorie ( 
	id                   integer DEFAULT nextval('categorie_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_categorie PRIMARY KEY ( id )
 );

CREATE  TABLE "public".employee ( 
	id                   integer DEFAULT nextval('employee_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	prenom               varchar  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	date_naissance       date  NOT NULL  ,
	CONSTRAINT pk_employee PRIMARY KEY ( id )
 );

CREATE  TABLE "public".grade_employee ( 
	id                   integer DEFAULT nextval('grade_employee_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_grade_employee PRIMARY KEY ( id )
 );

CREATE  TABLE "public".grade_params ( 
	id                   integer DEFAULT nextval('grade_year_id_seq'::regclass) NOT NULL  ,
	id_grade             integer  NOT NULL  ,
	years                integer  NOT NULL  ,
	x_fois_taux_salaire  double precision  NOT NULL  ,
	date_                timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	CONSTRAINT pk_grade_year PRIMARY KEY ( id ),
	CONSTRAINT fk_grade_year_grade_employee FOREIGN KEY ( id_grade ) REFERENCES "public".grade_employee( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".personne ( 
	id                   integer DEFAULT nextval('personne_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	prenom               varchar  NOT NULL  ,
	dtn                  date  NOT NULL  ,
	email                varchar  NOT NULL  ,
	mdp                  varchar  NOT NULL  ,
	CONSTRAINT pk_personne PRIMARY KEY ( id )
 );

CREATE  TABLE "public".produit ( 
	id                   integer DEFAULT nextval('produit_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	id_categorie         integer  NOT NULL  ,
	CONSTRAINT pk_produit PRIMARY KEY ( id ),
	CONSTRAINT fk_produit_categorie FOREIGN KEY ( id_categorie ) REFERENCES "public".categorie( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".sexe ( 
	id                   integer DEFAULT nextval('sexe_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_sexe PRIMARY KEY ( id )
 );

CREATE  TABLE "public"."style" ( 
	id                   integer DEFAULT nextval('style_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_tbl PRIMARY KEY ( id )
 );

CREATE  TABLE "public".type_employee ( 
	id                   integer DEFAULT nextval('type_employee_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	taux_horaire         double precision  NOT NULL  ,
	date_                timestamp(1) DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	CONSTRAINT pk_type_emloyee PRIMARY KEY ( id )
 );

CREATE  TABLE "public".unite ( 
	id                   integer DEFAULT nextval('unite_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_unite PRIMARY KEY ( id )
 );

CREATE  TABLE "public".volume ( 
	id                   integer DEFAULT nextval('volume_id_seq'::regclass) NOT NULL  ,
	longueur             double precision  NOT NULL  ,
	largeur              double precision  NOT NULL  ,
	hauteur              double precision  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	CONSTRAINT pk_volume PRIMARY KEY ( id )
 );

CREATE  TABLE "public".client ( 
	id                   integer DEFAULT nextval('client_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	prenom               varchar  NOT NULL  ,
	email                varchar  NOT NULL  ,
	id_sexe              integer  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	date_naissance       date  NOT NULL  ,
	CONSTRAINT pk_client PRIMARY KEY ( id ),
	CONSTRAINT fk_client_sexe FOREIGN KEY ( id_sexe ) REFERENCES "public".sexe( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".employement ( 
	id                   integer DEFAULT nextval('employement_id_seq'::regclass) NOT NULL  ,
	id_employee          integer  NOT NULL  ,
	id_type_employee     integer  NOT NULL  ,
	date_embauche        date DEFAULT CURRENT_DATE NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_employement PRIMARY KEY ( id ),
	CONSTRAINT unq_employement UNIQUE ( id_employee, id_type_employee ) ,
	CONSTRAINT fk_employement_employee FOREIGN KEY ( id_employee ) REFERENCES "public".employee( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_employement_type_employee FOREIGN KEY ( id_type_employee ) REFERENCES "public".type_employee( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".materiel ( 
	id                   integer DEFAULT nextval('materiel_id_seq'::regclass) NOT NULL  ,
	nom                  varchar  NOT NULL  ,
	id_unite             integer  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_materiel PRIMARY KEY ( id ),
	CONSTRAINT fk_materiel_unite FOREIGN KEY ( id_unite ) REFERENCES "public".unite( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".meuble ( 
	id                   integer DEFAULT nextval('reference_id_seq'::regclass) NOT NULL  ,
	id_style             integer  NOT NULL  ,
	id_volume            integer  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	id_produit           integer  NOT NULL  ,
	CONSTRAINT pk_reference PRIMARY KEY ( id ),
	CONSTRAINT unq_reference UNIQUE ( id_style, id_volume, id_produit ) ,
	CONSTRAINT fk_reference_produit FOREIGN KEY ( id_produit ) REFERENCES "public".produit( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_reference_style FOREIGN KEY ( id_style ) REFERENCES "public"."style"( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_reference_volume FOREIGN KEY ( id_volume ) REFERENCES "public".volume( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".mode_fabrication ( 
	id                   integer DEFAULT nextval('duree_fabrication_id_seq'::regclass) NOT NULL  ,
	id_meuble            integer  NOT NULL  ,
	id_type_employee     integer  NOT NULL  ,
	duree                integer  NOT NULL  ,
	date_                timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	nombre               integer  NOT NULL  ,
	CONSTRAINT unq_duree_fabrication_id_reference UNIQUE ( id_meuble, id_type_employee ) ,
	CONSTRAINT pk_duree_fabrication PRIMARY KEY ( id ),
	CONSTRAINT fk_duree_fabrication_reference FOREIGN KEY ( id_meuble ) REFERENCES "public".meuble( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_duree_fabrication_type_employee FOREIGN KEY ( id_type_employee ) REFERENCES "public".type_employee( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".prix_materiel ( 
	id                   integer DEFAULT nextval('prix_materiel_id_seq'::regclass) NOT NULL  ,
	id_materiel          integer  NOT NULL  ,
	prix_unitaire        double precision  NOT NULL  ,
	date_                timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	CONSTRAINT pk_prix_materiel PRIMARY KEY ( id ),
	CONSTRAINT fk_prix_materiel_materiel FOREIGN KEY ( id_materiel ) REFERENCES "public".materiel( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".prix_meuble ( 
	id                   integer DEFAULT nextval('prix_reference_id_seq'::regclass) NOT NULL  ,
	id_meuble            integer  NOT NULL  ,
	prix_vente           double precision  NOT NULL  ,
	date_                timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	CONSTRAINT pk_prix_reference PRIMARY KEY ( id ),
	CONSTRAINT fk_prix_reference_reference FOREIGN KEY ( id_meuble ) REFERENCES "public".meuble( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".quantite_outils ( 
	id                   integer DEFAULT nextval('quantite_outils_id_seq'::regclass) NOT NULL  ,
	id_meuble            integer  NOT NULL  ,
	id_materiel          integer  NOT NULL  ,
	quantite             double precision  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_quantite_outils PRIMARY KEY ( id ),
	CONSTRAINT unq_quantite_outils UNIQUE ( id_meuble, id_materiel ) ,
	CONSTRAINT fk_quantite_outils_materiel FOREIGN KEY ( id_materiel ) REFERENCES "public".materiel( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_quantite_outils_reference FOREIGN KEY ( id_meuble ) REFERENCES "public".meuble( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".stock_meuble ( 
	id                   integer DEFAULT nextval('commande_id_seq'::regclass) NOT NULL  ,
	id_meuble            integer  NOT NULL  ,
	quantite             integer  NOT NULL  ,
	date_                timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	id_client            integer    ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_commande PRIMARY KEY ( id ),
	CONSTRAINT fk_stock_meuble_client FOREIGN KEY ( id_client ) REFERENCES "public".client( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_commande_reference FOREIGN KEY ( id_meuble ) REFERENCES "public".meuble( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".style_materiel ( 
	id                   integer DEFAULT nextval('style_materiel_id_seq'::regclass) NOT NULL  ,
	id_style             integer  NOT NULL  ,
	id_materiel          integer  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_style_materiel PRIMARY KEY ( id ),
	CONSTRAINT idx_style_materiel UNIQUE ( id_style, id_materiel ) ,
	CONSTRAINT fk_style_materiel_materiel FOREIGN KEY ( id_materiel ) REFERENCES "public".materiel( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_style_materiel_style FOREIGN KEY ( id_style ) REFERENCES "public"."style"( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".duration ( 
	id                   integer DEFAULT nextval('duration_id_seq'::regclass) NOT NULL  ,
	id_meuble            integer  NOT NULL  ,
	jour                 integer DEFAULT 0 NOT NULL  ,
	heure                integer DEFAULT 0 NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_duration PRIMARY KEY ( id ),
	CONSTRAINT fk_duration_reference FOREIGN KEY ( id_meuble ) REFERENCES "public".meuble( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".stock_materiel ( 
	id                   integer DEFAULT nextval('stock_id_seq'::regclass) NOT NULL  ,
	id_materiel          integer  NOT NULL  ,
	nombre               double precision  NOT NULL  ,
	date_                timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	id_fabrication       integer    ,
	CONSTRAINT pk_stock PRIMARY KEY ( id ),
	CONSTRAINT fk_stock_materiel FOREIGN KEY ( id_materiel ) REFERENCES "public".materiel( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_stock_commande FOREIGN KEY ( id_fabrication ) REFERENCES "public".stock_meuble( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE VIEW "public".v_benefice_meuble AS  SELECT r.id,
    r.id_style,
    r.id_volume,
    r.status,
    r.id_produit,
    r.nom_style,
    r.longueur,
    r.largeur,
    r.hauteur,
    r.nom_volume,
    r.id_categorie,
    r.nom_categorie,
    r.nom_produit,
    COALESCE((pm.prix_vente - (pre.sum + prm.sum)), (0)::double precision) AS benefice
   FROM (((v_meuble r
     LEFT JOIN v_prix_meuble pm ON ((pm.id_meuble = r.id)))
     LEFT JOIN v_prix_revient_employee pre ON ((pre.id_meuble = r.id)))
     LEFT JOIN v_filtre_produit_by_prix prm ON ((prm.id_meuble = r.id)));

CREATE VIEW "public".v_check_left_by_quantite_outils AS  SELECT qo.id,
    qo.id_meuble,
    qo.id_materiel,
    qo.quantite,
    qo.status,
    vsr.reste,
    vsr.nom_materiel
   FROM (quantite_outils qo
     JOIN v_stock_materiel_restante vsr ON ((vsr.id_materiel = qo.id_materiel)));

CREATE VIEW "public".v_client AS  SELECT c.id,
    c.nom,
    c.prenom,
    c.email,
    c.id_sexe,
    c.status,
    c.date_naissance,
    s.nom AS nom_sexe,
    s.status AS status_sexe
   FROM (client c
     JOIN sexe s ON ((s.id = c.id_sexe)));

CREATE VIEW "public".v_contrainte_style_materiel_meuble AS  SELECT r.id,
    r.id_style,
    sm.id_materiel
   FROM ((v_meuble r
     JOIN style s ON ((s.id = r.id_style)))
     JOIN style_materiel sm ON ((sm.id_style = s.id)));

CREATE VIEW "public".v_duree_fabrication AS  SELECT df.id,
    df.id_meuble,
    df.id_type_employee,
    df.duree,
    df.date_,
    df.nombre,
    r.nom_produit,
    r.nom_categorie,
    r.nom_style,
    r.nom_volume,
    r.longueur,
    r.largeur,
    r.hauteur,
    te.nom AS nom_type_employee,
    te.taux_horaire,
    te.date_ AS date_type_employee
   FROM ((mode_fabrication df
     JOIN v_meuble r ON ((r.id = df.id_meuble)))
     JOIN type_employee te ON ((te.id = df.id_type_employee)));

CREATE VIEW "public".v_filtre_produit_by_prix AS  SELECT qm.id_meuble,
    max((r.nom_produit)::text) AS nom_produit,
    max((r.nom_categorie)::text) AS nom_categorie,
    max(r.longueur) AS longueur,
    max(r.largeur) AS largeur,
    max(r.hauteur) AS hauteur,
    sum((pm.prix_unitaire * qm.quantite)) AS sum,
    max((r.nom_style)::text) AS nom_style,
    max((r.nom_volume)::text) AS nom_volume
   FROM (((v_meuble r
     JOIN quantite_outils qm ON ((r.id = qm.id_meuble)))
     JOIN materiel m ON ((m.id = qm.id_materiel)))
     JOIN v_prix_materiel pm ON ((pm.id_materiel = qm.id_materiel)))
  GROUP BY qm.id_meuble;

CREATE VIEW "public".v_latest_grade_params_insert AS  SELECT grade_params.id_grade,
    max(grade_params.date_) AS max_date
   FROM grade_params
  GROUP BY grade_params.id_grade;

CREATE VIEW "public".v_latest_insert_prix_meuble AS  SELECT prix_meuble.id_meuble,
    max(prix_meuble.date_) AS date_
   FROM prix_meuble
  GROUP BY prix_meuble.id_meuble;

CREATE VIEW "public".v_materiel AS  SELECT m.id AS id_materiel,
    m.nom AS nom_materiel,
    u.id AS id_unite,
    u.nom AS nom_unite
   FROM (materiel m
     JOIN unite u ON ((u.id = m.id_unite)));

CREATE VIEW "public".v_meuble AS  SELECT r.id,
    r.id_style,
    r.id_volume,
    r.status,
    r.id_produit,
    s.nom AS nom_style,
    v.longueur,
    v.largeur,
    v.hauteur,
    v.nom AS nom_volume,
    c.id AS id_categorie,
    c.nom AS nom_categorie,
    p.nom AS nom_produit
   FROM ((((meuble r
     JOIN style s ON ((s.id = r.id_style)))
     JOIN volume v ON ((v.id = r.id_volume)))
     JOIN produit p ON ((p.id = r.id_produit)))
     JOIN categorie c ON ((p.id_categorie = c.id)));

CREATE VIEW "public".v_nb_vente_par_style_par_mois_current_year AS  SELECT vm.id_style,
    COALESCE((- sum(sm.quantite)), (0)::bigint) AS nb_vente,
    EXTRACT(month FROM sm.date_) AS month
   FROM (stock_meuble sm
     JOIN v_meuble vm ON ((vm.id = sm.id_meuble)))
  WHERE ((sm.quantite < 0) AND (EXTRACT(year FROM sm.date_) = EXTRACT(year FROM CURRENT_DATE)))
  GROUP BY vm.id_style, (EXTRACT(month FROM sm.date_));

CREATE VIEW "public".v_prix_materiel AS  SELECT pm.id,
    pm.id_materiel,
    pm.prix_unitaire,
    pm.date_,
    m.nom AS nom_materiel,
    m.status AS status_materiel
   FROM ((v_prix_materiel_latest_date vpm
     JOIN prix_materiel pm ON (((vpm.id_materiel = pm.id_materiel) AND (vpm.date_ = pm.date_))))
     JOIN materiel m ON ((pm.id_materiel = m.id)));

CREATE VIEW "public".v_prix_materiel_latest_date AS  SELECT prix_materiel.id_materiel,
    max(prix_materiel.date_) AS date_
   FROM prix_materiel
  GROUP BY prix_materiel.id_materiel;

CREATE VIEW "public".v_prix_meuble AS  SELECT pr.id,
    pr.id_meuble,
    pr.prix_vente,
    pr.date_,
    r.nom_produit,
    r.nom_categorie,
    r.nom_style,
    r.nom_volume,
    r.longueur,
    r.largeur,
    r.hauteur
   FROM ((v_latest_insert_prix_meuble lipm
     JOIN prix_meuble pr ON (((pr.id_meuble = lipm.id_meuble) AND (pr.date_ = lipm.date_))))
     JOIN v_meuble r ON ((r.id = lipm.id_meuble)));

CREATE VIEW "public".v_prix_revient_employee AS  SELECT df.id_meuble,
    sum(((te.taux_horaire * (df.duree)::double precision) * (df.nombre)::double precision)) AS sum
   FROM (mode_fabrication df
     JOIN type_employee te ON ((te.id = df.id_type_employee)))
  GROUP BY df.id_meuble;

CREATE VIEW "public".v_produit AS  SELECT p.id AS id_produit,
    p.nom AS nom_produit,
    c.id AS id_categorie,
    c.nom AS nom_categorie
   FROM (produit p
     JOIN categorie c ON ((p.id_categorie = c.id)));

CREATE VIEW "public".v_quantite_outils AS  SELECT qo.id,
    qo.id_meuble,
    qo.id_materiel,
    qo.quantite,
    qo.status,
    m.nom AS nom_materiel,
    vr.id_style,
    vr.id_volume,
    vr.status AS status_meuble,
    vr.id_produit,
    vr.nom_style,
    vr.longueur,
    vr.largeur,
    vr.hauteur,
    vr.nom_volume,
    vr.id_categorie,
    vr.nom_categorie,
    vr.nom_produit
   FROM ((quantite_outils qo
     JOIN v_meuble vr ON ((vr.id = qo.id_meuble)))
     JOIN materiel m ON ((m.id = qo.id_materiel)));

CREATE VIEW "public".v_real_grade_params AS  SELECT gp.id,
    gp.id_grade,
    COALESCE(gp.years, 0) AS years,
    COALESCE(gp.x_fois_taux_salaire, (0)::double precision) AS x_fois_taux_salaire,
    gp.date_,
    ge.nom AS nom_grade,
    ge.status AS status_grade
   FROM ((grade_params gp
     JOIN v_latest_grade_params_insert subq ON (((gp.id_grade = subq.id_grade) AND (gp.date_ = subq.max_date))))
     RIGHT JOIN grade_employee ge ON ((ge.id = gp.id_grade)));

CREATE VIEW "public".v_statistiques_nb_vente_par_style_par_mois_current_year AS  SELECT swam.month,
    swam.id_style,
    swam.nom_style,
    swam.status_style,
    COALESCE(nbvpspm.nb_vente, (0)::bigint) AS nb_vente
   FROM (v_style_with_all_months swam
     LEFT JOIN v_nb_vente_par_style_par_mois_current_year nbvpspm ON (((nbvpspm.id_style = swam.id_style) AND (nbvpspm.month = (swam.month)::numeric))));

CREATE VIEW "public".v_stock_materiel_restante AS  SELECT vlms.id_materiel,
    vlms.sum AS reste,
    m.nom AS nom_materiel,
    u.id AS id_unite,
    u.nom AS nom_unite
   FROM ((( SELECT s.id_materiel,
            sum(s.nombre) AS sum
           FROM stock_materiel s
          GROUP BY s.id_materiel) vlms
     JOIN materiel m ON ((m.id = vlms.id_materiel)))
     JOIN unite u ON ((u.id = m.id_unite)));

CREATE VIEW "public".v_stock_meuble_restante AS  SELECT r.id,
    max(r.id_style) AS id_style,
    max(r.id_volume) AS id_volume,
    max(r.status) AS status,
    max(r.id_produit) AS id_produit,
    max((r.nom_style)::text) AS nom_style,
    max(r.longueur) AS longueur,
    max(r.largeur) AS largeur,
    max(r.hauteur) AS hauteur,
    max((r.nom_volume)::text) AS nom_volume,
    max(r.id_categorie) AS id_categorie,
    max((r.nom_categorie)::text) AS nom_categorie,
    max((r.nom_produit)::text) AS nom_produit,
    COALESCE(sum(c.quantite), (0)::bigint) AS quantite
   FROM (stock_meuble c
     RIGHT JOIN v_meuble r ON ((r.id = c.id_meuble)))
  GROUP BY r.id;

CREATE VIEW "public".v_style_materiel AS  SELECT sm.id,
    s.id AS id_style,
    s.nom AS nom_style,
    vm.id_materiel,
    vm.nom_materiel,
    vm.id_unite,
    vm.nom_unite
   FROM ((style_materiel sm
     JOIN v_materiel vm ON ((vm.id_materiel = sm.id_materiel)))
     JOIN style s ON ((s.id = sm.id_style)));

CREATE VIEW "public".v_style_with_all_months AS  WITH all_months AS (
         SELECT generate_series(1, 12) AS month
        )
 SELECT am.month,
    s.id AS id_style,
    s.nom AS nom_style,
    s.status AS status_style
   FROM (all_months am
     JOIN style s ON (true))
  GROUP BY am.month, s.id;

CREATE VIEW "public".v_taux_salaire_employee AS  SELECT e.id,
    e.nom,
    e.prenom,
    e.status,
    e.date_naissance,
    te.nom AS nom_type,
    te.taux_horaire AS taux_horaire_type,
    emp.date_embauche,
    age((emp.date_embauche)::timestamp with time zone) AS anciennete,
    max(gp.x_fois_taux_salaire) AS x_fois_taux_salaire,
    max((g.nom)::text) AS nom_grade
   FROM ((((employee e
     JOIN employement emp ON ((e.id = emp.id_employee)))
     JOIN type_employee te ON ((emp.id_type_employee = te.id)))
     LEFT JOIN grade_params gp ON ((((EXTRACT(epoch FROM age((emp.date_embauche)::timestamp with time zone)) / (31536000)::numeric) - (gp.years)::numeric) = ( SELECT min(((EXTRACT(epoch FROM age((emp.date_embauche)::timestamp with time zone)) / (31536000)::numeric) - (gp2.years)::numeric)) AS min
           FROM grade_params gp2
          WHERE ((EXTRACT(epoch FROM age((emp.date_embauche)::timestamp with time zone)) / (31536000)::numeric) >= (gp2.years)::numeric)))))
     JOIN grade_employee g ON ((g.id = gp.id_grade)))
  GROUP BY e.id, e.nom, e.prenom, e.status, e.date_naissance, te.nom, te.taux_horaire, emp.date_embauche;

CREATE VIEW "public".v_vente AS  SELECT v.id,
    v.id_meuble,
    v.id_client,
    v.quantite,
    v.date_,
    v.status,
    c.nom AS nom_client,
    c.prenom AS prenom_client,
    c.email AS email_client,
    c.id_sexe,
    s.nom AS nom_sexe,
    c.status AS status_client,
    c.date_naissance AS dtn_client,
    vm.id_style AS id_style_meuble,
    vm.id_volume AS id_volume_meuble,
    vm.status AS status_meuble,
    vm.id_produit AS id_produit_meuble,
    vm.nom_style AS nom_style_meuble,
    vm.longueur AS longueur_meuble,
    vm.largeur AS largeur_meuble,
    vm.hauteur AS hauteur_meuble,
    vm.nom_volume AS nom_volume_meuble,
    vm.id_categorie AS id_categorie_meuble,
    vm.nom_categorie AS nom_categorie_meuble,
    vm.nom_produit AS nom_produit_meuble
   FROM (((stock_meuble v
     JOIN client c ON ((c.id = v.id_client)))
     JOIN v_meuble vm ON ((vm.id = v.id_meuble)))
     JOIN sexe s ON ((s.id = c.id_sexe)))
  WHERE (v.id_client IS NOT NULL);

INSERT INTO "public".categorie( id, nom, status ) VALUES ( 1, 'Chaise', 0);
INSERT INTO "public".categorie( id, nom, status ) VALUES ( 3, 'Table', 0);
INSERT INTO "public".categorie( id, nom, status ) VALUES ( 6, 'Armoir', 0);
INSERT INTO "public".employee( id, nom, prenom, status, date_naissance ) VALUES ( 1, 'N.', 'Voary', 0, '1986-10-22');
INSERT INTO "public".employee( id, nom, prenom, status, date_naissance ) VALUES ( 3, 'N.', 'Eric', 0, '2000-01-23');
INSERT INTO "public".employee( id, nom, prenom, status, date_naissance ) VALUES ( 4, 'N.', 'Toavina', 0, '2003-08-26');
INSERT INTO "public".employee( id, nom, prenom, status, date_naissance ) VALUES ( 5, 'N.', 'Rajoelina', 0, '1960-01-01');
INSERT INTO "public".employee( id, nom, prenom, status, date_naissance ) VALUES ( 6, 'N.', 'Siteny', 0, '1942-01-01');
INSERT INTO "public".grade_employee( id, nom, status ) VALUES ( 1, 'Ouvrier', 0);
INSERT INTO "public".grade_employee( id, nom, status ) VALUES ( 2, 'Senior', 0);
INSERT INTO "public".grade_employee( id, nom, status ) VALUES ( 3, 'Expert', 0);
INSERT INTO "public".grade_params( id, id_grade, years, x_fois_taux_salaire, date_ ) VALUES ( 1, 1, 0, 1.0, '2000-01-01 01:01:00 AM');
INSERT INTO "public".grade_params( id, id_grade, years, x_fois_taux_salaire, date_ ) VALUES ( 2, 2, 2, 2.0, '2000-01-01 12:00:00 AM');
INSERT INTO "public".grade_params( id, id_grade, years, x_fois_taux_salaire, date_ ) VALUES ( 3, 3, 5, 3.0, '2000-01-01 12:00:00 AM');
INSERT INTO "public".personne( id, nom, prenom, dtn, email, mdp ) VALUES ( 1, 'ANDRIANAIVOSOA', 'Johan Anjaratiana', '2003-08-26', 'johan@gmail.com', 'johan');
INSERT INTO "public".personne( id, nom, prenom, dtn, email, mdp ) VALUES ( 2, 'ANDRIANAIVOSOA', 'Logan', '2003-10-15', 'logan@gmail.com', 'logan');
INSERT INTO "public".personne( id, nom, prenom, dtn, email, mdp ) VALUES ( 3, 'MANJA', 'Mirana', '2005-12-25', 'tsaramiranaandriambelo@gmail.com', ' ');
INSERT INTO "public".produit( id, nom, status, id_categorie ) VALUES ( 6, 'Canapé', 0, 1);
INSERT INTO "public".produit( id, nom, status, id_categorie ) VALUES ( 7, 'Chaise pliante', 0, 1);
INSERT INTO "public".produit( id, nom, status, id_categorie ) VALUES ( 8, 'Table rustica', 0, 3);
INSERT INTO "public".produit( id, nom, status, id_categorie ) VALUES ( 10, 'Table brun', 0, 3);
INSERT INTO "public".sexe( id, nom, status ) VALUES ( 2, 'Homme', 0);
INSERT INTO "public".sexe( id, nom, status ) VALUES ( 3, 'Femme', 0);
INSERT INTO "public"."style"( id, nom, status ) VALUES ( 1, 'Royal', 0);
INSERT INTO "public"."style"( id, nom, status ) VALUES ( 2, 'Scandinave', 0);
INSERT INTO "public"."style"( id, nom, status ) VALUES ( 3, 'Boheme', 0);
INSERT INTO "public"."style"( id, nom, status ) VALUES ( 4, 'Shaker', 0);
INSERT INTO "public"."style"( id, nom, status ) VALUES ( 5, 'Mid-Century Modern', 0);
INSERT INTO "public".type_employee( id, nom, taux_horaire, date_ ) VALUES ( 4, 'Designer', 90000.0, '2024-01-16 04:24:59 PM');
INSERT INTO "public".type_employee( id, nom, taux_horaire, date_ ) VALUES ( 5, 'Architect', 110000.0, '2024-01-16 04:25:06 PM');
INSERT INTO "public".type_employee( id, nom, taux_horaire, date_ ) VALUES ( 6, 'Menuisier', 50000.0, '2024-01-16 04:25:20 PM');
INSERT INTO "public".unite( id, nom, status ) VALUES ( 1, 'Planche', 0);
INSERT INTO "public".unite( id, nom, status ) VALUES ( 2, 'Unité / Pièce', 0);
INSERT INTO "public".unite( id, nom, status ) VALUES ( 4, 'kg', 0);
INSERT INTO "public".unite( id, nom, status ) VALUES ( 3, 'm³', 0);
INSERT INTO "public".volume( id, longueur, largeur, hauteur, status, nom ) VALUES ( 4, 10.0, 20.0, 30.0, 0, 'PM');
INSERT INTO "public".volume( id, longueur, largeur, hauteur, status, nom ) VALUES ( 5, 40.0, 35.5, 50.0, 0, 'GM');
INSERT INTO "public".volume( id, longueur, largeur, hauteur, status, nom ) VALUES ( 6, 65.0, 20.0, 13.0, 0, 'PM');
INSERT INTO "public".client( id, nom, prenom, email, id_sexe, status, date_naissance ) VALUES ( 2, 'C.', 'Fitahiana', 'fi@gmail.com', 3, 0, '2000-01-10');
INSERT INTO "public".client( id, nom, prenom, email, id_sexe, status, date_naissance ) VALUES ( 3, 'C.', 'Njara', 'nj@gmail.com', 3, 0, '2001-01-01');
INSERT INTO "public".client( id, nom, prenom, email, id_sexe, status, date_naissance ) VALUES ( 4, 'C.', 'Henintsoa', 'he@gmail.com', 3, 0, '2004-01-01');
INSERT INTO "public".client( id, nom, prenom, email, id_sexe, status, date_naissance ) VALUES ( 5, 'C.', 'Manda', 'ma@gmail.com', 2, 0, '1999-01-01');
INSERT INTO "public".client( id, nom, prenom, email, id_sexe, status, date_naissance ) VALUES ( 6, 'C.', 'Joda', 'jo@gmail.com', 2, 0, '1990-01-01');
INSERT INTO "public".client( id, nom, prenom, email, id_sexe, status, date_naissance ) VALUES ( 8, 'C.', 'Mandresy', 'mandresy@gmail.com', 2, 0, '1985-02-01');
INSERT INTO "public".employement( id, id_employee, id_type_employee, date_embauche, status ) VALUES ( 2, 1, 4, '2001-01-01', 0);
INSERT INTO "public".employement( id, id_employee, id_type_employee, date_embauche, status ) VALUES ( 3, 1, 5, '2022-02-22', 0);
INSERT INTO "public".employement( id, id_employee, id_type_employee, date_embauche, status ) VALUES ( 5, 5, 4, '2021-01-01', 0);
INSERT INTO "public".employement( id, id_employee, id_type_employee, date_embauche, status ) VALUES ( 6, 6, 5, '2017-01-01', 0);
INSERT INTO "public".materiel( id, nom, id_unite, status ) VALUES ( 4, 'Verre', 2, 0);
INSERT INTO "public".materiel( id, nom, id_unite, status ) VALUES ( 5, 'Fer', 2, 0);
INSERT INTO "public".materiel( id, nom, id_unite, status ) VALUES ( 6, 'Clou', 2, 0);
INSERT INTO "public".materiel( id, nom, id_unite, status ) VALUES ( 3, 'Bois', 1, 0);
INSERT INTO "public".materiel( id, nom, id_unite, status ) VALUES ( 8, 'Pierre', 3, 0);
INSERT INTO "public".meuble( id, id_style, id_volume, status, id_produit ) VALUES ( 5, 1, 4, 0, 6);
INSERT INTO "public".meuble( id, id_style, id_volume, status, id_produit ) VALUES ( 6, 1, 5, 0, 6);
INSERT INTO "public".meuble( id, id_style, id_volume, status, id_produit ) VALUES ( 8, 2, 4, 0, 6);
INSERT INTO "public".meuble( id, id_style, id_volume, status, id_produit ) VALUES ( 9, 2, 5, 0, 6);
INSERT INTO "public".meuble( id, id_style, id_volume, status, id_produit ) VALUES ( 10, 3, 4, 0, 8);
INSERT INTO "public".mode_fabrication( id, id_meuble, id_type_employee, duree, date_, nombre ) VALUES ( 11, 5, 6, 4, '2024-01-18 03:48:07 PM', 4);
INSERT INTO "public".mode_fabrication( id, id_meuble, id_type_employee, duree, date_, nombre ) VALUES ( 13, 10, 4, 3, '2024-02-02 10:40:42 AM', 1);
INSERT INTO "public".prix_materiel( id, id_materiel, prix_unitaire, date_ ) VALUES ( 1, 4, 10.0, '2024-01-11 01:56:17 PM');
INSERT INTO "public".prix_materiel( id, id_materiel, prix_unitaire, date_ ) VALUES ( 2, 4, 29.0, '2024-01-11 01:56:23 PM');
INSERT INTO "public".prix_materiel( id, id_materiel, prix_unitaire, date_ ) VALUES ( 3, 5, 29.0, '2024-01-11 01:59:25 PM');
INSERT INTO "public".prix_materiel( id, id_materiel, prix_unitaire, date_ ) VALUES ( 4, 5, 25.0, '2024-01-11 01:59:35 PM');
INSERT INTO "public".prix_materiel( id, id_materiel, prix_unitaire, date_ ) VALUES ( 5, 6, 10.0, '2024-01-16 04:49:37 PM');
INSERT INTO "public".prix_materiel( id, id_materiel, prix_unitaire, date_ ) VALUES ( 6, 3, 31.0, '2024-01-16 04:49:47 PM');
INSERT INTO "public".prix_materiel( id, id_materiel, prix_unitaire, date_ ) VALUES ( 8, 8, 50.0, '2024-01-16 08:02:43 PM');
INSERT INTO "public".prix_meuble( id, id_meuble, prix_vente, date_ ) VALUES ( 18, 5, 1325000.0, '2024-02-02 11:51:06 AM');
INSERT INTO "public".prix_meuble( id, id_meuble, prix_vente, date_ ) VALUES ( 14, 10, 950000.0, '2024-02-02 11:46:35 AM');
INSERT INTO "public".quantite_outils( id, id_meuble, id_materiel, quantite, status ) VALUES ( 24, 5, 4, 10.0, 0);
INSERT INTO "public".quantite_outils( id, id_meuble, id_materiel, quantite, status ) VALUES ( 26, 5, 5, 15.0, 0);
INSERT INTO "public".quantite_outils( id, id_meuble, id_materiel, quantite, status ) VALUES ( 29, 10, 3, 23.0, 0);
INSERT INTO "public".quantite_outils( id, id_meuble, id_materiel, quantite, status ) VALUES ( 31, 10, 6, 46.0, 0);
INSERT INTO "public".stock_meuble( id, id_meuble, quantite, date_, id_client, status ) VALUES ( 12, 5, 3, '2024-01-18 03:58:31 PM', null, 0);
INSERT INTO "public".stock_meuble( id, id_meuble, quantite, date_, id_client, status ) VALUES ( 20, 10, 11, '2024-02-02 11:12:34 AM', null, 0);
INSERT INTO "public".stock_meuble( id, id_meuble, quantite, date_, id_client, status ) VALUES ( 21, 5, 10, '2024-02-02 11:13:12 AM', null, 0);
INSERT INTO "public".stock_meuble( id, id_meuble, quantite, date_, id_client, status ) VALUES ( 22, 5, -3, '2024-02-02 11:18:00 AM', 4, 0);
INSERT INTO "public".stock_meuble( id, id_meuble, quantite, date_, id_client, status ) VALUES ( 23, 10, -5, '2024-02-02 11:18:00 AM', 4, 0);
INSERT INTO "public".stock_meuble( id, id_meuble, quantite, date_, id_client, status ) VALUES ( 24, 10, -3, '2024-02-02 11:19:00 AM', 5, 0);
INSERT INTO "public".stock_meuble( id, id_meuble, quantite, date_, id_client, status ) VALUES ( 25, 5, -5, '2024-02-02 11:19:00 AM', 5, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 9, 1, 4, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 10, 1, 5, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 11, 1, 6, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 12, 1, 3, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 13, 1, 8, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 19, 3, 4, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 20, 3, 5, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 21, 3, 6, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 23, 3, 3, 0);
INSERT INTO "public".style_materiel( id, id_style, id_materiel, status ) VALUES ( 24, 3, 8, 0);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 1, 5, 10.0, '2024-01-11 02:22:25 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 2, 5, 12.0, '2024-01-11 02:22:32 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 3, 3, 9.0, '2024-01-11 02:22:39 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 4, 3, 4.0, '2024-01-11 02:22:44 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 5, 3, 7.0, '2024-01-11 03:00:50 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 6, 4, 20.0, '2024-01-11 03:01:07 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 17, 4, 19.0, '2024-01-18 02:58:51 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 18, 5, 23.0, '2024-01-18 03:58:15 PM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 19, 5, -45.0, '2024-01-18 03:58:31 PM', 12);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 20, 4, -30.0, '2024-01-18 03:58:31 PM', 12);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 21, 5, 15.0, '2024-01-31 08:37:05 AM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 22, 6, 10000.0, '2024-02-02 10:45:41 AM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 23, 3, 46700.0, '2024-02-02 10:45:56 AM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 24, 5, 30800.0, '2024-02-02 10:46:18 AM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 25, 4, 60000.0, '2024-02-02 10:46:31 AM', null);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 26, 3, -253.0, '2024-02-02 11:12:34 AM', 20);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 27, 6, -506.0, '2024-02-02 11:12:35 AM', 20);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 28, 5, -150.0, '2024-02-02 11:13:13 AM', 21);
INSERT INTO "public".stock_materiel( id, id_materiel, nombre, date_, id_fabrication ) VALUES ( 29, 4, -100.0, '2024-02-02 11:13:13 AM', 21);