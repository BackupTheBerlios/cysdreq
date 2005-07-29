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
						    <html:form action="/detallesRequerimiento.do">
								<table border="1" valign="center" align="center" width="80%" cellpadding=3 bgcolor="#999999">
									<tr>
										<td colspan="2"><b>Detalle de requerimientos<b></td>
									</tr>
									<tr>
										<td><b>Id requerimiento<b></td>
										<td><bean:write name="formDetallesRequerimiento" property="reqId"/></td>
									</tr>
									<tr>
										<td><b>Tipo de requerimiento<b></td>
										<td><bean:write name="formDetallesRequerimiento" property="nombreTipo"/></td>
									</tr>
									<tr>
										<td><b>Estado Actual<b></td>
										<td><bean:write name="formDetallesRequerimiento" property="estado"/></td>
									</tr>
									<tr>
										<td><b>Estados Anteriores<b></td>
										<td><bean:write name="formDetallesRequerimiento" property="propietario" /></td>
									</tr>
									<tr>
										<td><b>Responsable<b></td>
										<td><bean:write name="formDetallesRequerimiento" property="responsable"/></td>
									</tr>									
									<tr>
									    <td style="bgcolor:white" align="center" colspan="2"></td>
									</tr>
									<tr>
									    <td style="bgcolor:white" align="left" colspan="2"><b>Propiedades del requerimiento: </b></td>
									</tr>
									<logic:iterate name="formDetallesRequerimiento" property="propiedadesGenerales" id="foo" indexId="counter">
										<tr>
											<td><b><bean:write name="formDetallesRequerimiento" property='<%= "propiedadesGenerales[" + counter + "].label" %>'/></b></td>
											<td colspan="2"><b><bean:write name="formDetallesRequerimiento" property='<%= "propiedadesGenerales[" + counter + "].value" %>'/></b></td>
										</tr>
									</logic:iterate>
									<tr>
									    <td style="bgcolor:white" align="center" colspan="2"></td>
									</tr>
									<tr>
									    <td style="bgcolor:white" align="left" colspan="2"><b>Propiedades del estado actual: </b></td>
									</tr>
									<logic:iterate name="formDetallesRequerimiento" property="propiedadesEstado" id="foo" indexId="counter">
										<tr>
											<td><b><bean:write name="formDetallesRequerimiento" property='<%= "propiedadesEstado[" + counter + "].label" %>'/></b></td>
											<td colspan="2"><b><bean:write name="formDetallesRequerimiento" property='<%= "propiedadesEstado[" + counter + "].value" %>'/></b></td>
										</tr>
									</logic:iterate>
									<tr>
									    <td style="bgcolor:white" align="center" colspan="2">&nbsp;</td>
									</tr>
									<tr>
										<td>Cambiar a estado: 
									    	<html:select property="estadoSiguiente">
									    		<html:optionsCollection property="estadosSiguientes"/>
									    	</html:select>
										</td>
									    <td align="center">
									    	<html:submit property="action">
												Cambiar!
									    	</html:submit>
									    </td>
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


