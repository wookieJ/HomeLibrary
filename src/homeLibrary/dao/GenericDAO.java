package homeLibrary.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable>
{
	public T create(T newObject);
	public T read(PK primaryKey);
	public boolean update(T updateObject);
	public boolean delete(PK primaryKey);
	public List<T> getAll();
}
