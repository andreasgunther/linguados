-- Script SQL (roda ao realizar build no docker)

CREATE DATABASE IF NOT EXISTS linguados;
USE linguados;

-- 1. Tabela de Usuários
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    xp INT DEFAULT 0,
    nivel INT DEFAULT 1,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Tabela de Desafios
CREATE TABLE IF NOT EXISTS desafio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    pontos_xp INT NOT NULL,
    dificuldade ENUM('Fácil', 'Médio', 'Difícil') DEFAULT 'Fácil'
    );

-- 3. Tabela de Progresso (Relaciona Usuário com Desafio)
-- Esta tabela registra quando um usuário conclui um desafio específico
CREATE TABLE IF NOT EXISTS progresso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    desafio_id INT NOT NULL,
    data_conclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- Restrições de Chave Estrangeira
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (desafio_id) REFERENCES desafio(id) ON DELETE CASCADE
    );

-- 4. Tabela de Conquistas
-- Registra os prêmios/badges que o usuário ganhou
CREATE TABLE IF NOT EXISTS conquista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    nome_conquista VARCHAR(100) NOT NULL,
    descricao_conquista VARCHAR(255),
    data_ganha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- Restrição de Chave Estrangeira
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
    );

-- Povoamento: Insere alguns desafios iniciais para teste
INSERT IGNORE INTO desafio (titulo, descricao, pontos_xp, dificuldade) VALUES
('Olá Mundo', 'Imprima sua primeira mensagem no console Java.', 10, 'Fácil'),
('Variáveis e Tipos', 'Declare variáveis de diferentes tipos primitivos.', 20, 'Fácil'),
('Estruturas de Repetição', 'Crie um loop que conte até 100.', 50, 'Médio');