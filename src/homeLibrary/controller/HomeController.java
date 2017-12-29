package homeLibrary.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.model.Book;
import homeLibrary.service.BookService;
import homeLibrary.service.UserService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getAttribute("books") == null)
		{
			BookService bookService = new BookService();
			List<Book> books = bookService.getAllBooks();

			// List<String> categories = new ArrayList<>();

			// categories.add("Programowanie");
			// categories.add("Fantasy");
			// categories.add("Sci-Fi");
			// categories.add("Przygodowe");
			// categories.add("Jêzyki obce");
			// categories.add("Krymina³");
			// categories.add("Biografia");

			books.sort(new Comparator<Book>()
			{
				@Override
				public int compare(Book o1, Book o2)
				{
					if (o1.getRate() < o2.getRate())
						return 1;
					else if (o1.getRate() > o2.getRate())
						return -1;
					return 0;
				}
			});

			request.setAttribute("books", books);
			// request.setAttribute("categories", categories);
		}
		if (request.getUserPrincipal() != null)
		{
			UserService userService = new UserService();
			String role = null;
			role = userService.getUserRoleByUsername(request.getUserPrincipal().getName().toString());
			if (role != null)
			{
				System.out.println("ROLE: " + role);
				request.setAttribute("roleName", role);
			}
		}
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}