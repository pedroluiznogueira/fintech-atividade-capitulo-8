<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/index-style.css">
    <link rel="stylesheet" href="../css/extrato-style.css">
    <link rel="stylesheet" href="../css/menu-style.css">
    <title>Fintech | Gasto</title>
</head>
<body>
    <header class="container-fluid text-center py-1 d-flex">
        <div class="center">
            <a href="home.jsp" style="text-decoration: none; color: #FFF;">
                <h1 class="fs-3 fw-bold">FINTECH</h1>
            </a>
        </div>
        <div class="d-flex">
            <img src="../image/reload.svg" class="mx-4" onclick="reloadPage()" style="cursor: pointer">
        </div>
    </header>
    <main>
        <div class="mx-3">
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
            <div>
                <div class="background-color-blue my-2 p-3 rounded-2 shadow-lg div-saldo">
                    <div class="saldo">
                        <h3>
                            Saldo Disponível:
                            <br>
                            R$ 1.000.000.000,00
                        </h3>
                    </div>
                </div>
                <div class="text-center">
                    <a href="cadastrar-gasto.jsp">
                        <button class="btn btn-cadastro">Cadastrar gasto</button>
                    </a>
                </div>
                <div class="extrato">
                    <!-- Dados do extrato de gastos vai ser inserida aqui dinamicamente -->
                </div>
            </div>
        </div>
    </main>
    <script src="../js/main.js"></script>
    <script src="../js/extrato-gasto.js"></script>
</body>
</html>