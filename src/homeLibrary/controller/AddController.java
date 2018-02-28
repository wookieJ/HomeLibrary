package homeLibrary.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import homeLibrary.model.User;
import homeLibrary.service.BookService;
import homeLibrary.service.UserService;

/**
 * Servlet implementation class AddController
 */
@MultipartConfig
@WebServlet("/add")
public class AddController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String PATH = "\\HomeLibrary\\resources\\covers";
	private static final String LOCAL_PATH = "resources\\covers";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("WEB-INF/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("inputTitle");
		String author = request.getParameter("inputAuthor");
		String category = request.getParameter("inputCategory");
		String description = request.getParameter("inputDescription");
		Part coverPart = request.getPart("inputFile");
		String cover = PATH + "\\" + getFileName(coverPart);
		// String choice = request.getParameter("inputOption");
		System.out.println("cover = " + cover);
		saveFile(coverPart, request, response);

		BookService bookService = new BookService();
		UserService userService = new UserService();
		User user = userService.getUserByUsername(request.getUserPrincipal().getName());

		bookService.addBook(title, author, category, description, cover, user);
		response.sendRedirect(request.getContextPath() + "/");
		
	}

	private void saveFile(Part filePart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final String fileName = getFileName(filePart);
		OutputStream out = null;
		InputStream filecontent = null;

		try
		{
			String webAppPath = getServletContext().getRealPath("/");
			File dirFile = new File(webAppPath + LOCAL_PATH + "\\" + fileName);
			System.out.println("saveFile(): " + webAppPath + LOCAL_PATH + "\\" + fileName);
			if(!dirFile.exists())
				dirFile.createNewFile();
			
			out = new FileOutputStream(dirFile);
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1)
			{
				out.write(bytes, 0, read);
			}
		}
		catch (FileNotFoundException fne)
		{
			fne.printStackTrace();
		}
		finally
		{
			if (out != null)
			{
				out.close();
			}
			if (filecontent != null)
			{
				filecontent.close();
			}
		}
	}

	private String getFileName(final Part part)
	{
		for (String content : part.getHeader("content-disposition").split(";"))
		{
			if (content.trim().startsWith("filename"))
			{
				String tmp = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
				for(String dir: tmp.split("\\\\"))
				{
					if(dir.contains("."))
						return dir;
				}
			}
		}
		return null;
	}
}
