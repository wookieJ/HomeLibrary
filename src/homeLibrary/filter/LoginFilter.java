package homeLibrary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import homeLibrary.model.User;
import homeLibrary.service.UserService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter
{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest httpReq = (HttpServletRequest) request;
		// Je¿eli u¿ytkownik jest zalogowany ale nie jest zapisany w sesji
		if (httpReq.getUserPrincipal() != null && httpReq.getSession().getAttribute("user") == null)
		{
			UserService userService = new UserService();
			// Pobranie nazwy zalogowanego u¿ytkownika
			String username = httpReq.getUserPrincipal().getName();
			// Odczytanie u¿ytkoniwka z bazy danych
			User userByUsername = userService.getUserByUsername(username);
			// Zapis uzytkownika do sesji
			httpReq.getSession().setAttribute("user", userByUsername);
		}
		// Przekazanie dalej ¿¹dania
		chain.doFilter(request, response);
	}

	@Override
	public void destroy()
	{
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
	}
}
