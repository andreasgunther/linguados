-- Script SQL (roda ao realizar build no docker)

CREATE DATABASE IF NOT EXISTS linguados;
USE linguados;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    xp INT DEFAULT 0
);