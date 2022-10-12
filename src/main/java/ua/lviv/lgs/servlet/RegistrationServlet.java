package ua.lviv.lgs.servlet;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private UserService userService = UserServiceImpl.getUserService();
	private static Logger LOGGER = Logger.getLogger(RegistrationServlet.class);

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (!username.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
			try {
				userService.create(new User(username, lastName, email, password));
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}

		request.setAttribute("username", username);
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
