CREATE DATABASE examenServlet;
Use examenServlet;
CREATE TABLE servletuser (
    id INT AUTO_INCREMENT PRIMARY key,
    nom VARCHAR(50),
    mot_de_passe VARCHAR(50)
);


CREATE TABLE servletprevision (
    id INT AUTO_INCREMENT PRIMARY key,
    libelle VARCHAR(50),
    montant DECIMAL(10,2)

);
CREATE TABLE servletdepense (
    id INT AUTO_INCREMENT PRIMARY key,
    id_prevision INT,
    montant DECIMAL(10,2)
);