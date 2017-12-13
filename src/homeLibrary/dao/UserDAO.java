package homeLibrary.dao;

import java.util.List;

import homeLibrary.model.User;

public interface UserDAO extends GenericDAO<User, Long>
{
	public List<User> getAll();
	public User getUserByUsername(String username);
}
