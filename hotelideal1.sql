-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2018 a las 00:23:16
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotelideal1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id_habitacion` int(11) NOT NULL,
  `nroHabitacion` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_tipohabitacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id_habitacion`, `nroHabitacion`, `piso`, `estado`, `id_tipohabitacion`) VALUES
(1, 1, 1, 1, 2),
(2, 2, 1, 0, 1),
(3, 3, 1, 1, 4),
(4, 4, 1, 0, 3),
(5, 5, 1, 1, 2),
(6, 6, 1, 0, 2),
(7, 7, 1, 0, 1),
(8, 8, 1, 0, 3),
(9, 9, 1, 0, 2),
(10, 10, 1, 0, 1),
(11, 11, 1, 0, 4),
(12, 12, 1, 0, 5),
(14, 14, 1, 0, 4),
(15, 13, 1, 1, 7),
(16, 16, 1, 0, 8),
(17, 15, 1, 0, 6),
(18, 19, 1, 1, 7),
(19, 17, 1, 0, 10),
(20, 18, 1, 0, 9),
(21, 21, 2, 0, 4),
(22, 22, 2, 0, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `id_huesped` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `dni` int(14) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `celular` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`id_huesped`, `nombre`, `dni`, `domicilio`, `correo`, `celular`) VALUES
(2, 'Santigo Aballay', 47666777, 'Rawson 550', 'santiagoaballay@ulp.edu.ar', 2664335567),
(3, 'Pedro Ledesma', 29444555, 'Las Golondrinas 234', 'pedro@ulp.edu.ar', 2664889966),
(4, 'Aylen Aballay', 47888777, 'Rawson 532', 'aylen@ulp.edu.ar', 2664998877),
(5, 'Lautaro Ledesma', 51334455, 'Las Palomas 987', 'lautaro@ulp.edu.ar', 2664009988),
(6, 'Anabela de Ledesma', 34112233, 'Las Palomas 456', 'anabela@ulp.edu.ar', 2664556677),
(12, 'Lorena Ibarra', 22333555, 'Las Palomas 123', 'lorena@ulp.edu.ar', 2664556677),
(13, 'Anzelmo Blanco', 26777888, 'Pidra blanca 123', 'pedroperdido@ulp.edu.ar', 266498765),
(15, 'huesped 3', 22345678, 'San Martin 21', 'huesped3@ulp.edu.ar', 2664000003),
(17, 'Sandra Cabrera', 33444555, 'Las Heras 123', 'sandra@ulp.edu.ar', 2664002233),
(18, 'Janet Rodriguez', 30222000, 'Las Palmeras', 'janet@ulp.edu.ar', 2664345678);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `cantidadPersonas` int(11) NOT NULL,
  `fechaEntrada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `importeTotal` double NOT NULL,
  `estadoReserva` tinyint(1) NOT NULL,
  `id_habitacion` int(11) NOT NULL,
  `id_huesped` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `cantidadPersonas`, `fechaEntrada`, `fechaSalida`, `importeTotal`, `estadoReserva`, `id_habitacion`, `id_huesped`) VALUES
(1, 4, '2018-10-23', '2018-10-27', 1200, 1, 16, 2),
(3, 4, '2018-04-17', '2018-04-22', 1500, 1, 12, 3),
(5, 4, '2018-07-14', '2018-07-19', 1150, 1, 14, 17),
(7, 6, '2018-10-24', '2018-10-29', 2000, 1, 17, 13),
(8, 6, '2018-10-24', '2018-11-01', 4000, 1, 19, 12),
(9, 4, '2018-10-24', '2018-10-30', 1200, 1, 8, 13),
(10, 4, '2018-10-26', '2018-11-02', 1400, 1, 4, 17),
(11, 4, '2018-10-24', '2018-11-02', 5400, 1, 20, 6),
(12, 4, '2018-10-24', '2018-10-29', 1150, 1, 6, 5),
(13, 4, '2018-10-25', '2018-11-03', 2070, 1, 9, 3),
(14, 4, '2018-10-25', '2018-11-03', 1800, 1, 7, 18),
(16, 4, '2018-10-25', '2018-11-01', 1400, 1, 21, 6),
(18, 4, '2018-10-25', '2018-11-04', 2000, 1, 11, 13),
(19, 4, '2018-10-26', '2018-11-05', 2000, 1, 10, 12),
(20, 4, '2018-10-30', '2018-11-05', 4500, 1, 22, 12),
(21, 4, '2018-10-29', '2018-11-07', 1800, 1, 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipohabitacion`
--

CREATE TABLE `tipohabitacion` (
  `id_tipohabitacion` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `precioPorNoche` double NOT NULL,
  `cantPersonasMax` int(11) NOT NULL,
  `cantCamas` int(11) NOT NULL,
  `tipoCama` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipohabitacion`
--

INSERT INTO `tipohabitacion` (`id_tipohabitacion`, `codigo`, `tipo`, `precioPorNoche`, `cantPersonasMax`, `cantCamas`, `tipoCama`) VALUES
(1, 1001, 'Doble', 200, 4, 4, 'Simples'),
(2, 1002, 'Estándar Simple', 230, 4, 2, 'Queen'),
(3, 1003, 'Doble', 300, 4, 3, 'Simples'),
(4, 1004, 'Estándar Simple', 200, 4, 2, 'Queen'),
(5, 1005, 'Doble', 250, 4, 2, 'Queen'),
(6, 1006, 'Triple', 400, 6, 3, 'Queen'),
(7, 1007, 'Triple', 300, 4, 4, 'Simples'),
(8, 1008, 'Triple', 450, 4, 2, 'King Size'),
(9, 1009, 'Suite Lujo', 750, 4, 2, 'King Size'),
(10, 1010, 'Suite Lujo', 500, 6, 3, 'Queen');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id_habitacion`),
  ADD KEY `id_tipohabitacion` (`id_tipohabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`id_huesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `id_habitacion` (`id_habitacion`,`id_huesped`),
  ADD KEY `id_huesped` (`id_huesped`);

--
-- Indices de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  ADD PRIMARY KEY (`id_tipohabitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `id_huesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  MODIFY `id_tipohabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`id_tipohabitacion`) REFERENCES `tipohabitacion` (`id_tipoHabitacion`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_huesped`) REFERENCES `huesped` (`id_huesped`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id_habitacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
