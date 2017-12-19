package homeLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.model.User;

/**
 * Servlet implementation class RateController
 */
@WebServlet("/rate")
public class RateController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		if (user != null)
		{
			double rate = Double.valueOf(request.getParameter("inputRate"));
			/* Napisa� zabezpieczenie przed przes�aniem bez parametru */
			if (rate != 0)
			{
				/* Pobra� ocen� ksi��ki, obliczy� �redni� i zaktualizowa� */
				long userId = user.getId();
				long bookId = Long.valueOf(request.getParameter("book_id"));
			}
		}
		response.sendRedirect(request.getContextPath() + "/");
	}
}
