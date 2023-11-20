document.addEventListener("DOMContentLoaded", function () {
    getReceitaData();
});

function getReceitaData() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var receitasData = JSON.parse(xhr.responseText);
                displayInvestimentosData(receitasData);
            } else {
                console.error('Error fetching investimentos data:', xhr.status, xhr.statusText);
            }
        }
    };

    xhr.open('GET', '/recebimentos', true);
    xhr.send();
}

function displayReceitasData(receitasData) {
    var extratoDiv = document.querySelector('.extrato');

    extratoDiv.innerHTML = '';

    receitasData.forEach(function (receita) {
        var receitaHtml = `
            <div class="extrato-info hr">
                <div>
                    <p class="extrato-data">${formatDate(receita.dataReceita)}</p>
                </div>
                <div class="d-flex align-items-center extrato-info-principal">
                    <div class="ms-3">
                        <p class="extrato-local">${receita.descricao}</p>
                        <p class="extrato-valor recebimento">R$ ${receita.valorReceita.toFixed(2)}</p>
                    </div>
                </div>
            </div>
        `;
        extratoDiv.innerHTML += receitaHtml;
    });
}

function formatDate(timestamp) {
    var date = new Date(timestamp);
    return `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()}`;
}
