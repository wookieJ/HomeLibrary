package homeLibrary.service;

import java.util.List;

import homeLibrary.dao.BookDAO;
import homeLibrary.dao.DAOFactory;
import homeLibrary.model.Book;
import homeLibrary.model.User;

public class BookService
{
	public void addBook(String title, String author, String category, String description, String cover, User user)
	{
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setCategory(category);
		book.setDescription(description);
		book.setCover(cover);
		book.setUser(user);
		
		DAOFactory factory = DAOFactory.getDAOFactory();
		BookDAO bookDAO = factory.getBookDAO();
		bookDAO.create(book);
	}
	
	public List<Book> getAllBooks()
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		BookDAO bookDAO = factory.getBookDAO();
		List<Book> books = bookDAO.getAll();
		
		return books;
	}
}
