-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-04-2014 a las 11:59:34
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`id`, `Nombre`) VALUES
(1, 'Inicio'),
(2, 'Menu.2'),
(3, 'Menu.3'),
(4, 'Menu.4'),
(5, 'Menu.5'),
(6, 'Menu.6'),
(7, 'Menu.7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `submenu`
--

CREATE TABLE IF NOT EXISTS `submenu` (
  `id` int(4) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `jspf` varchar(40) NOT NULL,
  `id_padre` int(4) NOT NULL,
  KEY `id_padre` (`id_padre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `submenu`
--

INSERT INTO `submenu` (`id`, `nombre`, `jspf`, `id_padre`) VALUES
(1, 'SubMenu.2.1', 'hola.jspf', 2),
(2, 'SubMenu.2.2', 'WEB-INF/jspf/fragmento.jspf', 2),
(3, 'SubMenu.2.3', 'WEB-INF/jspf/fragmento.jspf', 2),
(1, 'SubMenu.3.1', 'SubMenu.3.1', 3),
(1, 'SubMenu.4.1', 'SubMenu.4.1', 4),
(2, 'SubMenu.4.2', 'SubMenu.4.2', 4),
(3, 'SubMenu.4.3', 'SubMenu.4.3', 4),
(4, 'SubMenu.4.4', 'SubMenu.4.4', 4),
(5, 'SubMenu.4.5', 'SubMenu.4.5', 4),
(1, 'SubMenu.5.1', 'SubMenu.5.1', 5),
(2, 'SubMenu.5.2', 'SubMenu.5.2', 5),
(1, 'SubMenu.6.1', 'SubMenu.6.1', 6),
(2, 'SubMenu.6.2', 'SubMenu.6.2', 6),
(3, 'SubMenu.6.3', 'SubMenu.6.3', 6),
(4, 'SubMenu.6.4', 'SubMenu.6.4', 6),
(1, 'SubMenu.7.1', 'SubMenu.7.1', 7),
(2, 'SubMenu.7.2', 'SubMenu.7.2', 7),
(3, 'SubMenu.7.3', 'SubMenu.7.3', 7),
(1, 'Inicio', 'WEB-INF/jspf/fragmento.jspf', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `submenu`
--
ALTER TABLE `submenu`
  ADD CONSTRAINT `submenu_ibfk_1` FOREIGN KEY (`id_padre`) REFERENCES `menu` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
