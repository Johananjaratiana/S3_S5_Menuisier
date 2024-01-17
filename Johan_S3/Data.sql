CREATE VIEW "public".v_filtre_produit_by_prix AS  SELECT 
	qm.id_reference
	max((r.nom_produit)::text) AS nom_produit,
    max((r.nom_categorie)::text) AS nom_categorie,
    max(r.longueur) AS longueur,
    max(r.largeur) AS largeur,
    max(r.hauteur) AS hauteur,
    sum(pm.prix_unitaire) AS sum,
    max((r.nom_style)::text) AS nom_style,
    max((r.nom_volume)::text) AS nom_volume
   FROM (((v_reference r
     JOIN quantite_outils qm ON ((r.id = qm.id_reference)))
     JOIN materiel m ON ((m.id = qm.id_materiel)))
     JOIN v_prix_materiel pm ON ((pm.id_materiel = qm.id_materiel)))
  GROUP BY qm.id_reference;
