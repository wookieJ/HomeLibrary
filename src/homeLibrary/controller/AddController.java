package homeLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.model.User;
import homeLibrary.service.BookService;
import homeLibrary.service.UserService;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/add")
public class AddController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("WEB-INF/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("inputTitle");
		String author = request.getParameter("inputAuthor");
		String category = request.getParameter("inputCategory");
		String description = request.getParameter("inputDescription");
		String cover = request.getParameter("inputFile");
		// String choice = request.getParameter("inputOption");

		saveFile(cover, request, response);

		BookService bookService = new BookService();
		UserService userService = new UserService();
		User user = userService.getUserByUsername(request.getUserPrincipal().getName());

		bookService.addBook(title, author, category, description, cover, user);
		response.sendRedirect(request.getContextPath() + "/");
	}

	private void saveFile(String dir, HttpServletRequest request, HttpServletResponse response) throws ServletException
	{
		
		
	}
}
