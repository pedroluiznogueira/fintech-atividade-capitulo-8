<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/menu-style.css">
    <link rel="stylesheet" href="../css/index-style.css">
    <link rel="stylesheet" href="../css/home-style.css">
    <title>Fintech | Login</title>
</head>
<body>
    <header class="container-fluid text-center py-1 d-flex">
        <div class="center">
            <h1 class="fs-3 fw-bold">FINTECH</h1>
        </div>
        <div class="d-flex">
            <img src="../image/reload.svg" class="mx-4" onclick="reloadPage()" style="cursor: pointer">
            <img src="../image/config.svg" style="cursor: pointer">
        </div>
    </header>
    <main>
        <div class="mx-2">
            <input type="checkbox" id="check">
            <label for="check">
                <i class="fas fa-bars" id="btn"></i>
                <i class="fas fa-times" id="cancel"></i>
            </label>
            <div class="sidebar">
                <ul>
                    <li><a href="#"><i class="Investimentos"></i>Investimentos</a></li>
                    <li><a href="#"><i class="Recebimentos"></i>Recebimentos</a></li>
                    <li><a href="#"><i class="Gastos"></i>Gastos</a></li>
                </ul>
            </div>
            <div class="px-2">
                <div class="background-color-blue my-2 p-3 rounded-2 shadow-lg div-saldo">
                    <div class="d-flex mb-3 avatar">
                        <img src="../image/avatar.svg">
                        <p class="m-2 text-name">
                            Olá
                        </p>
                    </div>
                    <div class="saldo">
                        <h3>
                            Saldo Disponível:
                            <br>
                            R$ 1.000.000.000,00
                        </h3>
                    </div>
                    <div class="d-flex py-3 extrato">
                        <button class="btn px-4 button-extrato">Extrato</button>
                    </div>
                </div>
                <div class="text-black">
                    <h2 class="title-dashboard">Dashboard</h2>
                    <ul class="gallery">
                        <li class="dashboard-carrossel">
                            <div>
                                <img src="/image/investimento-black.svg">
                                <h3>Investimentos</h3>
                            </div>
                        </li>
                        <li class="dashboard-carrossel">
                            <div>
                                <img src="/image/recebimento-black.svg">
                                <h3>Recebimentos</h3>
                            </div>
                        </li>
                        <li class="dashboard-carrossel">
                            <div>
                                <img src="/image/gasto-black.svg">
                                <h3>Gastos</h3>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="text-black">
                    <h4>Total de Investimentos</h4>
                    <div class="text-black">
                        <input type="date" class="dashboard-date">
                        até
                        <input type="date" class="dashboard-date">
                    </div>
                    <div class="dashboard">
                        <!-- DASHBOARD DE CADA MENU ESCOLHIDO -->
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script src="../js/main.js"></script>
    <script src="../js/home.js"></script>
</body>
</html>