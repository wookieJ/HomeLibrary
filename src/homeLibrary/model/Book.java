package homeLibrary.model;

public class Book
{
	private long id;
	private String title;
	private String author;
	private String category;
	private String description;
	private String cover;
	private User user;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCover()
	{
		return cover;
	}

	public void setCover(String cover)
	{
		this.cover = cover;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Book(long id, String title, String author, String category, String description, String cover, User user)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.cover = cover;
		this.user = user;
	}
	
	public Book(Book book)
	{
		this.id = book.id;
		this.title = book.title;
		this.author = book.author;
		this.category = book.category;
		this.description = book.description;
		this.cover = book.cover;
		this.user = book.user;
	}

	public Book()
	{

	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Book other = (Book) obj;
		if (author == null)
		{
			if (other.author != null)
				return false;
		}
		else if (!author.equals(other.author))
			return false;
		if (category == null)
		{
			if (other.category != null)
				return false;
		}
		else if (!category.equals(other.category))
			return false;
		if (cover == null)
		{
			if (other.cover != null)
				return false;
		}
		else if (!cover.equals(other.cover))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		}
		else if (!title.equals(other.title))
			return false;
		if (user == null)
		{
			if (other.user != null)
				return false;
		}
		else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", description=" + description + ", cover=" + cover + ", user=" + user + "]";
	}
}
