package homeLibrary.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		String md5Pass = encryptPassword(password);
        user.setPassword(md5Pass);

		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		userDAO.create(user);
	}

	private String encryptPassword(String password)
	{
		MessageDigest digest = null;
		try
		{
			digest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		digest.update(password.getBytes());
		String md5Password = new BigInteger(1, digest.digest()).toString(16);
		return md5Password;
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