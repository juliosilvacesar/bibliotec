package biblioteca.comandos.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class RemoverLivro implements Logica {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Long id = null;
		Livro livro = null;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
			livro = new LivroDAO().getLivroById(id); 
			
			if(new LivroDAO().remover(livro)){
				return "WEB-INF/ConfirmacaoLivroRemovido.jsp";
			}else {
				return "erro.jsp";
			}
		} catch (Exception e) {
			return "erro.jsp";
		}
	}

}
