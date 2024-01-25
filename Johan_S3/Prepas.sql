create view v_vente as
SELECT 
    v.*,
    c.nom as nom_client, 
    c.prenom as prenom_client, 
    c.email as email_client, 
    c.id_sexe as id_sexe,
    s.nom as nom_sexe, 
    c.status as status_client, 
    c.date_naissance as dtn_client,
    vm.id_style as id_style_meuble, 
    vm.id_volume as id_volume_meuble, 
    vm.status as status_meuble, 
    vm.id_produit as id_produit_meuble, 
    vm.nom_style as nom_style_meuble, 
    vm.longueur as longueur_meuble, 
    vm.largeur as largeur_meuble, 
    vm.hauteur as hauteur_meuble, 
    vm.nom_volume as nom_volume_meuble, 
    vm.id_categorie as id_categorie_meuble, 
    vm.nom_categorie as nom_categorie_meuble, 
    vm.nom_produit as nom_produit_meuble
    from vente v
    join client c on  c.id = v.id_client
    join v_meuble vm on vm.id = v.id_meuble
    join sexe s on s.id = c.id_sexe


SELECT 
    SUM(nb) as total,
    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 2 ), 0) as nb_homme,
    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 3 ), 0) as nb_femme
    from vente

SELECT 
    SUM(nb) as total,
    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 2 and id_meuble = ? ), 0) as nb_homme,
    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 3 and id_meuble = ? ), 0) as nb_femme
    from vente
    where id_meuble = ?



