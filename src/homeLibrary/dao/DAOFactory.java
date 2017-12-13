package homeLibrary.dao;

public abstract class DAOFactory
{
	public abstract UserDAO getUserDAO();

	public abstract BookDAO getBookDAO();

	public static DAOFactory getDAOFactory()
	{
		DAOFactory factory = null;
		factory = new MysqlDAOFactory();
		
		return factory;
	}
}
