<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Accueil</title>
  <style>
    body { font-family: Arial, sans-serif; text-align: center; background: #f0f0f0; }
    .navbar { background: #0d1b3e; padding: 15px ; display: flex;justify-content: space-between; align-items: center; }
    .navbar h1 { color: white; font-size: 18px; }
    .navbar span {  color: white;  }
    .logout { background: #e74c3c; color: white; padding: 15px; border-radius: 6px; font-size: 15px; }
    h2 { margin-top: 60px; font-size: 2em;}
    p  { margin-top: 15px; color: #555; }

  </style>
</head>
<body>

  <div class="navbar">
    <h1> Application de Gestion</h1>
    <div>
      <span> user :<b>${username}</b> &nbsp;</span>
      <a href="logout" class="logout">Se deconnecter</a>
    </div>
  </div>

  <div class="container">
    <div class="welcome-card">
      <h2>Bienvenue, ${username} ! </h2>
      <p>Vous etes connecte avec succes a l'application.</p> 
    </div>
 
 
  </div>

</body>
</html>