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
            <a class="navbar-brand mb-0" href="#">EasyShopping</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" style="text-align: center;">
              <li class="nav-item active">
                <a class="nav-link scroll-link" data-id="Markets" href="#Markets" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link scroll-link" data-id="Benefits" href="#Benefits" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Benefits</a>
              </li>
              <li class="nav-item">
                <a class="nav-link scroll-link" data-id="Supermarkets" href="#Supermarkets" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Supermarkets</a>
              </li>
              <li class="nav-item">
                <a class="nav-link scroll-link" data-id="Contact" href="#Contact" onclick="$('li').removeClass('active');$(this).parent().addClass('active');">Contact Us</a>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="nav-item"><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
              <li class="nav-item"><a data-toggle="collapse" data-target="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
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
                  <input type="text" class="form-control" required>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-5">Password</label>
                <div class="col-sm-7">
                  <input type="text" class="form-control" required>
                </div>
              </div>
              <div class="col-xs-offset-4">
                <input type="button" value="Ajouter" class="btn btn-primary" />
              </div>
            </form>
          </div>
        </div>
      </div>

      <div class="container-fluid white-alt" id="Markets">
        <div class="container">
          <h1 style="text-align: center;font-size: 6em;color: #555;font-family: 'Chewy'">Nous rejoindre?</h1>
          <h2 style="text-align: center;font-size: 3em;font-family: 'Indie Flower'">Inscris-toi simplement</h2>
          <div class="container vertical-center" style="font-family: 'Lemonada'">
            <form class="form" action="Main" method="POST" id="mainForm">
              <div class="form-group col-sm-6">
                <label class="control-label">Name</label>
                <input type="text" name="name" class="form-control" required>
              </div>
              <div class="form-group col-sm-6">
                <label class="control-label"> First name</label>
                <input type="text" name="fname" class="form-control" required>
              </div>
              <div class="form-group col-sm-6">
                <label class="control-label">Email</label>
                <input type="text" name="email" class="form-control" <% if (request.getParameter("email")!= null) { %>value="<%=request.getParameter("email")%>"<%}%>required>
              </div>
              <div class="form-group col-sm-6">
                <label class="control-label">Confirm email</label>
                <input type="text" class="form-control" required>
              </div>
              <div class="form-group col-sm-6">
                <label class="control-label">Password</label>
                  <input type="text" name="password" class="form-control" <% if (request.getParameter("password")!= null) { %>value="<%=request.getParameter("password")%>"<%}%> required>
              </div>
              <div class="form-group col-sm-6">
                <label class="control-label">Confirm password</label>
                  <input type="text" class="form-control" required>
              </div>
              <div>
                <label class="checkbox-inline"><input type="checkbox" value="" required>I agree with Terms and Contions of Use of the service. (required)</label> 
              </div>
              <div class="col-xs-offset-4">
                <input type="hidden" name="action" value="registerClient">
                <input type="submit" value="S'inscrire" class="btn btn-primary" >
              </div>
            </form>
          </div>
        </div>
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
