package homeLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.model.Book;
import homeLibrary.service.BookService;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/editBook")
public class EditController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		long bookId = Long.parseLong(request.getParameter("book"));
		BookService bookService = new BookService();
		Book book = null;
		book = bookService.getBookById(bookId);
		if(book != null)
			request.setAttribute("book", book);
		else
			response.sendRedirect(request.getContextPath() + "/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("inputTitle");
		String author = request.getParameter("inputAuthor");
		String category = request.getParameter("inputCategory");
		String description = request.getParameter("inputDescription");
		String cover = request.getParameter("inputFile");

		BookService bookService = new BookService();
		Book book = new Book();
		// Sprawdziæ, czy wszêdzie zmieniono dane => aktualizowaæ tylko zmienione, nulle pozostawiaæ
		// Trzebaby pozyskaæ ksi¹¿kê, która ju¿ jest i uzupe³niæ puste dane istniej¹cymi
		// W JSP wyœwietlaæ istniej¹ce dane - niekoniecznie w placeholderze
		book.setTitle(title);
		book.setAuthor(author);
		book.setCategory(category);
		book.setDescription(description);
		book.setCover(cover);

		bookService.updateBook(book);
		response.sendRedirect(request.getContextPath() + "/");
	}
}
