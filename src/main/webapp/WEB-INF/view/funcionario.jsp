<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funcionarios</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"/>
	</div>
	<br />
		<div align="center">
		<c:if test="${not empty salarios }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Salario</th>
						<th>Salario Dep</th>
						<th>Soma</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="salario" items="${salarios }">
						<tr>
							<td><c:out value="${soma.salario }"/></td>
							<td><c:out value="${soma.salarioDep }"/></td>
							<td><c:out value="${soma.soma }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		</div>
		<br />
		<br />
		<div align="center">
			<form action="funcionario" method="post">
				<table>
					<tr>
						<td>
						<input class="id_input_data" type="number" min="0" step="1" id="cod" name="cod" placeholder="COD">
						</td>
						<td>
							<input type="submit" id="botao" name="botao" value="Consultar">
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<input  type="submit" id="botao" name="botao" value="Listar">
						</td>
					</tr>
						
				</table>
			</form>
		</div>
		<br />
		<br />
		<div align="center">
			<c:if test="${not empty erro }">
				<H2><c:out value="${erro }" /></H2>
			</c:if>
		</div>
		<div align="center">
			<c:if test="${not empty funcionarios }">
				<table class="table_round">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Nome</th>
							<th>Salario</th>
							<th>NomeDep</th>
							<th>SalarioDep</th>
							<th>Soma</th>
						</tr>
					</thead>
					<tbody>
						 <c:forEach var="f" items="${funcionarios }">
						 	<tr>
						 		<td><c:out value="${f.codigo }"/></td>
						 		<td><c:out value="${f.nome }"/></td>
						 		<td><c:out value="${f.salario }"/></td>
						 		<td><c:out value="${f.Nome_dependente }"/></td>
						 		<td><c:out value="${f.Salario_dependente }"/></td>
						 		<td><c:out value="${f.SalarioTotal }"/></td>
						 	</tr>
						 </c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<div align="center">
			<c:if test="${not empty funcionario }">
				<table class="table_round">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Nome</th>
							<th>Salario</th>
							<th>NomeDep</th>
							<th>SalarioDep</th>
							<th>Soma</th>
						</tr>
					</thead>
					<tbody>
						 	<tr>
						 		<td><c:out value="${funcionario.codigo }"/></td>
						 		<td><c:out value="${funcionario.nome }"/></td>
						 		<td><c:out value="${funcionario.salario }"/></td>
						 		<td><c:out value="${funcionario.Nome_dependente }"/></td>
						 		<td><c:out value="${funcionario.Salario_dependente }"/></td>
						 		<td><c:out value="${funcionario.SalarioTotal }"/></td>
						 	</tr>
					</tbody>
				</table>
			</c:if>
		</div>
</body>
</html>