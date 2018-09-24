<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OPÇÕES DE ALUNO</title>

<style>
body {
	height: 100%;
	background-image:
		url("https://ae01.alicdn.com/kf/HTB1HdtMRVXXXXXZXFXXq6xXFXXXi/Papel-de-parede-3d-para-sala-de-estilo-Europeu-3D-estereosc-pico-biblioteca-fundo-da-parede.jpg");
}

button {
	width: 40%;
	margin-left: 30%;
	margin-right: 30%;
}

.area-header {
	float: left;
	width: 100%;
	background-color:;
}

.icone {
	float: left;
	width: 60px;
	height: 60px;
	margin-left: 20px;
}

.name-proj {
	float: left;
	margin-top: 15px;
	margin-left: 15px;
}

footer {
	position: absolute;
	bottom: 20px;
	margin: auto;
	display: block;
	width: 100%;
	text-align: center;
}

#formulario {
	width: 70%;
	padding: 3% 2%;
	margin: 2% 13%;
	background-color: rgba(200, 200, 200, 0.5);
	border-radius: 40px;
	padding: 1%;
	float: left;
}

input[type=text], label {
	width: 50%;
	margin: 0% 25%;
}
</style>

</head>
<body>



	<form action="servico" id="formulario">

		<h2>Adicionar aluno:</h2>

		<label>Matricula </label> <input type="text" name="cpf" maxlength="11"
			value="${aluno.cpf }" /><br /> <label>Nome: </label> <input
			type="text" name="nome" value="${aluno.nome }" /><br /> <label>Cpf
		</label> <input type="text" name="matricula" maxlength="14"
			value="${aluno.matricula }" /><br /> <label>Endereço: </label> <input
			type="text" name="endereco" value="${aluno.endereco }" /><br /> <label>Data
			de Nascimento: </label> <input type="text" name="dataNascimento"
			value='${aluno.dataNascimento.time }' /><br /> <input type="hidden"
			name="comandos" value="AdicionarAluno">
		
	<form action="servico">
			<input type="hidden" name="comandos" value="AdicionarAluno">
			<button type="submit">Adicionar Aluno</button>
		</form>
	</form>
	<br />
	<form action="servico">
		<input type="hidden" name="comandos" value="BuscaAluno">
		<button type="submit">Listar Todos</button>

	</form>
	<form action="servico">
		<input type="hidden" name="comandos" value="GerarRelatorios">
		<button type="submit">Relatorios</button>

	</form>


</body>
</html>