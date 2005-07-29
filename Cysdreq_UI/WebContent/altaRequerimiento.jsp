
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html>
<HEAD>

<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
%>


<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE></TITLE>
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
			    <html:form action="/altaRequerimiento.do">
					<table height="300" border="1" valign="center" align="center" width="80%" cellpadding=10 bgcolor="#999999">
						<tr>
							<td>Seleccione el tipo de requerimiento a dar de alta:</td>
						    <td align="center">
						    	<html:select property="nombreTipoRequerimientoSeleccionado">
						    		<html:optionsCollection property="tiposRequerimientos"/>
						    	</html:select>
						    </td>
						    <td align="center">
						    	<html:submit property="action">
									Seleccionar Tipo
						    	</html:submit>
						    </td>
						</tr>				
						<tr>
						    <td style="bgcolor:white" align="center" colspan="3"></td>
						</tr>
						<logic:iterate name="formAltaRequerimiento" property="propiedadesGenerales" id="foo" indexId="counter">
							<tr>
								<td><b><bean:write name="formAltaRequerimiento" property='<%= "propiedadesGenerales[" + counter + "].label" %>'/></b></td>
								<td colspan="2"><b><html:text size="50" name="formAltaRequerimiento" property='<%= "propiedadesGenerales[" + counter + "].value" %>'/></b></td>
							</tr>
						</logic:iterate>
						<tr>
						    <td style="bgcolor:white" align="center" colspan="3"></td>
						</tr>
						<logic:iterate name="formAltaRequerimiento" property="propiedadesEstado" id="foo" indexId="counter">
							<tr>
								<td><b><bean:write name="formAltaRequerimiento" property='<%= "propiedadesEstado[" + counter + "].label" %>'/></b></td>
								<td colspan="2"><b><html:text size="50" name="formAltaRequerimiento" property='<%= "propiedadesEstado[" + counter + "].value" %>'/></b></td>
							</tr>
						</logic:iterate>
						<tr>
						    <td align="center" colspan="3">
						    	<html:submit property="action">
									Dar de alta el requerimiento
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