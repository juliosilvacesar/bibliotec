package biblioteca.comandos.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;

public class AlterarAluno implements Logica {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			Aluno aluno = new AlunoDAO().getAlunoById(id);
			
			request.setAttribute("aluno", aluno);
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		return "Aluno.jsp";
	}
}
