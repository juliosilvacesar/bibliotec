package biblioteca.comandos.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.EmprestimoDAO;
import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class DevolverLivro implements Logica{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		long id = Long.parseLong(request.getParameter("id"));
		Livro livro = new LivroDAO().getLivroById(id);
		
		try{
			if(new EmprestimoDAO().removerByLivro(livro)){
				request.setAttribute
				("message", livro.getTitulo() + " devolvido à biblioteca. Obrigado.");
			}else {
				return "erro.jsp";
			}
		}
		catch (Exception e) {
			return "erro.jsp";
		}
		
		return "index.jsp";
	}
}
