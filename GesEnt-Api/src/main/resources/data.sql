DROP TABLE IF EXISTS achat;
CREATE TABLE achat(
    id_achat INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    numero_achat INTEGER,
    date_achat DATETIME,
    liste_produit INTEGER,
    liste_client INTEGER
);

DROP TABLE IF EXISTS client;
CREATE TABLE client(
    id_client INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numeros_client INTEGER NOT NULL,
    historique_achat INTEGER
);

DROP TABLE IF EXISTS entreprise;
CREATE TABLE entreprise(
    id_fournisseur INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    nom VARCHAR(255),
    siret VARCHAR(255),
    adresse VARCHAR(255),
    liste_employer INTEGER,
    liste_produit INTEGER,
    liste_achat INTEGER
);

DROP TABLE IF EXISTS fournisseur;
CREATE TABLE fournisseur(
    id_fournisseur INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numeros_fournie INTEGER,
    produit_fournie INTEGER
);


DROP TABLE IF EXISTS produit;
CREATE TABLE produit(
    id_produit INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    reference VARCHAR(255),
    nom VARCHAR(255),
    prix DOUBLE,
    liste_fournisseur INTEGER
);

DROP TABLE IF EXISTS salarie;
CREATE TABLE salarie(
    id_salarie INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    matricule VARCHAR(255),
    departement VARCHAR(255),
    poste VARCHAR(255),
    salaire DOUBLE
);

ALTER TABLE achat ADD FOREIGN KEY (liste_produit) REFERENCES produit(id_produit);
ALTER TABLE achat ADD FOREIGN KEY (liste_client) REFERENCES client(id_client);

ALTER TABLE client ADD FOREIGN KEY (historique_achat) REFERENCES achat(id_achat);

ALTER TABLE entreprise ADD FOREIGN KEY (liste_employer) REFERENCES salarie(id_salarie);
ALTER TABLE entreprise ADD FOREIGN KEY (liste_produit) REFERENCES produit(id_produit);
ALTER TABLE entreprise ADD FOREIGN KEY (liste_achat) REFERENCES achat(id_achat);

ALTER TABLE fournisseur ADD FOREIGN KEY (produit_fournie) REFERENCES produit(id_produit);

ALTER TABLE produit ADD FOREIGN KEY (liste_fournisseur) REFERENCES fournisseur(id_fournisseur);

