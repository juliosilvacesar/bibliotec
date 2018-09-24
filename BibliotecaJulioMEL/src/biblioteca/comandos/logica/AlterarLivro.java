package biblioteca.comandos.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class AlterarLivro implements Logica {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			Livro livro = new LivroDAO().getLivroById(id);
			
			request.setAttribute("livro", livro);
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		return "Livro.jsp";
	}
}
