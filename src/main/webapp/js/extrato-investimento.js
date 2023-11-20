document.addEventListener("DOMContentLoaded", function () {
    getInvestimentosData();
});

function getInvestimentosData() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var investimentosData = JSON.parse(xhr.responseText);
                displayInvestimentosData(investimentosData);
            } else {
                console.error('Error fetching investimentos data:', xhr.status, xhr.statusText);
            }
        }
    };

    xhr.open('GET', '/investimentos', true);
    xhr.send();
}

function displayInvestimentosData(investimentosData) {
    var extratoDiv = document.querySelector('.extrato');

    extratoDiv.innerHTML = '';

    investimentosData.forEach(function (investimento) {
        var investimentoHtml = `
            <div class="extrato-info hr">
                <div>
                    <p class="extrato-data">${formatDate(investimento.dataInvestimento)}</p>
                </div>
                <div class="d-flex align-items-center extrato-info-principal">
                    <div class="ms-3">
                        <p class="extrato-local">${investimento.descricao}</p>
                        <p class="extrato-valor">R$ ${investimento.valorInvestido.toFixed(2)}</p>
                    </div>
                </div>
            </div>
        `;
        extratoDiv.innerHTML += investimentoHtml;
    });
}

function formatDate(timestamp) {
    var date = new Date(timestamp);
    return `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()}`;
}
