package homeLibrary.dao;

public class MysqlDAOFactory extends DAOFactory
{
	@Override
	public UserDAO getUserDAO()
	{
		return new UserDAOImpl();
	}

	@Override
	public BookDAO getBookDAO()
	{
		return new BookDAOImpl();
	}
}
