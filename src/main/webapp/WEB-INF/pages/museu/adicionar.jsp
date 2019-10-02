<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
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
	    	
	   <h2>Adicionar museu</h2>
	   <form action="<c:url value="/museu/add" />" method="post">
		   <div class="form-group">
		      <label for="tarefa">Nome</label>
		      <input class="form-control" type="text" name="nome" id="nome" size="200">
	     </div>
	      <div class="form-group">
		      <label for="tarefa">Endereço</label>
		      <input class="form-control" type="text" name="endereco" id="endereco" size="200">
	      </div>
	      <div class="form-group">
		      <label for="tarefa">Imagem</label>
		      <input class="form-control" type="text" name="imagem" id="imagem" size="200">
	      </div>
	      <div class="form-group">
		      <label for="tarefa">Descrição</label>
		      <input class="form-control" type="text" name="descricao" id="descricao" size="200">
	      </div>
	      
	      <hr>
	      
	      <div class="btn-group">
			<input class="btn btn-primary" type="submit" value="Salvar">
			<a class="btn btn-primary" href=<c:url value="../museu/listar" />>Voltar</a>
	      </div>
	      

	            
	   </form>
		   
	</body>
	<footer>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</footer>
</html>