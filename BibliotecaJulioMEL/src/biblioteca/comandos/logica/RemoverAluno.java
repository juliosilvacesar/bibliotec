package biblioteca.comandos.logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;

public class RemoverAluno implements Logica {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Long id = null;
		Aluno aluno = null;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
			aluno = new AlunoDAO().getAlunoById(id);

			if(new AlunoDAO().remover(aluno)){
				return "WEB-INF/ConfirmacaoAlunoRemovido.jsp";
			}else {
				return "erro.jsp";
			}
			
		} catch (Exception e) {
			return "erro.jsp";
		}
	}
}
