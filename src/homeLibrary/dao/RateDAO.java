package homeLibrary.dao;

import java.util.List;

import homeLibrary.model.Rate;

public interface RateDAO extends GenericDAO<Rate, Long>
{
	public List<Rate> getAll();
}