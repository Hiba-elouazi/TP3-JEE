<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Connexion</title>
  <style> 
    body { display: flex; justify-content: center; align-items: center; }
    .card { padding: 40px;  box-shadow: 0 10px 30px rgba(0,0,0,0.3); }
    h2 {  text-align: center; }
    .subtitle { color: #888; text-align: center; font-size: 13px; margin-bottom: 25px; }
    label { font-size: 13px; font-weight: bold; color: #333; display: block; margin-bottom: 4px; }
    input { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 6px;margin-bottom: 16px; font-size: 14px; } 
    .btn { width: 100%; padding: 12px; background: #27ae60; color: white; border: none; border-radius: 6px; font-size: 15px; cursor: pointer; }
    .btn:hover { background: #219150; }
    .error { background: #fde8e8;  padding: 10px;border-radius: 6px; margin-bottom: 16px; font-size: 13px; text-align: center; }
    .success { background: #e8fdf0; color: #27ae60; padding: 10px; border-radius: 6px; margin-bottom: 16px; font-size: 13px; text-align: center; }
    .link { text-align: center; margin-top: 16px; font-size: 13px; }
    .link a { color: #00b4d8;}
  </style>
</head>
<body>
  <div class="card">
    <h2>Connexion</h2>
    <p class="subtitle"> Connectez-vous </p>

    <% String erreur = (String) request.getAttribute("erreur"); %>
    <% String succes = (String) request.getAttribute("succes"); %>
    <% if (erreur != null) { %><div class="error"><%= erreur %></div><% } %>
    <% if (succes != null) { %><div class="success"><%= succes %></div><% } %>

    <form action="login" method="post">
      <label>Nom d'utilisateur</label>
      <input type="text" name="username" placeholder="username" required />

      <label>Mot de passe</label>
      <input type="password" name="password" placeholder="mot de passe" required />

      <button type="submit" class="btn">Se connecter</button>
    </form>

    <div class="link">
      Pas de compte ? <a href="signup">S'inscrire</a>
    </div>
  </div>
</body>
</html>