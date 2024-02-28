-- SELECT e.id,
--     e.nom,
--     e.prenom,
--     e.status,
--     e.date_naissance,
--     te.nom AS nom_type,
--     te.taux_horaire AS taux_horaire_type,
--     emp.date_embauche,
--     age((emp.date_embauche)::timestamp with time zone) AS anciennete,
--         CASE
--             WHEN (age((emp.date_embauche)::timestamp with time zone) >= '5 years'::interval) THEN (te.taux_horaire * (3)::double precision)
--             WHEN ((age((emp.date_embauche)::timestamp with time zone) >= '2 years'::interval) AND (age((emp.date_embauche)::timestamp with time zone) < '5 years'::interval)) THEN (te.taux_horaire * (2)::double precision)
--             ELSE te.taux_horaire
--         END AS taux_horaire,
--         CASE
--             WHEN (age((emp.date_embauche)::timestamp with time zone) >= '5 years'::interval) THEN 'expert'::text
--             WHEN ((age((emp.date_embauche)::timestamp with time zone) >= '2 years'::interval) AND (age((emp.date_embauche)::timestamp with time zone) < '5 years'::interval)) THEN 'senior'::text
--             ELSE 'ouvrier'::text
--         END AS grade
--    FROM ((employee e
--      JOIN employement emp ON ((e.id = emp.id_employee)))
--      JOIN type_employee te ON ((emp.id_type_employee = te.id)));

----------------------------- SALAIRE

SELECT e.id,
    e.nom,
    e.prenom,
    e.status,
    e.date_naissance,
    te.nom AS nom_type,
    te.taux_horaire AS taux_horaire_type,
    emp.date_embauche,
    age((emp.date_embauche)::timestamp with time zone) AS anciennete,
    MAX(gp.x_fois_taux_salaire) AS x_fois_taux_salaire,
    MAX(g.nom) AS nom_grade
FROM ((employee e
     JOIN employement emp ON ((e.id = emp.id_employee)))
     JOIN type_employee te ON ((emp.id_type_employee = te.id)))
LEFT JOIN grade_params gp 
    ON (EXTRACT(EPOCH FROM age((emp.date_embauche)::timestamp with time zone)) / 31536000 - gp.years)
         = (SELECT MIN(EXTRACT(EPOCH FROM age((emp.date_embauche)::timestamp with time zone)) / 31536000 - gp2.years)
        FROM grade_params gp2
        WHERE EXTRACT(EPOCH FROM age((emp.date_embauche)::timestamp with time zone)) / 31536000 >= gp2.years)
JOIN grade_employee g ON g.id = gp.id_grade
GROUP BY e.id, e.nom, e.prenom, e.status, e.date_naissance, te.nom, te.taux_horaire, emp.date_embauche;


------------------------- STATISTIQUES MEUBLE - SEXE  ----------------------------------------

SELECT 
    -SUM(quantite) as total,
    COALESCE((SELECT -SUM(quantite) from v_vente where id_sexe = 2 ), 0) as nb_homme,
    COALESCE((SELECT -SUM(quantite) from v_vente where id_sexe = 3 ), 0) as nb_femme
    FROM stock_meuble WHERE quantite < 0

SELECT 
    -SUM(quantite) as total,
    COALESCE((SELECT -SUM(quantite) from v_vente where id_sexe = 2 and id_meuble = ? ), 0) as nb_homme,
    COALESCE((SELECT -SUM(quantite) from v_vente where id_sexe = 3 and id_meuble = ? ), 0) as nb_femme
    from stock_meuble
    where id_meuble = ? and quantite < 0



------------------------- STATISTIQUES NB VENTE PAR MOIS ----------------------------------------

CREATE VIEW v_nb_vente_par_style_par_mois_current_year as
    (SELECT vm.id_style, COALESCE(-SUM(sm.quantite),0) as nb_vente,EXTRACT(month FROM sm.date_) as month
        FROM stock_meuble sm
        JOIN v_meuble vm ON vm.id = sm.id_meuble
        WHERE
            sm.quantite < 0
            AND EXTRACT(year FROM sm.date_) = EXTRACT(year FROM CURRENT_DATE)
        GROUP BY vm.id_style, EXTRACT(month FROM sm.date_)
    )  

CREATE VIEW v_style_with_all_months AS 

    WITH all_months AS (
        SELECT generate_series(1, 12) AS month
    )

    SELECT
        am.month as month,
        s.id as id_style,
        s.nom as nom_style,
        s.status as status_style
    FROM
        all_months am
    JOIN 
        style s ON true
    GROUP BY
        am.month, s.id;

CREATE VIEW v_statistiques_nb_vente_par_style_par_mois_current_year as
    (SELECT 
        swam.*,
        COALESCE(nbvpspm.nb_vente, 0) AS nb_vente
        FROM 
            v_style_with_all_months swam
        LEFT JOIN
            v_nb_vente_par_style_par_mois_current_year nbvpspm 
                ON nbvpspm.id_style = swam.id_style 
                AND nbvpspm.month = swam.month
    )



