package homeLibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import homeLibrary.model.Book;
import homeLibrary.model.User;
import homeLibrary.util.ConnectionProvider;

public class BookDAOImpl implements BookDAO
{
	private final static String CREATE_BOOK = "INSERT INTO book (title, author, category, user_id, description, rate, cover) VALUES(:title, :author, :category, :user_id, :description, :rate, :cover);";
	private final static String GET_ALL_BOOKS = "SELECT book_id, title, author, category, book.user_id, description, rate, cover, user.username FROM book LEFT JOIN user ON book.user_id = user.user_id;";
	private final static String GET_BOOK_BY_ID = "SELECT book_id, title, author, category, user_id, description, rate, cover FROM book WHERE book_id = :book_id;";
	private final static String UPDATE_BOOK = "UPDATE book SET rate = :value WHERE book_id = :book_id;";
	private final static String GET_BOOKS_BY_AUTHOR = "SELECT book_id, title, author, category, book.user_id, description, rate, cover, user.username FROM book LEFT JOIN user ON book.user_id = user.user_id WHERE author = :author;";
	private final static String GET_BOOKS_BY_CATEGORY = "SELECT book_id, title, author, category, book.user_id, description, rate, cover, user.username FROM book LEFT JOIN user ON book.user_id = user.user_id WHERE category = :category;";
	private final static String GET_BOOKS_BY_TITLE = "SELECT book_id, title, author, category, book.user_id, description, rate, cover, user.username FROM book LEFT JOIN user ON book.user_id = user.user_id WHERE title = :title;";
	private final static String DELETE_BOOK = "DELETE FROM book WHERE book_id = :book_id;";
	
	private NamedParameterJdbcTemplate template;
	
	public BookDAOImpl()
	{
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public Book create(Book book)
	{
		Book bookCopy = new Book(book);
		KeyHolder holder = new GeneratedKeyHolder();
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("title", bookCopy.getTitle());
		paramMap.put("author", bookCopy.getAuthor());
		paramMap.put("category", bookCopy.getCategory());
		paramMap.put("user_id", bookCopy.getUser().getId());
		paramMap.put("description", bookCopy.getDescription());
		paramMap.put("rate", bookCopy.getRate());
		paramMap.put("cover", bookCopy.getCover());
		
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_BOOK, paramSource, holder);
		
		if(update > 0)
		{
			bookCopy.setId((Long)holder.getKey());
		}
		
		return bookCopy;
	}

	@Override
	public Book read(Long id)
	{
		SqlParameterSource paramSource = new MapSqlParameterSource("book_id", id);
		Book book = template.queryForObject(GET_BOOK_BY_ID, paramSource, new BookSimpleRowMapper());
		
		return book;
	}

	@Override
	public boolean update(Book book)
	{
		Map<String, Object> mapParameter = new HashMap<>();
		mapParameter.put("value", book.getRate());
		mapParameter.put("book_id", book.getId());
		SqlParameterSource paramSource = new MapSqlParameterSource(mapParameter);
		int update = template.update(UPDATE_BOOK, paramSource);
		
		if(update > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean delete(Long id)
	{
		boolean ifDeleted = false;
		SqlParameterSource paramMap = new MapSqlParameterSource("book_id", id);
		int update = template.update(DELETE_BOOK, paramMap);
		if(update > 0)
			ifDeleted = true;
		return ifDeleted;
	}

	@Override
	public List<Book> getAll()
	{
		List<Book> listOfBooks = template.query(GET_ALL_BOOKS, new BookRowMapper());
		return listOfBooks;
	}

	@Override
	public List<Book> getBooksByAuthor(String author)
	{
		SqlParameterSource paramSource = new MapSqlParameterSource("author", author);
		List<Book> listOfBooks = template.query(GET_BOOKS_BY_AUTHOR, paramSource, new BookRowMapper());
		return listOfBooks;
	}

	@Override
	public List<Book> getBooksByCategory(String category)
	{
		SqlParameterSource paramSource = new MapSqlParameterSource("category", category);
		List<Book> listOfBooks = template.query(GET_BOOKS_BY_CATEGORY, paramSource, new BookRowMapper());
		return listOfBooks;
	}

	@Override
	public List<Book> getBooksByTitle(String title)
	{
		SqlParameterSource paramSource = new MapSqlParameterSource("title", title);
		List<Book> listOfBooks = template.query(GET_BOOKS_BY_TITLE, paramSource, new BookRowMapper());
		return listOfBooks;
	}
	
	private class BookSimpleRowMapper implements RowMapper<Book>
	{
		@Override
		public Book mapRow(ResultSet resultSet, int row) throws SQLException
		{
			Book book = new Book();
			book.setId(resultSet.getLong("book_id"));
			book.setTitle(resultSet.getString("title"));
			book.setAuthor(resultSet.getString("author"));
			book.setDescription(resultSet.getString("description"));
			book.setCategory(resultSet.getString("category"));
			book.setRate(resultSet.getDouble("rate"));
			book.setCover(resultSet.getString("cover"));
			
			return book;
		}
	}
	
	private class BookRowMapper implements RowMapper<Book>
	{
		@Override
		public Book mapRow(ResultSet resultSet, int row) throws SQLException
		{
			Book book = new Book();
			book.setId(resultSet.getLong("book_id"));
			book.setTitle(resultSet.getString("title"));
			book.setAuthor(resultSet.getString("author"));
			book.setDescription(resultSet.getString("description"));
			book.setCategory(resultSet.getString("category"));
			book.setRate(resultSet.getDouble("rate"));
			book.setCover(resultSet.getString("cover"));
			
			User user = new User();
			user.setId(resultSet.getLong("user_id"));
//			user.setEmail(resultSet.getString("email"));
			user.setUsername(resultSet.getString("username"));
			
			book.setUser(user);
	
			return book;
		}
	}
}
