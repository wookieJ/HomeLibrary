package homeLibrary.model;

public class Rate
{
	private long id;
	private double value;
	private long book_id;
	private long user_id;

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

	public long getBook_id()
	{
		return book_id;
	}

	public void setBook_id(long book_id)
	{
		this.book_id = book_id;
	}

	public long getUser_id()
	{
		return user_id;
	}

	public void setUser_id(long user_id)
	{
		this.user_id = user_id;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (book_id ^ (book_id >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
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
		if (book_id != other.book_id)
			return false;
		if (id != other.id)
			return false;
		if (user_id != other.user_id)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Rate [id=" + id + ", value=" + value + ", book_id=" + book_id + ", user_id=" + user_id + "]";
	}

	public Rate(long id, double value, long book_id, long user_id)
	{
		this.id = id;
		this.value = value;
		this.book_id = book_id;
		this.user_id = user_id;
	}

	public Rate(Rate rate)
	{
		this.id = rate.id;
		this.value = rate.value;
		this.book_id = rate.book_id;
		this.user_id = rate.user_id;
	}

	public Rate()
	{

	}
}
