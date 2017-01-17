import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet(description = "Main servlet of deployment", urlPatterns = { "/Main" })
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	Facade facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "registerClient" : String nom = request.getParameter("name");
								String fnom = request.getParameter("fname");
								String email = request.getParameter("email");
								String password = request.getParameter("password");
								facade.subscribe(nom, fnom, email, password);
								request.getRequestDispatcher("index.jsp").forward(request, response);
								break;
		case "newRegister": request.getRequestDispatcher("signup.jsp").forward(request, response); break;
		case "welcome": request.getRequestDispatcher("index.jsp").forward(request, response); break;
		case "login": Client c = facade.getSubscriber(request.getParameter("email"), request.getParameter("password"));
						if (c!=null) {
							response.addCookie(new Cookie("name", c.getNom()));
							response.addCookie(new Cookie("fname", c.getPrenom()));
							request.setAttribute("erreur", "1");
						}
						else {
							request.setAttribute("erreur", "1");
						}
					  request.getRequestDispatcher("index.jsp").forward(request, response);break;
		case "disconnect": for (Cookie cook : request.getCookies()) {
								Cookie cookie = (Cookie) cook.clone();
								cookie.setMaxAge(0);
								response.addCookie(cookie);
							}
							request.getRequestDispatcher("index.jsp").forward(request, response); break;
		case "shop": 	boolean connected = false;
						for (Cookie cook : request.getCookies()) {
							if (cook.getName().equals("name")) {
								connected = true;
							}
						}
						if (connected) {
							request.getRequestDispatcher("magasins.jsp").forward(request, response);
						}
						else {
							request.getRequestDispatcher("magasins.jsp").forward(request, response);
						}
						break;
		case "GPS": List<Magasin> liste = facade.localiser(Double.parseDouble(request.getParameter("longitude")),Double.parseDouble(request.getParameter("latitude")));
							request.setAttribute("magasins", liste);
							request.getSession().setAttribute("REFRESH","TRUE");
							request.getRequestDispatcher("magasins.jsp").forward(request, response);
							break;
		case "location": String loc = request.getParameter("location");
							List<String> listeL = facade.nomsMagasin(loc);
							request.setAttribute("magasins", listeL);
							request.getSession().setAttribute("REFRESH","TRUE");
							request.getRequestDispatcher("magasins.jsp").forward(request, response);
							break;
						
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
