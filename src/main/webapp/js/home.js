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

function mostrarDiv(id) {
  let divs = document.querySelectorAll('.mostrar');
  for (let i = 0; i < divs.length; i++) {
      divs[i].style.display = 'none';
  }
  let div = document.querySelector(id);
  div.style.display = 'block';

  switch (id) {
    case '#dashboard-investimento':
        getQuantidadeDeInvestimentos();
        break;
    case '#dashboard-recebimento':
      getQuantidadeDeRecebimentos();
      break;
    case '#dashboard-gasto':
      getQuantidadeDeGastos();
      break;
  }
}

function getQuantidadeDeInvestimentos() {
  var xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        var jsonResponse = JSON.parse(xhr.responseText);
        console.log('Quantidade de Investimentos:', jsonResponse.count);

        mostrarQuantidadeDeInvestimentos(jsonResponse.count);
      } else {
        console.error('Error fetching data:', xhr.status, xhr.statusText);
      }
    }
  };

  xhr.open('GET', '/investimentos', true);
  xhr.send();
}

function mostrarQuantidadeDeInvestimentos(quantidadeDeInvestimentos) {
  var h4Element = document.querySelector('#dashboard-investimento h4');
  if (h4Element) {
    h4Element.innerHTML += ': ' + quantidadeDeInvestimentos;
  }
}

function getQuantidadeDeRecebimentos() {
  var xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        var jsonResponse = JSON.parse(xhr.responseText);
        console.log('Quantidade de Recebimentos:', jsonResponse.count);

        mostrarQuantidadeDeRecebimentos(jsonResponse.count);
      } else {
        console.error('Error fetching data:', xhr.status, xhr.statusText);
      }
    }
  };

  xhr.open('GET', '/receitas', true);
  xhr.send();
}

function mostrarQuantidadeDeRecebimentos(quantidadeDeRecebimentos) {
  var h4Element = document.querySelector('#dashboard-recebimento h4');
  if (h4Element) {
    h4Element.innerHTML += ': ' + quantidadeDeRecebimentos;
  }
}

function getQuantidadeDeGastos() {
  var xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        var jsonResponse = JSON.parse(xhr.responseText);
        console.log('Quantidade de Gastos:', jsonResponse.count);

        mostrarQuantidadeDeGastos(jsonResponse.count);
      } else {
        console.error('Error fetching data:', xhr.status, xhr.statusText);
      }
    }
  };

  xhr.open('GET', '/despesas', true);
  xhr.send();
}

function mostrarQuantidadeDeGastos(quantidadeDeGastos) {
  var h4Element = document.querySelector('#dashboard-gasto h4');
  if (h4Element) {
    h4Element.innerHTML += ': ' + quantidadeDeGastos;
  }
}
