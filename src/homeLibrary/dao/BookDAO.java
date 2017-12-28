package homeLibrary.dao;

import java.util.List;

import homeLibrary.model.Book;

public interface BookDAO extends GenericDAO<Book, Long>
{
	public List<Book> getAll();
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByCategory(String Category);
	public List<Book> getBooksByTitle(String title);
	public boolean updateRate(Book book);
}
