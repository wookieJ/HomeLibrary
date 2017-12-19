package homeLibrary.model;

public class Rate
{
	private long id;
	private double value;
	private Book book;
	private User user;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rate other = (Rate) obj;
		if (book == null)
		{
			if (other.book != null)
				return false;
		}
		else if (!book.equals(other.book))
			return false;
		if (id != other.id)
			return false;
		if (user == null)
		{
			if (other.user != null)
				return false;
		}
		else if (!user.equals(other.user))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Rate [id=" + id + ", value=" + value + ", book=" + book + ", user=" + user + "]";
	}

	public Rate(long id, double value, Book book, User user)
	{
		this.id = id;
		this.value = value;
		this.book = book;
		this.user = user;
	}

	public Rate(Rate rate)
	{
		this.id = rate.id;
		this.value = rate.value;
		this.book = rate.book;
		this.user = rate.user;
	}

	public Rate()
	{

	}
}
