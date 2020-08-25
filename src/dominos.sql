-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-08-2020 a las 09:43:29
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dominos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dir_cliente`
--

CREATE TABLE `dir_cliente` (
  `id` int(11) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dir_cliente`
--

INSERT INTO `dir_cliente` (`id`, `direccion`, `telefono`) VALUES
(3, 'asdasd', 9991239123),
(4, 'asdasd', 9991239123),
(5, 'asdasd', 9991239123),
(6, 'asdasd', 9991239123),
(7, 'asdasd', 9991239123),
(8, 'asdasd', 9991239123),
(9, 'asdasd', 1231231212),
(10, 'asdasd', 1231231212),
(11, 'asdasd', 1231231212),
(12, 'asdasd', 1231231212),
(13, 'asdasd', 1231231212),
(14, 'reg.260 punta ikal', 1231231233);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id` int(11) NOT NULL,
  `especialidad` varchar(255) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id`, `especialidad`, `precio`) VALUES
(1, 'especial', 30),
(2, 'sarten', 25),
(3, 'orilla', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_dir_cliente` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `id_tam_pizza` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `precio_final` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `id_usuario`, `id_dir_cliente`, `id_especialidad`, `id_tam_pizza`, `id_tipo`, `precio_final`) VALUES
(1, 1, 6, 1, 1, 1, 0),
(2, 1, 7, 1, 1, 1, 0),
(3, 1, 8, 1, 1, 1, 0),
(4, 1, 9, 1, 1, 1, 0),
(5, 1, 11, 1, 1, 1, 275),
(6, 1, 12, 1, 1, 1, 275),
(7, 1, 13, 1, 1, 3, 282.5),
(8, 1, 14, 2, 1, 3, 277.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tam_pizza`
--

CREATE TABLE `tam_pizza` (
  `id` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tam_pizza`
--

INSERT INTO `tam_pizza` (`id`, `tipo`, `precio`) VALUES
(1, 'familiar', 240),
(2, 'mediana', 140),
(3, 'personal', 90);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `id` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`id`, `tipo`, `precio`) VALUES
(1, 'peperoni', 5),
(2, 'hawaiana', 10),
(3, 'mexicana', 12.5),
(4, 'queso', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `nombre_comp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `contrasena`, `nombre_comp`) VALUES
(1, 'is@gmail.com', 'Noseguro', 'Isaac Montiel');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dir_cliente`
--
ALTER TABLE `dir_cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tam_pizza`
--
ALTER TABLE `tam_pizza`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dir_cliente`
--
ALTER TABLE `dir_cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tam_pizza`
--
ALTER TABLE `tam_pizza`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
