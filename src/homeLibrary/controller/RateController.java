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
			// Warto�� przes�anego parametru oceny
			double rateValue = 0;
			if (request.getParameter("inputRate").equals("") || request.getParameter("inputRate") == null)
			{
				System.out.println("SZUKANY PARAMETR NIE ISTNIEJE!");
			}
			else
				rateValue = Double.valueOf(request.getParameter("inputRate"));

			// Pobranie ksi��ki i ID u�ytkownika
			long userId = user.getId();
			long bookId = Long.valueOf(request.getParameter("book_id"));

			// Sprawdzenie, czy u�ytkownik odda� ju� g�os na dan� ksi��k�
			RateService rateService = new RateService();
			Rate rateByUserIDAndBookId = rateService.getRateByUserIdAndBookId(userId, bookId);
			// U�ytkownik nie odda� g�osu
			if (rateByUserIDAndBookId == null)
			{
				System.out.println("BRAK OCENY! Tworz� now� ocen�");

				// Pobieram ksi��k� i jej ocen�
				BookService bookService = new BookService();
				Book updateBook = bookService.getBookById(bookId);
				System.out.println(updateBook);
				double actualRate = updateBook.getRate();
				System.out.println("Actual rate: " + actualRate);

				// Sprawdzam ile jest g�os�w na dan� ksi��k�
				int numberOfRates = rateService.getNumberOfRatesByBookId(bookId);
				System.out.println("Number of Rates: " + numberOfRates);

				// Dodaj� ocen�
				Rate rate = rateService.addRate(rateValue, userId, bookId);
				System.out.println(rate);

				// Obliczam now� �redni�
				double newRate = (actualRate * numberOfRates + rateValue) / (numberOfRates + 1);
				System.out.println("New rate: " + newRate);

				// Uaktualniam �redni� ksi��ki
				boolean ifUpdated = bookService.updateBookRate(bookId, newRate);
				if (ifUpdated == true)
					System.out.println("ZAKTUALIZOWANO KSIA�K�!");
				else
					System.out.println("NIE ZAKTUALIZOWANO KSIA�KI!");
			}
			// Je�li u�ytkownik oddawa� ju� g�os na dan� ksi��k�
			else
			{
				System.out.println("Aktualizuj� obecn� ocen�");

				// Pobieram ksi��k� i jej ocen�
				BookService bookService = new BookService();
				Book updateBook = bookService.getBookById(bookId);
				System.out.println(updateBook);
				double actualRate = updateBook.getRate();
				System.out.println("Actual rate: " + actualRate);

				// Sprawdzam ile jest g�os�w na dan� ksi��k�
				int numberOfRates = rateService.getNumberOfRatesByBookId(bookId);
				System.out.println("Number of Rates: " + numberOfRates);

				// Obliczam now� �redni�
				double newRate = (actualRate * numberOfRates - rateByUserIDAndBookId.getValue() + rateValue) / numberOfRates;
				System.out.println("New rate: " + newRate);

				// Aktualizuj� ocen� u�ytkownika na dan� ksi��k�
				boolean ifUpdatedRate = rateService.updateRate(rateByUserIDAndBookId.getId(), rateValue);
				if (ifUpdatedRate == true)
					System.out.println("ZAKTUALIZOWANO OCEN�!");
				else
					System.out.println("NIE ZAKTUALIZOWANO OCENY!");

				// Aktualizacja �redniej ksi�zki
				boolean ifUpdatedBook = bookService.updateBookRate(bookId, newRate);
				if (ifUpdatedBook == true)
					System.out.println("ZAKTUALIZOWANO KSIA�K�!");
				else
					System.out.println("NIE ZAKTUALIZOWANO KSIA�KI!");
			}
		}
		response.sendRedirect(request.getContextPath() + "/");
	}
}
