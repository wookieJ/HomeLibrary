package homeLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.service.UserService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("inputUsername");
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");

		UserService userService = new UserService();
//		User compareUser = userService.getUserByUsername(username);
		
//		if(compareUser == null)
//		{
//			System.out.println("adding...");
			userService.addUser(username, email, password);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
//		}
		// Sprawdzi� czy nie ma ju� takiego u�ytklownika w bazie
//		else if (compareUser.getUsername().equals(username) || compareUser.getEmail().equals(email))
//		{
//			response.sendRedirect(request.getContextPath() + "/register.jsp?repeat=1");
//		}
	}
}
