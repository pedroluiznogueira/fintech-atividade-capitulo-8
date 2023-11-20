const slider = document.querySelector('.gallery');
let isDown = false;
let startX;
let scrollLeft;

slider.addEventListener('mousedown', e => {
  isDown = true;
  slider.classList.add('active');
  startX = e.pageX - slider.offsetLeft;
  scrollLeft = slider.scrollLeft;
});
slider.addEventListener('mouseleave', _ => {
  isDown = false;
  slider.classList.remove('active');
});
slider.addEventListener('mouseup', _ => {
  isDown = false;
  slider.classList.remove('active');
});
slider.addEventListener('mousemove', e => {
  if (!isDown) return;
  e.preventDefault();
  const x = e.pageX - slider.offsetLeft;
  const SCROLL_SPEED = 1;
  const walk = (x - startX) * SCROLL_SPEED;
  slider.scrollLeft = scrollLeft - walk;
});

function mostrarQuantidade(elementId, quantidade, label) {
  var h4Element = document.querySelector(elementId + ' h4');
  if (h4Element) {
    h4Element.innerHTML = 'Total de ' + label + ': ' + quantidade;
  }
}

function fetchDataAndDisplay(url, elementId, label) {
  var xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        var jsonResponse = JSON.parse(xhr.responseText);
        console.log('Quantidade de ' + label + ':', jsonResponse.count);

        mostrarQuantidade(elementId, jsonResponse.count, label);
      } else {
        console.error('Error fetching data:', xhr.status, xhr.statusText);
      }
    }
  };

  xhr.open('GET', url + '?type=count', true);
  xhr.send();
}

function mostrarDiv(id) {
  let divs = document.querySelectorAll('.mostrar');
  for (let i = 0; i < divs.length; i++) {
    divs[i].style.display = 'none';
  }
  let div = document.querySelector(id);
  div.style.display = 'block';

  switch (id) {
    case '#dashboard-investimento':
      fetchDataAndDisplay('/investimentos', id, 'Investimentos');
      break;
    case '#dashboard-recebimento':
      fetchDataAndDisplay('/receitas', id, 'Recebimentos');
      break;
    case '#dashboard-gasto':
      fetchDataAndDisplay('/despesas', id, 'Gastos');
      break;
  }
}
