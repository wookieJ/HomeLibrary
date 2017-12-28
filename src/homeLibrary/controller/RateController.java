package homeLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeLibrary.model.Book;
import homeLibrary.model.Rate;
import homeLibrary.model.User;
import homeLibrary.service.BookService;
import homeLibrary.service.RateService;

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
			// Wartoœæ przes³anego parametru oceny
			double rateValue = 0;
			if (request.getParameter("inputRate").equals("") || request.getParameter("inputRate") == null)
			{
				System.out.println("SZUKANY PARAMETR NIE ISTNIEJE!");
			}
			else
				rateValue = Double.valueOf(request.getParameter("inputRate"));

			// Pobranie ksi¹¿ki i ID u¿ytkownika
			long userId = user.getId();
			long bookId = Long.valueOf(request.getParameter("book_id"));

			// Sprawdzenie, czy u¿ytkownik odda³ ju¿ g³os na dan¹ ksi¹¿kê
			RateService rateService = new RateService();
			Rate rateByUserIDAndBookId = rateService.getRateByUserIdAndBookId(userId, bookId);
			// U¿ytkownik nie odda³ g³osu
			if (rateByUserIDAndBookId == null)
			{
				System.out.println("BRAK OCENY! Tworzê now¹ ocenê");

				// Pobieram ksi¹¿kê i jej ocenê
				BookService bookService = new BookService();
				Book updateBook = bookService.getBookById(bookId);
				System.out.println(updateBook);
				double actualRate = updateBook.getRate();
				System.out.println("Actual rate: " + actualRate);

				// Sprawdzam ile jest g³osów na dan¹ ksi¹¿kê
				int numberOfRates = rateService.getNumberOfRatesByBookId(bookId);
				System.out.println("Number of Rates: " + numberOfRates);

				// Dodajê ocenê
				Rate rate = rateService.addRate(rateValue, userId, bookId);
				System.out.println(rate);

				// Obliczam now¹ œredni¹
				double newRate = (actualRate * numberOfRates + rateValue) / (numberOfRates + 1);
				System.out.println("New rate: " + newRate);

				// Uaktualniam œredni¹ ksi¹¿ki
				boolean ifUpdated = bookService.updateBookRate(bookId, newRate);
				if (ifUpdated == true)
					System.out.println("ZAKTUALIZOWANO KSIA¯KÊ!");
				else
					System.out.println("NIE ZAKTUALIZOWANO KSIA¯KI!");
			}
			// Jeœli u¿ytkownik oddawa³ ju¿ g³os na dan¹ ksi¹¿kê
			else
			{
				System.out.println("Aktualizujê obecn¹ ocenê");

				// Pobieram ksi¹¿kê i jej ocenê
				BookService bookService = new BookService();
				Book updateBook = bookService.getBookById(bookId);
				System.out.println(updateBook);
				double actualRate = updateBook.getRate();
				System.out.println("Actual rate: " + actualRate);

				// Sprawdzam ile jest g³osów na dan¹ ksi¹¿kê
				int numberOfRates = rateService.getNumberOfRatesByBookId(bookId);
				System.out.println("Number of Rates: " + numberOfRates);

				// Obliczam now¹ œredni¹
				double newRate = (actualRate * numberOfRates - rateByUserIDAndBookId.getValue() + rateValue) / numberOfRates;
				System.out.println("New rate: " + newRate);

				// Aktualizujê ocenê u¿ytkownika na dan¹ ksi¹¿kê
				boolean ifUpdatedRate = rateService.updateRate(rateByUserIDAndBookId.getId(), rateValue);
				if (ifUpdatedRate == true)
					System.out.println("ZAKTUALIZOWANO OCENÊ!");
				else
					System.out.println("NIE ZAKTUALIZOWANO OCENY!");

				// Aktualizacja œredniej ksi¹zki
				boolean ifUpdatedBook = bookService.updateBookRate(bookId, newRate);
				if (ifUpdatedBook == true)
					System.out.println("ZAKTUALIZOWANO KSIA¯KÊ!");
				else
					System.out.println("NIE ZAKTUALIZOWANO KSIA¯KI!");
			}
		}
		response.sendRedirect(request.getContextPath() + "/");
	}
}
