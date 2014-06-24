<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty miembro.id}">
		<c:url value="miembros/editar" var="urlSubmit">
		</c:url>
	</c:when>
	<c:otherwise>
		<c:url value="miembros/nuevo" var="urlSubmit">
		</c:url>
	</c:otherwise>
</c:choose>
<form action="${urlSubmit}" method="POST" id="formulario">
	<h1>Registro de Miembros</h1>
	<p>
		<input type="text" value="${miembro.nombre}" name="nombre"
			placeholder="Nombre" autofocus="autofocus" required>
	</p>
	<p>
		<input type="text" value="${miembro.apePat}" name="paterno"
			placeholder="Paterno" required>
	</p>
	<p>
		<input type="text" value="${miembro.apeMat}" name="materno"
			placeholder="Materno" required>
	</p>
	<p>
		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
			type="button" value="Cancelar" onclick="upeu.cargarUrl('miembros');">
		<c:if test="${not empty alumno.id}">
			<input type="hidden" name="id" value="${miembro.id}">
		</c:if>
	</p>
</form>
<script>
	iasd.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>