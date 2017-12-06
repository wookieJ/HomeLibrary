package homeLibrary.dao;

import java.util.List;

import homeLibrary.model.Book;

public interface BookDAO extends GenericDAO<Book, Long>
{
	public List<Book> getAll();
	public List<Book> getBooksByAuthor();
	public List<Book> getBooksByCategory();
	public Book getBookByTitle();
}
