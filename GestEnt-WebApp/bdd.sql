DROP TABLE IF EXISTS 'achat';
CREATE TABLE achat(
    id_achat INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    numero_achat INTEGER,
    liste_produit CONSTRAINT 'achatId' FOREIGN KEY ('id_achat') REFERENCES 'achat' ('id_achat') ON DELETE CASCADE ON UPDATE CASCADE,
    liste_client CONSTRAINT 'clientId' FOREIGN KEY ('id_client') REFERENCES 'client' ('id_client') ON DELETE CASCADE ON UPDATE CASCADE,
    date_achat DATETIME
);

DROP TABLE IF EXISTS 'client';
CREATE TABLE client(
    client_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numeros_client INTEGER NOT NULL,
    historique_achat
);

DROP TABLE IF EXISTS 'fournisseur';
CREATE TABLE fournisseur(
    id_fournisseur INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numeros_fournie INTEGER,
    produit_fournie
);

DROP TABLE IF EXISTS 'produit';
CREATE TABLE produit(
    id_produit INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    reference VARCHAR(255),
    nom VARCHAR(255),
    prix DOUBLE,
    fournisseurs
);


DROP TABLE IF EXISTS 'entreprise';
CREATE TABLE entreprise(
    id_fournisseur INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    nom VARCHAR(255),
    siret VARCHAR(255),
    adresse VARCHAR(255),
    liste_employer ,
    liste_produit
);