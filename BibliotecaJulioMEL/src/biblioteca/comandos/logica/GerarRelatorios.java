package biblioteca.comandos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.daos.EmprestimoDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;

public class GerarRelatorios implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Emprestimo> emprestimos = new ArrayList<>();
		List<Aluno> alunosDias = new ArrayList<>();
		List<Aluno> alunosAtra = new ArrayList<>();
		
		try {
			for(Aluno aluno : new AlunoDAO().getLista()){
				if(!aluno.getEmprestimos().isEmpty()){
					if(aluno.isStatus()){
						alunosDias.add(aluno);
					}else {
						alunosAtra.add(aluno);
					}
				}
			}
			emprestimos = new EmprestimoDAO().getLista();

			
			request.setAttribute("emprestimos", emprestimos);
			request.setAttribute("alunosD", alunosDias);
			request.setAttribute("alunosA", alunosAtra);
			
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		return "relatorio.jsp";
	};
}