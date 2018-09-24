package biblioteca.comandos.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class AdicionarLivro implements Logica{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		Livro livro = new Livro();
		
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		int edicao = Integer.parseInt(request.getParameter("edicao"));
		
		String dataText = request.getParameter("publicacao");
		Calendar data = null;
		
		try {
			Date date = new SimpleDateFormat("yyyy").parse(dataText);
			data = Calendar.getInstance();
			data.setTime(date);
		} catch (ParseException e) {
			return "erro.jsp";
		}
		
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setEdicao(edicao);
		livro.setDataPub(data);
			
				try {
			if(id == null || id.equals("0") || id.isEmpty()){
				new LivroDAO().inserir(livro);
			}else {
				livro.setId(Long.parseLong(id));
				new LivroDAO().atualisar(livro);
			}
			request.setAttribute("message", "O livro " + titulo + " foi adicionado/alterado com sucesso.");
			
		} catch (Exception e) {
			return "erro.jsp";
		}
		return "servico?function=BuscaLivro";
	}

}
