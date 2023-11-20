document.addEventListener("DOMContentLoaded", function () {
    getGastosData();
});

function getGastosData() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var gastosData = JSON.parse(xhr.responseText);
                displayGastosData(gastosData);
            } else {
                console.error('Error fetching gastos data:', xhr.status, xhr.statusText);
            }
        }
    };

    xhr.open('GET', '/despesas', true);
    xhr.send();
}

function displayGastosData(gastosData) {
    var extratoDiv = document.querySelector('.extrato');

    extratoDiv.innerHTML = '';

    gastosData.forEach(function (gasto) {
        var gastoHtml = `
            <div class="extrato-info hr">
                <div class="d-flex align-items-center extrato-info-principal">
                    <div class="ms-3">
                        <p class="extrato-local">${gasto.descricao}</p>
                        <p class="extrato-valor gasto">R$ ${gasto.valor.toFixed(2)}</p>
                    </div>
                </div>
            </div>
        `;
        extratoDiv.innerHTML += gastoHtml;
    });
}