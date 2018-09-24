<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	height: 100%;
	background-image:
		url("https://ae01.alicdn.com/kf/HTB1HdtMRVXXXXXZXFXXq6xXFXXXi/Papel-de-parede-3d-para-sala-de-estilo-Europeu-3D-estereosc-pico-biblioteca-fundo-da-parede.jpg");
}

#busca input[type=text] {
	width: 130px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-image: url('searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
}

#busca input[type=text]:focus {
	width: 50%;
}

#formulario {
	width: 70%;
	padding: 2%;
	margin: 2% 13%;
	background-color: rgba(200,200,200,0.5);
	border-radius: 40px ;
	padding: 1%;
	float:left;
	
}
input[type=text], label{
	width: 50%;
	margin: 0% 25%;
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
</style>
</head>
<body>
	
	
	
	<div id="formulario">
	
		<h2>Cadastrar Livro: </h2>

		<form action="servico">
		
			<label>Titulo: </label> <input type="text" name="titulo" value="${livro.titulo }"/><br/>
			<label>Autor: </label> <input type="text" name="autor" value="${livro.autor }"/><br/>
			<label>Edi��o: </label> <input type="text" name="edicao" value="${livro.edicao }"/><br/>
			<label>Editora: </label> <input type="text" name="editora" value="${livro.editora }"/><br/>
			<label>Ano de Publica��o: </label> <input type="text" name="publicacao" maxlength="10" value="<fmt:formatDate value="${livro.dataPub.time }" pattern='yyyy'"/><br/>
			<input type="hidden" name="comandos" value="AdicionarLivro">
			<c:choose>
				<c:when test="${not empty livro}">
				<input type="hidden" name="id" value="${livro.id }">
				</c:when>
			</c:choose>
			<button type="submit">Adicionar Livro</button>
	</form>
	</div>
	
	<div id="busca">
		<h2>Busca de Livros:</h2>
		<form action="servico">
			<input type="text" name="titulo" placeholder="T�tulo...">
			<input type = "hidden" value="BuscaLivro">
			<br><br><br>
			<button type="enviar">Pesquisar</button>
		</form>
		<br><br>
		
		<form action="servico">
    		<input type = "hidden" name="comandos" value="BuscaLivro">
    		<button type="submit" >Listar Todos</button>
		</form>
		
		<br>
	</div>
	
	
	

</body>
</html>