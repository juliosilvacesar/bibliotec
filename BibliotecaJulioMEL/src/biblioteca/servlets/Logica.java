package biblioteca.servlets;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;

	String execute(HttpServletRequest request, HttpServletResponse response);

	
	
}
