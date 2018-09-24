<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatorios</title>
<style>
table {
	width: 100%;
	margin: 2% 0%;
}
</style>
</head>
<body>
	<table border="2">
	
		<h2>Alunos em Dias</h2>
		<tr>
			<th>Matrícula</th>
			<th>Nome</th>
		</tr>

		<c:forEach var="aluno" items="${alunosD }" >
		
		

			<tr>
				<td>${aluno.matricula}</td>
				<td>${aluno.nome}</td>

				<table border="2">
					<tr>
						<th>Livro</th>
						<th>DataEmp</th>
						<th>DataDev</th>
					</tr>
					<!-- Livro deste aluno -->
					<c:forEach var="emprestimo" items="${aluno.emprestimos }">
						<td>${emprestimo.livro.titulo }</td>
						<td><fmt:formatDate value="${emprestimo.dataEmp.time }" pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${emprestimo.dataDev.time }" pattern="dd/MM/yyyy" /></td>
					</c:forEach>
				</table>
			</tr>

		</c:forEach>
	</table>
	<table border="2">
	
		<h2>Alunos Atrasados</h2>
		<tr>
			<th>Matrícula</th>
			<th>Nome</th>
		</tr>

		<c:forEach var="aluno" items="${alunosA }" >
		
		

			<tr>
				<td>${aluno.matricula}</td>
				<td>${aluno.nome}</td>

				<table border="2">
					<tr>
						<th>Livro</th>
						<th>DataEmp</th>
						<th>DataDev</th>
					</tr>
					<!-- Livro deste aluno -->
					<c:forEach var="emprestimo" items="${aluno.emprestimos }">
						<td>${emprestimo.livro.titulo }</td>
						<td><fmt:formatDate value="${emprestimo.dataEmp.time }" pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${emprestimo.dataDev.time }" pattern="dd/MM/yyyy" /></td>
						
					</c:forEach>
				</table>
			</tr>

		</c:forEach>
	</table>

</body>
</html>