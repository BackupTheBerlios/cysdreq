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
						    <html:form action="/agregarUsuario.do">
							<table height="300" border="0" valign="center" align="center" width="80%" cellpadding=10 bgcolor="#999999">
							<tr>
								<td colspan="2">Agregar Usuario</td>
							</tr>
							<tr>
								<td width="50%" align="right">Nombre:</td>
							    <td width="50%" align="left"><html:text property="nombre" size="50" maxlength="50"/></td>
							</tr>
							<tr>
							    <td width="50%" align="right">Usuario:</td>
							    <td width="50%" align="left"><html:text property="usuario" size="50" maxlength="150"/></td>
							</tr>
							<tr>
							    <td width="50%" align="right">Password:</td>
							    <td width="50%" align="left"><html:password property="password" size="50" maxlength="150"/></td>
							</tr>
							<tr>
							    <td width="50%" align="right">Seleccione uno de los siguientes roles de sistema:
							    	<html:select property="rolesSeleccionados" size="10" multiple="true">
							    		<html:optionsCollection property="roles"/>
							    	</html:select>
							    </td>
							</tr>							
							<tr>
							    <td width="50%" align="center" colspan="2"><html:submit>Agregar</html:submit></td>
							</tr>
							</table>
							</html:form>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</BODY>
</html:html>



