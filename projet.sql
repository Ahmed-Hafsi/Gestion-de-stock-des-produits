-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 20 sep. 2022 à 12:21
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAgent` int(11) NOT NULL,
  `idProduit1` varchar(11) NOT NULL,
  `quantite1` float NOT NULL,
  `idProduit2` varchar(11) DEFAULT NULL,
  `quantite2` float DEFAULT NULL,
  `idProduit3` varchar(11) DEFAULT NULL,
  `quantite3` float DEFAULT NULL,
  `idProduit4` varchar(11) DEFAULT NULL,
  `quantite4` float DEFAULT NULL,
  `idProduit5` varchar(11) DEFAULT NULL,
  `quantite5` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `idAgent`, `idProduit1`, `quantite1`, `idProduit2`, `quantite2`, `idProduit3`, `quantite3`, `idProduit4`, `quantite4`, `idProduit5`, `quantite5`) VALUES
(12, 5274, 'ahmeed', 0, 'ahmeed', 0, 'ahmeed', 0, 'ahmeed', 0, 'ahmeed', 0),
(13, 123, 'ahmeed', 10, 'ahmeed', 11, 'ahmeed', 0, 'ahmeed', 0, 'ahmeed', 0),
(14, 123, '00000000', 0, '00000000', 0, '00000000', 0, '00000000', 0, '00000000', 0);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id` int(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `adresse` varchar(20) NOT NULL,
  `tel` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `nom`, `adresse`, `tel`) VALUES
(3, 'seif', 'seif', 24564525),
(2, 'ahmed', 'ahmed', 25545256),
(1, 'karam', 'karam', 25252525);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` varchar(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `quantite` float NOT NULL,
  `prix` float NOT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `quantite`, `prix`, `fournisseur`) VALUES
('00000000', 'null', 0, 0, 'null');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `adresse` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `adresse`, `role`, `password`) VALUES
(11111111, 'karam', 'youssef', 'kassba', 'RH', '123456'),
(22222222, 'ahmed', 'hafsi', 'nefza', 'Responsable', '123456'),
(33333333, 'seif', 'arfaoui', '18janvier', 'Technicien', '123456');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
