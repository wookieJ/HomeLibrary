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
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BookService bookService = new BookService();
		List<Book> books = bookService.getAllBooks();
		List<String> categories = new ArrayList<>();

		categories.add("Programowanie");
		categories.add("Fantasy");
		categories.add("Sci-Fi");
		categories.add("Przygodowe");
		categories.add("Jêzyki obce");
		categories.add("Krymina³");
		categories.add("Biografia");
		
		request.setAttribute("books", books);
		request.setAttribute("categories", categories);
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
