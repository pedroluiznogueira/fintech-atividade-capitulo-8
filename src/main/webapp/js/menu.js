document.addEventListener('DOMContentLoaded', function() {
    const menuButton = document.querySelector('.menu-button');
    const menuBar = document.querySelector('.menu-bar');

    menuButton.addEventListener('click', function() {
        menuBar.classList.toggle('open');
    });
});