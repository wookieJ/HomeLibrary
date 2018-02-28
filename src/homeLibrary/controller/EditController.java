package homeLibrary.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import homeLibrary.model.Book;
import homeLibrary.service.BookService;

/**
 * Servlet implementation class EditController
 */
@MultipartConfig
@WebServlet("/editBook")
public class EditController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String PATH = "\\HomeLibrary\\resources\\covers";
	private static final String LOCAL_PATH = "resources\\covers";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		long bookId = -1;
		bookId = Long.parseLong(request.getParameter("book"));
		if (bookId > -1)
		{
			BookService bookService = new BookService();
			Book book = null;
			book = bookService.getBookById(bookId);
			if (book != null)
			{
				request.setAttribute("book", book);
				request.getRequestDispatcher("WEB-INF/edit.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
			}
		}
		else
		{
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		long bookId = Long.parseLong(request.getParameter("book_id"));
		
		BookService bookService = new BookService();
		Book book = new Book();
		book = bookService.getBookById(bookId);
		
		String title = request.getParameter("inputTitle");
		String author = request.getParameter("inputAuthor");
		String category = request.getParameter("inputCategory");
		String description = request.getParameter("inputDescription");
		Part coverPart = request.getPart("inputFile");
		String cover = PATH + "\\" + getFileName(coverPart);
		
		// Sprawdziæ, czy wszêdzie zmieniono dane => aktualizowaæ tylko
		// zmienione, nulle pozostawiaæ
		// Trzebaby pozyskaæ ksi¹¿kê, która ju¿ jest i uzupe³niæ puste dane
		// istniej¹cymi
		// W JSP wyœwietlaæ istniej¹ce dane - niekoniecznie w placeholderze

		book.setId(bookId);
		if(title.equals(""))
			book.setTitle(title);
		book.setAuthor(author);
		book.setCategory(category);
		book.setDescription(description);
		if(getFileName(coverPart) != null)
			book.setCover(cover);

		bookService.updateBook(book);
		response.sendRedirect(request.getContextPath() + "/");
	}

	private String getFileName(final Part part)
	{
		for (String content : part.getHeader("content-disposition").split(";"))
		{
			if (content.trim().startsWith("filename"))
			{
				String tmp = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
				for(String dir: tmp.split("\\\\"))
				{
					if(dir.contains("."))
						return dir;
				}
			}
		}
		return null;
	}
}
