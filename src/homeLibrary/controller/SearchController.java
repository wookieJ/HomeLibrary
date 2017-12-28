package homeLibrary.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.model.Book;
import homeLibrary.service.BookService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String search = request.getParameter("searchInput");
		List<Book> booksByTitle = new ArrayList<>();
		List<Book> booksByAuthor = new ArrayList<>();
		List<Book> booksByCategory = new ArrayList<>();
		BookService bookService = new BookService();
		
		booksByTitle = bookService.getBooksByTitle(search);
		booksByAuthor = bookService.getBooksByAuthor(search);
		booksByCategory = bookService.getBooksByCategory(search);

		if (booksByTitle.isEmpty() && booksByAuthor.isEmpty() && booksByCategory.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/index.jsp?isEmpty=1");
		}
		else
		{
			if(! (booksByTitle.isEmpty()) )
				request.setAttribute("books", booksByTitle);
			else if(! (booksByAuthor.isEmpty()) )
				request.setAttribute("books", booksByAuthor);
			else if(! (booksByCategory.isEmpty()) )
				request.setAttribute("books", booksByCategory);
			
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

}
