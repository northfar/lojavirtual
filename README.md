# lojavirtual
Projeto que visa implementar uma loja virtual simples, com opções de listagem, cadastro, edição e exclusão.

Tecnologias utilizadas:
  - Java 1.8
  - IDE Eclipse Kepler (J2EE)
  - Maven 3.1
  - Framework Spring Boot 1.5.14 (SNAPSHOT)
  - Banco de dados: MySQL
  - Framework Materialize CSS
  
Instruções de configuração e utilização:
 - Existem duas formas de executar a aplicação: baixando o repositório e configurando o projeto no Eclipse, ou realizando o deploy do 
 arquivo "lojavirtual-0.0.1-SNAPSHOT.war" em um servidor Tomcat.
 - Para executar a aplicação sem erros, é necessário modificar o arquivo application.properties e modificar as seguintes propriedades:
    - url(URL para o banco de dados)
    - username(nome de usuário)
    - password (senha de usuário)
    
  - Neste arquivo também está configurada a porta http, que tambem pode ser modificada. (Porta atual:8083)
  - Também é necessário criar uma base de dados no MySQL chamada "lojavirtual", que é onde serão armazenadas as tabelas criadas no projeto.
 
 
  
  O sistema consiste em duas telas: uma onde são mostrados todos os registros já cadastrados, onde se pode selecionar um deles para alteração clicando no campo "Nome", e cada um deles possui um botão de exclusão.
  A outra tela é de Cadastro/Edição, onde tanto se pode adicionar um novo registro, como tambem alterar um já existente.
  
  
