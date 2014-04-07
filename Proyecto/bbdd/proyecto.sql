-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 07-04-2014 a las 00:33:42
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

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
-- Estructura de tabla para la tabla `calendario`
--

CREATE TABLE IF NOT EXISTS `calendario` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `id_categoria` int(2) NOT NULL,
  `jornada` int(2) NOT NULL,
  `fecha` date NOT NULL,
  `id_equipo_local` int(4) NOT NULL,
  `id_equipo_visitante` int(4) NOT NULL,
  `victorias_local` int(2) NOT NULL,
  `victorias_visitante` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`,`id_equipo_local`,`id_equipo_visitante`),
  KEY `id_equipo_local` (`id_equipo_local`),
  KEY `id_equipo_visitante` (`id_equipo_visitante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) NOT NULL,
  `media_corte` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `media_corte`) VALUES
(1, 'Grupo 1', 3.5),
(2, 'Grupo 2', 2.5),
(3, 'Grupo 3', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE IF NOT EXISTS `clasificacion` (
  `id_equipo` int(4) NOT NULL,
  `puntos` int(4) NOT NULL,
  `partidas_jugadas` int(2) NOT NULL,
  `partidas_ganadas` int(2) NOT NULL,
  `juegos_ganados` int(4) NOT NULL,
  PRIMARY KEY (`id_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(25) NOT NULL,
  `id_local` int(4) NOT NULL,
  `id_categoria` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_local` (`id_local`),
  KEY `id_categoria` (`id_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id`, `Nombre`, `id_local`, `id_categoria`) VALUES
(1, 'Real Madrid', 1, 1),
(2, 'Los Pollos', 2, 1),
(3, 'Los de Marras', 3, 2),
(4, 'Calamares', 5, 3),
(5, 'Los Hombres de Paco', 11, 1),
(6, 'El Agujero', 14, 2),
(7, 'Los Borrachos', 8, 2),
(8, 'El Equipo A', 1, 1),
(9, 'Los Proskritos', 4, 1),
(10, 'Los Lobos', 2, 3),
(11, 'Perdidos', 7, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE IF NOT EXISTS `jugador` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Apodo` varchar(20) NOT NULL,
  `id_equipo` int(4) DEFAULT NULL,
  `Telefono` int(9) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Apodo` (`Apodo`),
  KEY `id_equipo` (`id_equipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id`, `Nombre`, `Apellido`, `Apodo`, `id_equipo`, `Telefono`, `email`) VALUES
(1, 'Jade', 'Lozano Zamudio', 'Jaloza', 2, 555986323, 'asdf@gmail.com'),
(2, 'Delmiro', 'Tello Trejo', 'Toorm1938', 1, 876195975, 'DelmiroTelloTrejo@gustr.com'),
(3, 'Josefa', 'Peralta Corral', 'Pannour', 5, 828836566, 'JosefaPeralta@surito.com'),
(4, 'Alejando', 'Mercado Amador', 'Harms1956', 11, 739034531, 'AlejandroMercado@suito.com'),
(5, 'Rudolph', 'Noakes', 'Durtural46', 8, 853832754, 'RudolphNoakes@superrito.com'),
(6, 'Benito', 'Floro B.', 'Benito Floro B.', 6, 678876987, 'asdf@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores_equipo`
--

CREATE TABLE IF NOT EXISTS `jugadores_equipo` (
  `id_jugador` int(4) NOT NULL,
  `id_equipo` int(4) NOT NULL,
  KEY `id_jugador` (`id_jugador`,`id_equipo`),
  KEY `id_equipo` (`id_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `local`
--

CREATE TABLE IF NOT EXISTS `local` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `localidad` varchar(25) NOT NULL,
  `telefono` int(9) NOT NULL,
  `num_dianas` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `local`
--

INSERT INTO `local` (`id`, `nombre`, `direccion`, `localidad`, `telefono`, `num_dianas`) VALUES
(1, 'Bar de la esquina', 'Calle mayor 23', 'Madrid', 555555555, 2),
(2, 'Don Pollo', 'Avda. de la ilustracion 132', 'Madrid', 555349124, 1),
(3, 'Los Delfines', 'Calle Mayor 13', 'Collado Villalba', 555349124, 2),
(4, 'Kalimocho', 'Avda. de Toledo 76', 'Madrid', 555349124, 1),
(5, 'Fritanga', 'Avda. de Toledo 34', 'Madrid', 555349124, 1),
(7, 'Aqui mismo', 'Plaza del 2 de Mayo 3', 'Las Rozas', 555349124, 2),
(8, 'Chiki', 'Paseo de Extremadura 9', 'Madrid', 555349124, 1),
(9, 'Uno más', 'Avda. de Toledo 34', 'Majadahonda', 555349124, 5),
(10, 'Waikiki', 'Avda. de Toledo 34', 'San Sebastian', 555349124, 2),
(11, 'Rincón de Paco', 'Paseo del adios 65', 'Mostoles', 555349124, 1),
(12, 'El Pollo', 'Calle Princesa 17', 'Madrid', 555349124, 4),
(13, 'El escondite', 'Avda. de Toledo 34', 'Madrid', 555349124, 1),
(14, 'Ozono', 'Plaza de la independencia 5', 'Alcobendas', 555349124, 1),
(15, 'Belle Epoque', 'Avda. de Toledo 34', 'Madrid', 555349124, 1);

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
(8, 'Administración'),
(5, 'Calendario'),
(6, 'Clasificación'),
(3, 'Equipos'),
(7, 'Estadisticas'),
(2, 'Jugadores'),
(4, 'Locales'),
(1, 'Portada');

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
(1, 'asdf', 'noticias', 1),
(1, 'Jugadores', 'accion%jugador%mostrar', 2),
(2, 'Alta', 'accion%jugador%alta', 2),
(3, 'Baja', 'accion%jugador%baja', 2),
(4, 'Modificar', 'accion%jugador%modificar', 2),
(1, 'Equipos', 'accion%equipo%mostrar', 3),
(2, 'Alta', 'accion%equipo%alta', 3),
(3, 'Baja', 'accion%equipo%baja', 3),
(4, 'Modificar', 'accion%equipo%modificar', 3),
(1, 'Locales', 'accion%local%mostrar', 4),
(2, 'Alta', 'accion%local%alta', 4),
(3, 'Baja', 'accion%local%baja', 4),
(4, 'Modificar', 'accion%local%modificar', 4),
(1, 'Calendario', 'calendario', 5),
(2, 'Jornada', 'calendario%jornada', 5),
(1, 'Clasificación', 'clasificacion', 6),
(1, 'Cricket', 'proximamente', 7),
(2, '501', 'proximamente', 7),
(1, '<input type=submit v', 'proximamente', 8),
(2, 'prueba', 'proximamente', 8),
(2, 'Noticias', 'proximamente', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calendario`
--
ALTER TABLE `calendario`
  ADD CONSTRAINT `calendario_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `calendario_ibfk_2` FOREIGN KEY (`id_equipo_local`) REFERENCES `equipo` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `calendario_ibfk_3` FOREIGN KEY (`id_equipo_visitante`) REFERENCES `equipo` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD CONSTRAINT `clasificacion_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`id_local`) REFERENCES `local` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `equipo_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugadores_equipo`
--
ALTER TABLE `jugadores_equipo`
  ADD CONSTRAINT `jugadores_equipo_ibfk_2` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `jugadores_equipo_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugador` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `submenu`
--
ALTER TABLE `submenu`
  ADD CONSTRAINT `submenu_ibfk_2` FOREIGN KEY (`id_padre`) REFERENCES `menu` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
