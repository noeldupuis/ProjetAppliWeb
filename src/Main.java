import java.io.IOException;

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
		case "newRegister": request.getRequestDispatcher("signup.jsp").forward(request, response);
		case "login": Client c = facade.getSubscriber(request.getParameter("email"));
					  response.addCookie(new Cookie("name", c.getNom()));
					  response.addCookie(new Cookie("fname", c.getPrenom()));
					  request.getRequestDispatcher("index.jsp").forward(request, response);
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
