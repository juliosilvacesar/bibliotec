package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionBiblioteca.getConnection();
	}
	public boolean inserir(Emprestimo emp) {

		String sql = "insert into Emprestimo (aluno, livro, dataEmprestimo) " + "values (?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, emp.getAluno().getId());
			stmt.setLong(2, emp.getLivro().getId());
			stmt.setDate(3, new java.sql.Date(emp.getDataEmp().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Emprestimo> getLista() {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Emprestimo emp = new Emprestimo();
				
				
				Aluno aluno = new AlunoDAO().getAlunoById(rs.getLong("aluno"));
				Livro livro = new LivroDAO().getLivroById(rs.getLong("livro"));
				emp.setAluno(aluno);
				emp.setLivro(livro);

				
				
				Calendar dataEmp = Calendar.getInstance();
				dataEmp.setTime(rs.getDate("dataEmprestimo"));
				emp.setDataEmp(dataEmp);

				Calendar dataDev = null;
				dataDev = (Calendar) dataEmp.clone();
				dataDev.add(Calendar.DAY_OF_MONTH , Emprestimo.DIAS_DE_DURACAO);
				
				emp.setDataEmp(dataEmp);
				emp.setDataDev(dataDev);
				
				
				if(Calendar.getInstance().after(dataDev)) {
					emp.setStatus(false);
				}else {
					emp.setStatus(true);
				}

				
				result.add(emp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Emprestimo> getListaByAluno(Aluno aluno) {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where aluno=?");
			stmt.setLong(1, aluno.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Emprestimo emp = new Emprestimo();
				
				
				aluno = new AlunoDAO().getAlunoById(rs.getLong("aluno"));
				Livro livro = new LivroDAO().getLivroById(rs.getLong("livro"));
				emp.setAluno(aluno);
				emp.setLivro(livro);

				
				
				Calendar dataEmp = Calendar.getInstance();
				dataEmp.setTime(rs.getDate("dataEmprestimo"));
				emp.setDataEmp(dataEmp);

				Calendar dataDev = null;
				dataDev = (Calendar) dataEmp.clone();
				dataDev.add(Calendar.DAY_OF_MONTH , Emprestimo.DIAS_DE_DURACAO);
				
				emp.setDataEmp(dataEmp);
				emp.setDataDev(dataDev);
				
				
				if(Calendar.getInstance().after(dataDev)) {
					emp.setStatus(false);
				}else {
					emp.setStatus(true);
				}

				
				result.add(emp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Emprestimo> getListaByLivro(Livro livro) {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where livro=?");
			stmt.setLong(1, livro.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Emprestimo emp = new Emprestimo();
				
				
				Aluno aluno = new AlunoDAO().getAlunoById(rs.getLong("aluno"));
				livro = new LivroDAO().getLivroById(rs.getLong("livro"));
				emp.setAluno(aluno);
				emp.setLivro(livro);

				
				
				Calendar dataEmp = Calendar.getInstance();
				dataEmp.setTime(rs.getDate("dataEmprestimo"));
				emp.setDataEmp(dataEmp);

				Calendar dataDev = null;
				dataDev = (Calendar) dataEmp.clone();
				dataDev.add(Calendar.DAY_OF_MONTH , Emprestimo.DIAS_DE_DURACAO);
				
				emp.setDataEmp(dataEmp);
				emp.setDataDev(dataDev);
				
				
				if(Calendar.getInstance().after(dataDev)) {
					emp.setStatus(false);
				}else {
					emp.setStatus(true);
				}

				
				result.add(emp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean remover(Emprestimo emprestimo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
			
			stmt.setLong(1, emprestimo.getLivro().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean removerByLivro(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
			
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
