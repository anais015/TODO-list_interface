-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 14 mai 2022 à 20:24
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
-- Base de données : `ale_todolist_interface`
--

-- --------------------------------------------------------

--
-- Structure de la table `liste`
--

DROP TABLE IF EXISTS `liste`;
CREATE TABLE IF NOT EXISTS `liste` (
  `id_liste` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `ref_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_liste`),
  KEY `fk_liste_user` (`ref_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `liste`
--

INSERT INTO `liste` (`id_liste`, `nom`, `ref_user`) VALUES
(1, 'groceries', 1),
(2, 'my', 1),
(3, 'coucou', 2),
(5, 'test', NULL),
(6, 'testest', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
  `id_tache` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `estTerminee` tinyint(1) NOT NULL DEFAULT '0',
  `deadline` date NOT NULL,
  `ref_type` int(11) DEFAULT NULL,
  `ref_liste` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_tache`),
  KEY `fk_tache_liste` (`ref_liste`),
  KEY `fk_tache_type` (`ref_type`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id_tache`, `nom`, `estTerminee`, `deadline`, `ref_type`, `ref_liste`, `description`) VALUES
(3, 'conceptualiser une stratégie marketing', 0, '2022-03-04', 3, 1, NULL),
(7, 'contact caf', 1, '2022-03-07', 1, 1, NULL),
(8, 'estimer le budget', 0, '2022-03-19', 2, 1, NULL),
(9, 'cook', 0, '2022-04-03', 4, 1, NULL),
(10, 'debug1', 0, '2022-12-12', 3, 1, NULL),
(11, 'debug2', 0, '2022-12-12', 4, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `id_type` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`id_type`, `nom`) VALUES
(1, 'Administrative'),
(2, 'Finance'),
(3, 'Marketing'),
(4, 'Relation Client'),
(6, 'Shopping'),
(7, 'Youpii'),
(8, 'coucou');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `email`, `password`) VALUES
(1, 'Le', 'Hai My', 'my@todolist.com', '123456'),
(2, 'Lemaire', 'Anaïs', 'anais@todolist.com', '123456'),
(3, 'Lemoine', 'Monsieur', 'lemoine@todolist.com', '123456'),
(4, 'Matteï', 'Monsieur', 'mattei@todolist.com', '123456'),
(5, 'Bon', 'jour', 'Bonjour@live.fr', 'Bonjour'),
(6, 'cc', 'cc', 'cc', 'cc'),
(7, 'bb', 'bb', 'bb', 'bb');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `liste`
--
ALTER TABLE `liste`
  ADD CONSTRAINT `fk_liste_user` FOREIGN KEY (`ref_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `fk_tache_liste` FOREIGN KEY (`ref_liste`) REFERENCES `liste` (`id_liste`),
  ADD CONSTRAINT `fk_tache_type` FOREIGN KEY (`ref_type`) REFERENCES `type` (`id_type`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
