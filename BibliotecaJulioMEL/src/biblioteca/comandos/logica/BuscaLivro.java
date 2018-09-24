package biblioteca.comandos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class BuscaLivro implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String titulo = request.getParameter("titulo");
		List<Livro> result = new ArrayList<>();
		
		try {
			
			if(titulo== null || titulo.equals("0") || titulo.isEmpty() || titulo.length() == 0){
				result = new LivroDAO().getLista();
			}
			
			else {
				for(Livro livro : new LivroDAO().getLista()){
					if(livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
						result.add(livro);
					}
				}
			}
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		
		request.setAttribute("livros", result);
		
		return "ListarLivros.jsp";
	};
}