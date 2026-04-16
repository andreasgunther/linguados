# 🦆 Linguados: Inglês para Desenvolvedores

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

O **Linguados** é uma aplicação focada no ensino de inglês técnico para profissionais de TI. Através de desafios de tradução, interpretação de código e preenchimento de lacunas, o desenvolvedor pratica o idioma enquanto reforça conceitos de programação.

---

## Funcionalidades (MVP)

- **Sistema de Login:** Cadastro e autenticação de estudantes.
- **Trilhas de Estudo:** Módulos categorizados por nível e tema (ex: Sintaxe, DevOps, SQL).
- **Gamificação:** Acúmulo de XP, contador de ofensiva (streaks) e ranking.
- **Motor de Desafios:** Validação polimórfica de respostas em tempo real.

## 🛠 Arquitetura e Tecnologias

O projeto utiliza uma estrutura modular baseada em **Package by Feature**, facilitando a manutenção e escalabilidade.

- **Linguagem:** Java 25 (LTS)
- **Gestão de Dependências:** Maven
- **Banco de Dados:** MySQL 8.0
- **Infraestrutura:** Docker & Docker Compose
- **Design Pattern:** MVC (Model-View-Controller)

## 📦 Como Executar

### Pré-requisitos
- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/) instalados.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/andreasgunther/linguados
   cd linguados
   ```

2. Suba o ambiente com Docker:
    ```bash
    docker-compose up -d
    ```
    
3. Execute a aplicação:
    ```bash
    docker exec -it linguados-app java -jar target/linguados-1.0.0-SNAPSHOT.jar
    ```

## 📂 Estrutura de Pastas

    src/main/java/com/linguados/
    ├── Main.java           # Ponto de entrada (Bootstrap)
    ├── auth/               # Módulo de Autenticação e Login
    ├── desafio/            # Core pedagógico e motor de exercícios
    ├── usuario/            # Gestão de perfis e dados do estudante
    └── gamificacao/        # Lógica de XP, Ofensivas (Streaks) e Ranking

## Metodologia de Desenvolvimento

Para garantir a organização, rastreabilidade e qualidade do código, o projeto adota um fluxo de trabalho baseado em práticas ágeis e padrões de mercado:

### 📑 Gestão de Tarefas (GitHub Projects)
Utilizamos o **GitHub Projects** com a metodologia **Kanban** para gerenciar o ciclo de vida de cada funcionalidade. As tarefas são divididas em:
- **Backlog:** Ideias e funcionalidades planejadas.
- **Todo:** Tarefas prioritárias para o ciclo atual.
- **In Progress:** Atividades em desenvolvimento.
- **Done:** Funcionalidades testadas e integradas.

### 🌿 Fluxo de Trabalho (Git Flow)
Adotamos uma versão simplificada do **Git Flow** para manter a estabilidade do código:
- `main`: Contém apenas código estável e pronto para produção.
- `dev`: Branch de integração para novas funcionalidades.
- `feature/nome-da-task`: Branches temporárias criadas a partir da `dev` para o desenvolvimento de tarefas específicas.
- **Pull Requests:** Toda alteração deve passar por revisão antes de ser mesclada à branch principal.

### 📐 Modelagem e Documentação (UML)
A arquitetura do sistema é validada antes da codificação através de diagramas **UML**:
- **Diagrama de Classes:** Para estruturar o herança e polimorfismo dos desafios.

<table>
  <thead>
    <tr>
      <th>Diagrama de Classes</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><img width="1740" height="958" alt="20260414104453" src="https://github.com/user-attachments/assets/fa4e0fc7-2069-4942-bb99-e03af293a532"/></td>
    </tr>
  </tbody>
</table>

- **Diagrama de Casos de Uso:** Para mapear as interações entre o Estudante/Administrador e o sistema.
- **DER (Diagrama Entidade-Relacionamento):** Para modelagem das tabelas e chaves estrangeiras no MySQL.

### 🦆 Engenharia de Software e Qualidade
- **Rubber Duck Debugging:** Incentivamos a prática de explicar o código linha por linha para identificar falhas lógicas.
- **MVC Pattern:** Separação clara entre dados, interface e lógica de negócio.
- **Conventional Commits:** Mensagens de commit padronizadas (ex: `feat:`, `fix:`, `docs:`) para facilitar a leitura do histórico.

## 🤝 Contribuição

1. Faça um **Fork** do projeto.
2. Crie uma **Branch** para sua funcionalidade (`git checkout -b feature/NovaFuncionalidade`).
3. Faça o **Commit** das suas alterações (`git commit -m 'Add: Nova Funcionalidade'`).
4. Faça o **Push** para a Branch (`git push origin feature/NovaFuncionalidade`).
5. Abra um **Pull Request**.

## 👩‍💻 Contribuidores

<table border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
      <a href="https://github.com/andreasgunther">
        <img src="https://images.weserv.nl/?url=avatars.githubusercontent.com/u/113151524?v=4&w=100&h=100&fit=cover&mask=circle" width="100px;" alt="Dev 1"/>
        <br />
        <sub><b>Andreas Gunther</b></sub>
      </a>
    </td>
    <td align="center" valign="top">
      <a href="">
        <img src="https://images.weserv.nl/?url=avatars.githubusercontent.com/u/227186797?v=4&w=100&h=100&fit=cover&mask=circle" width="100px;" alt="Dev 2"/>
        <br />
        <sub><b>Rubens Ian</b></sub>
      </a>
    </td>
    <td align="center" valign="top">
      <a href="https://github.com/VitorP2007">
        <img src="https://images.weserv.nl/?url=avatars.githubusercontent.com/u/126173402?v=4&w=100&h=100&fit=cover&mask=circle" width="100px;" alt="Dev 4"/>
        <br />
        <sub><b>Vitor Pizolato</b></sub>
      </a>
    </td>
  </tr>
</table>
