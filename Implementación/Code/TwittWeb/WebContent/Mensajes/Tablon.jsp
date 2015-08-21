<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/Utiles/Autenticacion.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Tabl&oacute;n</title>
</head>
<body>
<form action="MensajeServlet" method="post">
	<p>
		<textarea cols="100" name="mensaje" rows="2"></textarea>
	</p>
	<p style="text-align: right;">
		<input name="publicar" type="button" value="Publicar" />
	</p>
	<p>
		<textarea cols="100" name="usuario" rows="1"></textarea>
	</p>
	<p style="text-align: right;">
		<input name="buscarUsuario" type="button" value="Buscar Usuario" />
	</p>
	<c:forEach var="mensaje" items='${mensajes}'>
		<p>
			${mensaje.usuario.nombreUsuario} - <fmt:formatDate value="${mensaje.fechaPublicacion}" pattern="dd/MM/yyyy hh:mm"/>
		</p>
		<p>
			<img alt="" src="${mensaje.usuario.foto}" style="height: 50px; border-width: 0px; border-style: solid; float: left; width : 58px;" />&nbsp; ${mensaje.mensaje}
		</p>
		<p style="text-align: right;">
			<input name="republicar" type="button" value="Republicar" />
		</p>
		
	</c:forEach>
	<input name="accion" type="submit" value="Salir" />
<br>
</form>
</body>
</html>