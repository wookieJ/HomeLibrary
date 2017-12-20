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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getAll()
	{
		List<Book> listOfBooks = template.query(GET_ALL_BOOKS, new BookRowMapper());
		return listOfBooks;
	}

	@Override
	public List<Book> getBooksByAuthor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksByCategory()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookByTitle()
	{
		// TODO Auto-generated method stub
		return null;
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
