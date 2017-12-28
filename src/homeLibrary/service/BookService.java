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
		book.setRate(0);
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
	
	public List<Book> getBooksByAuthor(String author)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		BookDAO bookDAO = factory.getBookDAO();
		List<Book> books = bookDAO.getBooksByAuthor(author);
		
		return books;
	}
	
	public List<Book> getBooksByCategory(String category)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		BookDAO bookDAO = factory.getBookDAO();
		List<Book> books = bookDAO.getBooksByCategory(category);
		
		return books;
	}
	
	public List<Book> getBooksByTitle(String title)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		BookDAO bookDAO = factory.getBookDAO();
		List<Book> books = bookDAO.getBooksByTitle(title);
		
		return books;
	}
	
	public boolean updateBook(long book_id, double value)
	{
		Book book = new Book();
		book.setId(book_id);
		book.setRate(value);
		DAOFactory factory = DAOFactory.getDAOFactory();
		BookDAO bookDAO = factory.getBookDAO();
		boolean ifUpdated = bookDAO.update(book);
		if(ifUpdated == true)
			return true;
		return false;
	}
	
	public Book getBookById(long book_id)
	{
		Book book = new Book();
		DAOFactory factory = DAOFactory.getDAOFactory();
		BookDAO bookDAO = factory.getBookDAO();
		
		book = bookDAO.read(book_id);
		return book;
	}
}
