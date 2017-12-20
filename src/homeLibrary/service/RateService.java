package homeLibrary.service;

import homeLibrary.dao.DAOFactory;
import homeLibrary.dao.RateDAO;
import homeLibrary.model.Rate;

public class RateService
{
	public Rate addRate(double value, long userId, long bookId)
	{
		Rate newRate = new Rate();
		newRate.setValue(value);
		newRate.setUser_id(userId);
		newRate.setBook_id(bookId);

		DAOFactory factory = DAOFactory.getDAOFactory();
		RateDAO rateDAO = factory.getRateDAO();
		newRate = rateDAO.create(newRate);
		return newRate;
	}

	public Rate getRateByUserIdAndBookId(long user_id, long book_id)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		RateDAO rateDAO = factory.getRateDAO();
		Rate rate = rateDAO.getRateByUSerIdAndBookId(user_id, book_id);
		return rate;
	}
	
	public int getNumberOfRatesByBookId(long book_id)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		RateDAO rateDAO = factory.getRateDAO();
		int rows = rateDAO.getNumberOfRowsByBookId(book_id);
		
		return rows;
	}
	
	public boolean updateRate(long rate_id, double value)
	{
		Rate rate = new Rate();
		rate.setId(rate_id);
		rate.setValue(value);
		DAOFactory factory = DAOFactory.getDAOFactory();
		RateDAO rateDAO = factory.getRateDAO();
		boolean ifUpdated = rateDAO.update(rate);
		
		if(ifUpdated == true)
			return true;
		return false;
	}
}
