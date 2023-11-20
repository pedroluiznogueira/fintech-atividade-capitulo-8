<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/menu-style.css">
    <link rel="stylesheet" href="../css/index-style.css">
    <link rel="stylesheet" href="../css/extrato-style.css">
    <title>Fintech | Investimento</title>
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
        <div class="mx-3">
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
                <div class="extrato">
                    <div class="extrato-info hr">
                        <div>
                            <p class="extrato-data">
                                20/01/2023
                            </p>
                        </div>
                        <div class="d-flex align-items-center extrato-info-principal">
                            <img src="../image/extrato-gasto.svg">
                            <div class="ms-3">
                                <p class="extrato-local">
                                    Restaurante
                                </p>
                                <p class="extrato-valor">
                                    R$ 90,00
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="extrato-info hr">
                        <div>
                            <p class="extrato-data">
                                20/01/2023
                            </p>
                        </div>
                        <div class="d-flex align-items-center extrato-info-principal">
                            <img src="../image/extrato-gasto.svg">
                            <div class="ms-3">
                                <p class="extrato-local">
                                    Restaurante
                                </p>
                                <p class="extrato-valor">
                                    R$ 90,00
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="extrato-info hr">
                        <div>
                            <p class="extrato-data">
                                20/01/2023
                            </p>
                        </div>
                        <div class="d-flex align-items-center extrato-info-principal">
                            <img src="../image/extrato-gasto.svg">
                            <div class="ms-3">
                                <p class="extrato-local">
                                    Restaurante
                                </p>
                                <p class="extrato-valor">
                                    R$ 90,00
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="extrato-info">
                        <div>
                            <p class="extrato-data">
                                20/01/2023
                            </p>
                        </div>
                        <div class="d-flex align-items-center extrato-info-principal">
                            <img src="../image/extrato-gasto.svg">
                            <div class="ms-3">
                                <p class="extrato-local">
                                    Restaurante
                                </p>
                                <p class="extrato-valor">
                                    R$ 90,00
                                </p>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
    </main>
    <script src="../js/main.js"></script>
</body>
</html>