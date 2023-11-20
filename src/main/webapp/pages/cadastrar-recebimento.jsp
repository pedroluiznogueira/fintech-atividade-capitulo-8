<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/menu-style.css">
    <link rel="stylesheet" href="../css/extrato-style.css">
    <link rel="stylesheet" href="../css/index-style.css">
    <link rel="stylesheet" href="../css/cadastro-style.css">
    <title>Fintech | Cadastro Recebimento</title>
</head>
<body>
    <header class="container-fluid text-center py-1 d-flex">
        <div class="center">
            <a href="pages/home.jsp" style="text-decoration: none; color: #FFF;">
                <h1 class="fs-3 fw-bold">FINTECH</h1>
            </a>
        </div>
        <div class="d-flex">
            <img src="../image/reload.svg" class="mx-4" onclick="reloadPage()" style="cursor: pointer">
        </div>
    </header>

    <main>
        <div class="container text-center margin-top-g">
            <input type="checkbox" id="check">
            <label for="check">
                <i class="fas fa-bars" id="btn"></i>
                <i class="fas fa-times" id="cancel"></i>
            </label>
            <div class="sidebar">
                <ul>
                    <li><a href="extrato-investimento.jsp"><i class="Investimentos"></i>Investimentos</a></li>
                    <li><a href="extrato-recebimento.jsp"><i class="Recebimentos"></i>Recebimentos</a></li>
                    <li><a href="extrato-gasto.jsp"><i class="Gastos"></i>Gastos</a></li>
                </ul>
            </div>

            <!-- Mensagem de sucesso -->
            <c:if test="${not empty requestScope.success and requestScope.success eq true}">
                <div class="alert alert-success" role="alert">
                    Gasto criado com sucesso
                </div>
            </c:if>

            <!-- Mensagem de erro -->
            <c:if test="${not empty requestScope.success and requestScope.success eq false}">
                <div class="alert alert-danger" role="alert">
                    Dados inválidos
                </div>
            </c:if>

            <p class="fs-1 fw-bold">Cadastro de Recebimento</p>
            <div class="form-center-desk">
                <form action="/receitas" name="cadastro-recebimento" id="cadastro-recebimento" method="post" class="form-width">
                    <select name="tipo-recebimento" class="form-number form-control my-4 form-width form-login" required style="color: rgba(0, 0, 0, 0.60);">
                        <option value="0">Tipo de Recebimento</option>
                        <option value="salario">Salário</option>
                        <option value="freelance">Freelance</option>
                        <option value="investimento">Investimento</option>
                        <option value="outros">Outros</option>
                    </select>
                    <textarea name="descricao-recebimento" placeholder="Descrição" type="text" class="form-control my-4 form-width form-login" minlength="5" style="min-height: 100px;"></textarea>
                    <input name="valor-recebimento" placeholder="Valor" type="number" class="form-control my-4 form-width form-login" minlength="1" maxlength="50" required>
                    <input type="submit" value="Cadastrar" class="btn fw-bold py-2 px-5 btn-bg">
                </form>
            </div>
        </div>
    </main>
</body>
</html>