package homeLibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import homeLibrary.model.Rate;
import homeLibrary.util.ConnectionProvider;

public class RateDAOImpl implements RateDAO
{
	private final static String CREATE_RATE = "INSERT INTO rate (value, book_id, user_id) VALUES (:value, :book_id, :user_id);";
	private final static String GET_BY_USER_AND_BOOK_ID = "SELECT rate_id, value, book_id, user_id FROM rate WHERE user_id = :user_id AND book_id = :book_id;";
	private final static String GET_NUMBER_OF_ROWS_BY_BOOK_ID = "SELECT count( * ) AS 'number' FROM rate WHERE book_id = :book_id;";
	private final static String UPDATE_RATE = "UPDATE rate SET value = :value WHERE rate_id = :rate_id;";
	
	private NamedParameterJdbcTemplate template;
	
	public RateDAOImpl()
	{
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public Rate create(Rate rate)
	{
		Rate copyRate = new Rate(rate);
		Map <String,Object> paramMap = new HashMap<>();
		KeyHolder holder = new GeneratedKeyHolder();
		paramMap.put("value", copyRate.getValue());
		paramMap.put("book_id", copyRate.getBook_id());
		paramMap.put("user_id", copyRate.getUser_id());
		
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_RATE, paramSource, holder);
		if(update > 0)
		{
			copyRate.setId((Long) holder.getKey());
		}
		return copyRate;
	}

	@Override
	public Rate read(Long primaryKey)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Rate rate)
	{
		Map<String, Object> mapParameter = new HashMap<>();
		mapParameter.put("value", rate.getValue());
		mapParameter.put("rate_id", rate.getId());
		SqlParameterSource paramSource = new MapSqlParameterSource(mapParameter);
		int update = template.update(UPDATE_RATE, paramSource);
		
		if(update > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean delete(Long primaryKey)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Rate> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rate getRateByUSerIdAndBookId(long user_id, long book_id)
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("book_id", book_id);
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		Rate newRate = null;
		try
		{
			newRate = template.queryForObject(GET_BY_USER_AND_BOOK_ID, paramSource, new RateRowMapper());
		}
		catch(EmptyResultDataAccessException e)
		{
			e.printStackTrace();
			System.out.println("SZUKANA OCENA NIE ISTNIEJE W BAZIE DANYCH!");
		}

		return newRate;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getNumberOfRowsByBookId(long book_id)
	{
		SqlParameterSource paramSource = new MapSqlParameterSource("book_id", book_id);
		int numberOfRows = template.queryForInt(GET_NUMBER_OF_ROWS_BY_BOOK_ID, paramSource);
		
		return numberOfRows;
	}
	
	private class RateRowMapper implements RowMapper<Rate>
	{
		@Override
		public Rate mapRow(ResultSet resultSet, int row) throws SQLException
		{
			Rate rate = new Rate();
			rate.setId(resultSet.getInt("rate_id"));
			rate.setValue(resultSet.getDouble("value"));
			rate.setBook_id(resultSet.getLong("book_id"));
			rate.setUser_id(resultSet.getLong("user_id"));
			
			return rate;
		}
	}
}