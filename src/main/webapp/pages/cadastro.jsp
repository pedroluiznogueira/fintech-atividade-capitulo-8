<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/index-style.css">
    <link rel="stylesheet" href="../css/cadastro-style.css">
    <title>Fintech | Cadastro</title>
</head>
<body>
    <header class="container-fluid d-flex justify-content-center py-1">
        <a href="login.jsp">
            <img src="../image/back.svg" alt="Voltar" class="position-absolute start-0 top-0 mt-2 ms-3">
        </a>
        <h1 class="fs-3 fw-bold">FINTECH</h1>
    </header>

    <main>
        <div class="container text-center margin-top-g">
            <!-- Mensagem de sucesso -->
            <c:if test="${not empty requestScope.success and requestScope.success eq true}">
                <div class="alert alert-success" role="alert">
                    Usuario criado com sucesso
                </div>
                <a href="/pages/login.jsp">Ir para login</a>
            </c:if>

            <!-- Mensagem de erro -->
            <c:if test="${not empty requestScope.success and requestScope.success eq false}">
                <div class="alert alert-danger" role="alert">
                    Dados inválidos
                </div>
            </c:if>

            <p class="fs-1 fw-bold">Cadastro</p>
            <div class="form-center-desk">
                <form action="/usuarios/cadastro" name="cadastro" id="cadastro" method="post" class="form-width ">
                    <input name="cpf" placeholder="Digite seu CPF" type="number" class=" form-number form-control my-4 form-width form-login" min="11111111111" max="99999999999" autofocus required>
                    <input name="nome" placeholder="Digite seu Nome" type="text" class="form-control my-4 form-width form-login" minlength="5" required>
                    <input name="senha" placeholder="Digite sua Senha" type="password" class="form-control my-4 form-width form-login" minlength="6" maxlength="15" required>
                    <input name="confimacaoSenha" placeholder="Confirme sua Senha" type="password" class="form-control my-4 form-width form-login" minlength="6" maxlength="15" required>
                    <input name="email" placeholder="Digite seu Email" type="email" class="form-control my-4 form-width form-login" required>
                    <input name="emailRecuperacao" placeholder="Digite seu Email de Recuperacao" type="email" class="form-control my-4 form-width form-login" required>
                    <input type="submit" value="Registre-se" class="btn fw-bold py-2 px-5 btn-bg">
                </form>
            </div>
        </div>
    </main>
</body>
</html>