package biblioteca.comandos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;

public class BuscaAluno implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Aluno> result = new ArrayList<>();

		try {
			result = new AlunoDAO().getLista();
			
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		
		request.setAttribute("alunos", result);

		return "ListarAlunos.jsp";
		
	}
}