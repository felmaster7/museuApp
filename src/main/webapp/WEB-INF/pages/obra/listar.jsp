<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />" >
		 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<title>MuseuApp</title>
	</head>
	<body>
	
  		<div class="container shadow" >
		
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3 row">
				<a class="btn btn-primary col-sm-2" href="<c:url value="/obra/adcionar" />"  >Cadastrar nova obra</a>
				<div class="col-sm-9" style="text-align:center"><h2 style="color:white">MuseuApp</h2></div>
				<a class="btn btn-primary col-sm-1" href="<c:url value="../../museuApp" />"  >Retornar</a>
			</nav> 
			
			<table class="table table-striped" >
				<thead class="thead-dark">
					<tr>
						<th>Nome da obra</th>
						<th>Tipo</th>
						<th>Nome do autor</th>
						<th>Descrição</th>
						<th>Imagem</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="obra" items="${listaObras}" >
						<tr>
						  <td>${obra.nome}</td>
						  <td>${obra.tipo}</td>
						  <td>${obra.autor}</td>
						  <td>${obra.descricao}</td>
						  <td> <img src="${obra.imagem}" height="42" width="42"></td>
						  <td class='btn-group'>
				  				<a class="btn btn-primary" href="<c:url value="/obra/editar/${obra.id}" />" >Editar</a>
					  			<a class="btn btn-danger" href="<c:url value="/obra/deletar/${obra.id}" />" >Remover</a>
						  </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
		</div>
	</body>
	<footer>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</footer>
</html>