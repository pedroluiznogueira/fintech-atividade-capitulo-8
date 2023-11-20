<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Erro 404</title>
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&family=Readex+Pro&display=swap');

    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Readex Pro', sans-serif;
      text-decoration: none;
      list-style: none;
    }

    body {
      background: #12122b;
      overflow: hidden;
    }

    .main {
      overflow: hidden;
    }

    .section {
      padding: 8rem;
      height: 100vh;
      display: flex;
      align-items: center;
      justify-content: space-between;
    }

    .left {
      display: flex;
      flex-direction: column;
      align-items: flex-start;
    }

    .left p {
      font-size: 2.2rem;
      color: #D8DEC3;
      margin-bottom: 10px;
    }

    .left h4 {
      font-size: 3.5rem;
      color: #AAAA91;
      margin-bottom: 3rem;
    }

    .btn {
      padding: 1.5rem 5rem;
      background: #AAAA91;
      border-radius: 15px;
      color: #12122b;
      font-size: 1.2rem;
      font-weight: 700;
      transition: all 0.3s ease;
    }

    .btn:hover {
      box-shadow: 0 1px 4px #AAAA91;
    }

    .right img {
      width: 500px;
      margin-bottom: 1rem;
      animation: float 1.8s infinite alternate;
    }

    .shadow {
      width: 450px;
      height: 45px;
      background: hsla(38, 21%, 19%, 0.16);
      border-radius: 50%;
      margin: 0 auto;
      filter: blur(5px);
      animation: shadow 1.8s infinite alternate;
    }

    @keyframes float {
      0% {
        transform: translateY(0);
      }
      100% {
        transform: translateY(15px);
      }
    }

    @keyframes shadow {
      0% {
        transform: scale(1.1);
      }
      100% {
        transform: scale(0.85, 0.85);
      }
    }

    @media screen and (max-width: 768px) {
      .section {
        flex-direction: column;
      }

      .centralize {
        display: flex;
        flex-direction: column;
      }

      .left,
      .right {
        text-align: center;
        margin-bottom: 2rem;
      }

      .left h4 {
        font-size: 2.5rem;
      }

      .btn {
        padding: 1rem 2rem;
      }

      .right img {
        width: 100%;
        max-width: 300px;
        margin-bottom: 1rem;
      }

      .shadow {
        width: 80%;
      }
    }
  </style>
</head>
<body>
<main class="main">
  <section class="section">
    <div class="left">
      <div class="centralize">
        <p>Erro 404</p>
        <h4>
          Não conseguimos encontrar<br />
          a página que você está procurando.
        </h4>
        <a href="/pages/home.jsp" class="btn">Voltar para Home</a>
      </div>
    </div>
  </section>
</main>
</body>
</html>
