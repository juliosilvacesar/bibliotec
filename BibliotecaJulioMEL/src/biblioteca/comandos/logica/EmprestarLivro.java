package biblioteca.comandos.logica;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.daos.EmprestimoDAO;
import biblioteca.daos.LivroDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

public class EmprestarLivro implements Logica {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Emprestimo emprestimo = null;
		
		try {
			emprestimo = new Emprestimo();
			
			long idLivro = Long.parseLong(request.getParameter("livro"));
			Livro livro = new LivroDAO().getLivroById(idLivro);
			String matAluno = request.getParameter("aluno");
			Aluno aluno = new AlunoDAO().getAlunoByMatricula(matAluno);
			Calendar data = Calendar.getInstance();
			
			emprestimo.setLivro(livro);
			emprestimo.setAluno(aluno);
			emprestimo.setDataEmp(data);
			
			System.out.println("aqui");
			
			if(!aluno.isStatus()){
				
				return "Aluno.jsp";
			}
			
			if(aluno.getEmprestimos().size() >= Emprestimo.MAXIMO_ALUNO){
				
				return "Aluno.jsp";
			}
			
			
			if (new EmprestimoDAO().inserir(emprestimo)) {
				request.setAttribute
				("message", "Emprestimo para " + aluno.getNome() + " realisado com sucesso!");
			}else {
				return "erro.jsp";
			}
		} catch (Exception e) {
			return "erro.jsp";
		}
		return "index.jsp";
	}
}
