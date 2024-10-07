BElinkedRH
Este projeto é uma API RESTful desenvolvida em Spring Boot para gerenciar o controle de cursos, turmas e participantes de uma empresa, com foco na organização de treinamentos de funcionários.

Tecnologias Utilizadas
Java 17
Spring Boot 3.x
MySQL
JDBC com JdbcTemplate
JUnit 5 para testes
Mockito para mock de componentes
Estrutura do Projeto
O projeto está organizado em camadas de acordo com as boas práticas de desenvolvimento de APIs RESTful:

Model: Representação das entidades do sistema.

Curso.java
Funcionario.java
Turma.java
TurmaParticipante.java
Repository: Comunicação com o banco de dados utilizando JdbcTemplate.

CursoRepository.java
TurmaRepository.java
TurmaParticipanteRepository.java
Service: Contém a lógica de negócio e as regras para manipulação dos dados.

CursoService.java
TurmaService.java
TurmaParticipanteService.java
Controller: Exposição dos endpoints da API.

CursoController.java
TurmaController.java
TurmaParticipanteController.java
DTO: Objetos de transferência de dados utilizados entre camadas.

CursoDTO.java
TurmaDTO.java
TurmaParticipanteDTO.java
Exceptions: Tratamento de exceções globais e customizadas.

BusinessException.java
ResourceNotFoundException.java
GlobalExceptionHandler.java
Endpoints
A API expõe os seguintes endpoints:

Cursos
GET /cursos: Retorna a lista de cursos.
POST /cursos: Cria um novo curso.
PUT /cursos/{id}: Atualiza as informações de um curso.
DELETE /cursos/{id}: Remove um curso existente.
Turmas
GET /turmas: Retorna a lista de turmas.
POST /turmas: Cria uma nova turma.
PUT /turmas/{id}: Atualiza as informações de uma turma.
DELETE /turmas/{id}: Remove uma turma existente.
Participantes
GET /participantes: Retorna a lista de participantes de uma turma.
POST /participantes: Insere um novo participante em uma turma.
DELETE /participantes/{id}: Remove um participante de uma turma.
Regras de Negócio
Cada curso pode ter várias turmas associadas.
Cada turma pode ter vários participantes (funcionários).
É possível registrar participantes em turmas específicas.
Testes
Os testes são realizados utilizando JUnit 5 e Mockito. Eles estão localizados na pasta src/test/ e cobrem os principais serviços:

CursoServiceTest.java
TurmaServiceTest.java
TurmaParticipanteServiceTest.java
Configuração do Banco de Dados

Execução do Projeto
Clone o repositório:

git clone <URL-do-repositorio>
Navegue até a pasta do projeto:

cd BElinkedRH-main
Configure o banco de dados MySQL de acordo com o arquivo application.properties.

Execute a aplicação:

./mvnw spring-boot:run
Acesse a API através de http://localhost:8080.
