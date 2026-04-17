-- Script SQL (roda ao realizar build no docker)

CREATE DATABASE IF NOT EXISTS linguados;
USE linguados;

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL
);