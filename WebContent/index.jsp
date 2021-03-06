<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
if(session.getAttribute("REFRESH")!=null){
	session.removeAttribute("REFRESH");
    response.sendRedirect("../EasyShopping");
}
else{    
session.setAttribute("REFRESH","TRUE");
}
%>   
<% String name = null;
String fname = null;
for (Cookie c: request.getCookies()) {
	if (c.getName().equals("name")) {
		name = c.getValue();
	}
	if (c.getName().equals("fname")) {
		fname = c.getValue();
	}
}%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>EasyShopping</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Indie+Flower|Poppins|Lemonada|Pacifico|Chewy" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
    </head>
    <body style="font-family: 'Poppins';font-size: 2em;text-align:justify;">
      <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="font-size: 16px;">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand mb-0" href="Main?action=welcome">EasyShopping</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" style="text-align: center;">
              <li class="nav-item active">
                <a class="nav-link scroll-link" data-id="Markets" href="Main?action=welcome" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Home</a>
              </li>
              <% if (name == null || fname == null) { %>
              <li class="nav-item">
                <a class="nav-link scroll-link" data-id="Benefits" href="#Benefits" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Benefits</a>
              </li>
              <li class="nav-item">
                <a class="nav-link scroll-link" data-id="Supermarkets" href="#Supermarkets" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Supermarkets</a>
              </li>
              <li class="nav-item">
                <a class="nav-link scroll-link" data-id="Contact" href="#Contact" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Contact Us</a>
              </li>
              <%} else { %>
              <li class="nav-item">
                <a class="nav-link" href="lister.html">Make a list</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Main?action=shop">Get my shop</a>
              </li>
              <%} %>
            </ul>
            <ul class="nav navbar-nav navbar-right">
            <% if (name == null || fname == null) { %>
              <li class="nav-item"><a href="Main?action=newRegister"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
              <li class="nav-item"><a data-toggle="collapse" data-target="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            <%} else { %>
              <li class="nav-item"><a href="#" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"><%=fname%> <%=name%> <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="Main?action=profile">My profile</a></li>
                  <li class="divider"></li>
                  <li><a href="Main?action=disconnect">Disconnect</a></li>
                </ul>
              </li>
             <% } %>
            </ul>
          </div>
        </div>
      </nav>
      <div style="width: 100%;background-color: rgba(255,255,255,0.8);">
      <br><br>
      </div>
      <div id="login" class="collapse" style="z-index:99;">
        <div class="panel panel-default col-md-2 col-md-offset-10" style="position: fixed; right: 0;">
          <div class="panel-body">
            <form class="form-horizontal" action="Main" method="POST" id="itemListe">
              <div class="form-group">
                <label class="control-label col-sm-5">Email</label>
                <div class="col-sm-7">
                  <input type="text" name="email" class="form-control" required>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-5">Password</label>
                <div class="col-sm-7">
                  <input type="text" name="password" class="form-control" required>
                </div>
              </div>
              <div class="col-xs-offset-4">
              	<input type="hidden" name="action" value="login" />
                <input type="submit" value="Se connecter"" class="btn btn-primary" />
              </div>
            </form>
          </div>
        </div>
      </div>

      <div class="container-fluid white-alt" id="Markets">
        <div class="vertical-center">
          <h1 style="text-align: center;font-size: 6em;color: #555;font-family: 'Chewy'">Ever been lost in a supermarket?</h1>
          <h2 style="text-align: center;font-size: 3em;font-family: 'Indie Flower'">We do have the solution!</h2>
          <div class="container" style="font-family: 'Lemonada'">
            <p style="text-align:center; font-size: 3em;">Join Us Now!</p>
            <form method="POST" class="form-horizontal" action="Main" id="mainForm">
              <div class="col-md-5">
                <input type="text" class="form-control formHome" name="email" placeholder="Email" style="font-size: 30px;height:50px">
              </div>
              <div class="col-md-5">
                <input type="password" class="form-control" name="password" placeholder="Password" style="font-size: 30px;height:50px">
              </div>
              <div class="col-md-2">
                <input type="submit" class="btn btn-primary" value="Sign Up" style="font-size: 30px;height:50px;vertical-align: middle;">
              </div>
                <input type="hidden" name="action" value="newRegister">
            </form>
          </div>
        </div>
      </div>


      <div class="container-fluid black-alt" id="Benefits" style="text-align: center;">
      <br/><br/>
      <div class="container vertical-center">
        <div class="container">
          <h1 class="mb-0" style="font-size: 3em;font-family: 'Chewy'">No more wasted time during your shopping!</h1>
          <h2 style="text-align: center;">With our service, you'll probably enjoy doing shopping in the mall!</h2>
        </div>
        <div class="container">
          <p>Find the best way to get everything on your shopping list. Give us your list, and we'll find you the fastest way to get everything in the supermarket you choose! Thousands of markets a refferenced, we'll sure have your favorite!</p>
        </div>

        <div class="container">
          <div class="col-md-4">
            <h2>List everything</h2><br><br>
            <div style="width:100%;height:100px;border-radius: 50%;background-color: rgba(255,255,255,0.8);text-align: center;" class="vertical-center">
              <i class="material-icons" style="font-size: 3em;color:black;">format_list_numbered</i>
            </div>
          </div>
          <div class="col-md-4">
            <h2>Choose a supermarket</h2><br><br>
            <div style="width:100%;height:100px;border-radius: 50%;background-color: rgba(255,255,255,0.8);text-align: center;" class="vertical-center">
              <i class="material-icons" style="font-size: 3em;color:black;">local_grocery_store</i>
            </div>
          </div>
          <div class="col-md-4">
            <h2>Follow the guide!</h2><br><br>
            <div style="width:100%;height:100px;border-radius: 50%;background-color: rgba(255,255,255,0.8);text-align: center;" class="vertical-center">
              <i class="material-icons" style="font-size: 3em;color:black;">directions</i>
            </div>
          </div>
        </div>
      </div>
      </div>


      <div class="container-fluid white-alt vertical-center" id="Supermarkets">
      <div class="container">
        <h1 style="font-size: 3em;font-family: 'Chewy';text-align: center;">Find your supermarket</h1>
      </div>
      <div class="container">
        <div class="col-xs-4 col-xs-offset-4">
          <a href="Main?action=newRegister">
            <button class="btn btn-primary" style="font-size: 2em; height: 70px; min-width:100%;">
              <span class="glyphicon glyphicon-map-marker" style="vertical-align: middle;"></span><span style="vertical-align: middle;"> Locate Me</span>
            </button>
          </a>
        </div>
      </div>
      <div class="container">
        <h1 style="font-size: 2em;font-family: 'Chewy'; text-align: center;">You are a supermarket, and you want to join us?</h1>
        <div class="container" style="display: inline-flex; flex-direction: row; justify-content: center;">
          <a href="Main?action=generateMagasin" class="btn btn-success col-xs-3" style="font-size: 2em; height: 70px;">
            <span class="glyphicon glyphicon-calendar" style="vertical-align: middle;"></span><span style="vertical-align: middle;"> Join us</span>
          </a>
        </div>
      </div>
      </div>  

      <div class="container-fluid black-alt" id="Contact">
      </div>  

      <div class="container-fluid" style="color: #999;background-color: #2F2F2F;">
        <div class="container">
          <div class="col-md-4">
            <h2 style="text-align: center;">Plan du site</h2>
            <ul>
              <li><a href="index.html">Home</a></li>
              <li><a href="lister.html">Build my shopping list</a></li>
              <li><a href="signIn.html">Connection</a></li>
            </ul>
          </div>
          <div class="col-md-4">
            <h2 style="text-align: center;">About us</h2>
          </div>
          <div class="col-md-4">
            <h2 style="text-align: center;">Contacts</h2>
          </div>
        </div>
      </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="js/bootstrap.min.js"></script>
      <script src="js/custom.js"></script>
  </body>
</html>
