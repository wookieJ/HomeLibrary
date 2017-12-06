package homeLibrary.dao;

public abstract class DAOFactory
{
	public abstract UserDAO getUserDAO();
	public abstract BookDAO getBookDAO();
}
