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
					<TR height="10%">
						<TD><B>Listado de Requerimientos</B></TD>
					</TR>					
					<TR height="90%">
						<TD>
						    <html:errors/>
						    <html:form action="/listadoRequerimientos.do">
								<table  border="1" valign="center" align="center" width="80%" cellpadding=3>
									<tr>
										<td>Filtro por tipo de requerimiento</td>
										<td>Filtro por propietario</td>
										<td>Filtro por estado</td>
									</tr>
									<tr>
									    <td width="50%" align="left">
								    	<html:select property="nombreTipoRequerimientoSeleccionado" size="1">
								    		<html:option value="">Todos</html:option>
								    		<html:optionsCollection property="tiposRequerimientos"/>
								    	</html:select>
									    </td>
									    <td width="50%" align="left">
								    	<html:select property="nombrePropietarioSeleccionado" size="1">
								    		<html:option value="">Todos</html:option>
								    		<html:optionsCollection property="propietarios"/>
								    	</html:select>
									    </td>
									    <td width="50%" align="left">
								    	<html:select property="nombreTipoEstadoSeleccionado" size="1">
								    		<html:option value="">Todos</html:option>
								    		<html:optionsCollection property="tiposEstados"/>
								    	</html:select>
									    </td>									    									    
									</tr>
								<tr>
								    <td width="50%" align="right" colspan="3"><html:submit>Buscar</html:submit></td>
								</tr>									
								</table>
								<br>
								<table border="1" valign="center" align="center" width="80%" cellpadding=3 bgcolor="#999999">
									<tr>
										<td colspan="3"><b>Listado de requerimientos<b></td>
									</tr>
									<tr>
										<td><b>Nombre tipo requerimiento<b></td>
										<td><b>Estado Actual<b></td>
										<td><b>Propietario<b></td>
										<td><b>Responsable<b></td>										
									</tr>									
									<logic:iterate name="formListadoRequerimientos" property="requerimientosReales" id="foo" indexId="counter">
											<tr>
												<td><bean:write name="formListadoRequerimientos" property='<%= "requerimientosReales[" + counter + "].nombreTipo" %>'/></td>
												<td><bean:write name="formListadoRequerimientos" property='<%= "requerimientosReales[" + counter + "].estado" %>'/></td>
												<td><bean:write name="formListadoRequerimientos" property='<%= "requerimientosReales[" + counter + "].propietario" %>'/></td>
												<td><bean:write name="formListadoRequerimientos" property='<%= "requerimientosReales[" + counter + "].responsable" %>'/></td>												
											</tr>
									</logic:iterate>
								</table>
								
								<html:hidden property="nombreTipo"/>
								<html:hidden property="estado"/>
								<html:hidden property="propietario"/>
								<html:hidden property="responsable"/>								
							</html:form>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</BODY>
</html:html>


