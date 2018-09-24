package biblioteca.comandos.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;
import biblioteca.servlets.Logica;

public class AdicionarAluno implements Logica {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Aluno aluno = new Aluno();

		String id = request.getParameter("id");
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");

		String dataText = request.getParameter("dataNascimento");
		Calendar data = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataText);
			data = Calendar.getInstance();
			data.setTime(date);
		} catch (Exception e) {
			return "aluno-cadastrado.jsp";
		}

		
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(data);
		
		
		try {
			if (id == null || id.equals("0") || id.isEmpty() || id.length() == 0) {
				new AlunoDAO().inserir(aluno);
			} else {
				aluno.setId(Long.parseLong(id));
				new AlunoDAO().atualisar(aluno);
			}

		} catch (Exception e) {
			return "AlunoDAO";
		}
		return "WEB-INF/ConfirmacaoAlunoCadastrado.jsp" ;
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
