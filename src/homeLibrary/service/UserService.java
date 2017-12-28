package homeLibrary.service;

import homeLibrary.dao.DAOFactory;
import homeLibrary.dao.UserDAO;
import homeLibrary.model.User;

public class UserService
{
	public void addUser(String username, String email, String password)
	{
		User user = new User();
		
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		userDAO.create(user);
	}
	
	public User getUserById(long id)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		User user = userDAO.read(id);
		
		return user;
	}
	
	public User getUserByUsername(String username)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        User user = userDao.getUserByUsername(username);
        
        return user;
	}
	
	public String getUserRoleByUsername(String username)
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        String role = userDao.getUserRoleByUsername(username);
        
        return role;
	}
}