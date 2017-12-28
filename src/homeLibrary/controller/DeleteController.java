package homeLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.service.BookService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/deleteBook")
public class DeleteController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		long bookId = Long.parseLong(request.getParameter("book"));
		BookService bookService = new BookService();
		boolean isDeleted = bookService.deleteBook(bookId);
		if(isDeleted)
			System.out.println("Usuniêto ksi¹¿kê");
		response.sendRedirect(request.getContextPath() + "/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}
}
