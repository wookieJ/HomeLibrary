package homeLibrary.dao;

import java.util.List;

import homeLibrary.model.Rate;

public interface RateDAO extends GenericDAO<Rate, Long>
{
	public List<Rate> getAll();
	public Rate getRateByUSerIdAndBookId(long user_id, long book_id);
	public int getNumberOfRowsByBookId(long book_id);
}