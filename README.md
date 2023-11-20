# Fintech

Este e o projeto da fintech. Para roda-lo certifique-se de que tenha:

- Oracle rodando, com docker ou localmente.
- Maven
- Java 17
- O servidor roda automaticamente com tomcat por meio de um plugin do maven.

## Para iniciar o projeto

1. Copie o conteudo do arquivo `application-example.properties` e crie um arquivo chamado `application.properties`, e
   entao coloque as credenciais necessarios conforme a configuracao do seu banco de dados.

2. Inicie o servidor do projeto rodando `mvn tomcat7:run`

3. Voce pode acessar a pagina de cadastro de usuario e navegar pelo projeto navegando
   para `http://localhost:8080/pages/cadastro.jsp`.