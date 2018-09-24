package biblioteca.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.servlets.Logica;;

@WebServlet("/servico")
public class ControllerServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = null;
		String answer = null;
		
		
		String logicaReq = request.getParameter("comando");
		String command = "biblioteca.comando.logicas." + logicaReq;
		try {
			Class<?> classe = Class.forName(command);
			Logica logica = (Logica)classe.newInstance();

			answer = logica.executa(request, response);
		} catch (Exception e) {
			answer = "erro.jsp";
		}
		
		dispatcher = request.getRequestDispatcher(answer);
		dispatcher.forward(request, response);
	}
}