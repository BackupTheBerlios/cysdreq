<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html>
<HEAD>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE></TITLE>
<html:base/>
</HEAD>

<BODY>
	<TABLE border="1" width="100%" height="100%">
		<TR>
			<TD>
			 <%@ include file="menu.jsp" %>
			</TD>
		
			<TD width="80%">
				<TABLE border="1" width="100%" height="100%">
					<TR height="10%">
						<TD>
							<%@ include file="superior.jsp" %>
						</TD>
					</TR>
					<TR height="90%">
						<TD>
						    <html:errors/>
						    <html:form action="/listadoUsuarios.do">
								<table border="1" valign="center" align="center" width="80%" cellpadding=3 bgcolor="#999999">
									<tr>
										<td colspan="3"><b>Listado de Usuarios del sistema<b></td>
									</tr>
									<tr>
										<td><b>Nombre<b></td>
										<td><b>Login<b></td>
										<td><b>Roles de sistema asignados<b></td>
									</tr>									
									<logic:iterate name="formListadoUsuarios" property="usuariosReales" id="foo" indexId="counter">
											<tr>
												<td><bean:write name="formListadoUsuarios" property='<%= "usuariosReales[" + counter + "].nombre" %>'/></td>
												<td><bean:write name="formListadoUsuarios" property='<%= "usuariosReales[" + counter + "].login" %>'/></td>
												<td><bean:write name="formListadoUsuarios" property='<%= "usuariosReales[" + counter + "].roles" %>'/></td>
											</tr>
									</logic:iterate>
								</table>
								
								<html:hidden property="nombre"/>
								<html:hidden property="login"/>
								<html:hidden property="roles"/>
							</html:form>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</BODY>
</html:html>



