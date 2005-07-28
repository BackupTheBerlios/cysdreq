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
						    <html:form action="/guardarTipoRequerimiento.do">
								<table border="1" valign="center" align="center" width="80%" cellpadding=3 bgcolor="#999999">
									<tr>
										<td colspan="5"><b>Agregar Tipo de Requerimiento<b></td>
									</tr>
									<tr>
										<td width="25%" align="right">Nombre:</td>
									    <td width="25%" align="left"><html:text property="nombre" size="50" maxlength="50"/></td>
										<td colspan="3" width="50%">&nbsp;</td>
									</tr>
									<tr>
									    <td width="25%" align="right">Propiedades:</td>
									    <td width="25%" align="left"><html:text property="propiedad" size="50" maxlength="50"/></td>
									    <td width="25%" align="center" colspan="2">
									    	<html:submit property="action" value="Agregar Propiedad"/><br><br>
									    	<html:submit property="action" value="Quitar Propiedad"/>
									    </td>
									    <td width="25%" align="left">
									    	<html:select property="propiedadSeleccionada" size="6">
									    		<html:optionsCollection property="propiedades"/>
									    	</html:select>
									    </td>
									</tr>

									<tr>
									    <td width="25%" align="right">Estados:</td>
									    <td width="25%" align="left"><html:text property="estado" size="50" maxlength="50"/></td>
									    <td width="25%" align="center" colspan="2">
									    	<html:submit property="action" value="Agregar Estado"/><br><br>
									    	<html:submit property="action" value="Quitar Estado"/>
									    </td>
									    <td width="25%" align="left">
									    	<html:select property="estadoSeleccionado" size="6">
									    		<html:optionsCollection property="estados"/>
									    	</html:select>
									    </td>
									</tr>

									<tr>
										<td colspan="5"><html:submit property="action" value="Guardar Tipo de Requerimiento"/></td>
									</tr>
								</table>
								<br>
								<logic:iterate name="formTipoRequerimiento" property="estadosReales" id="foo" indexId="counter">
									<table border="1" valign="center" align="center" width="80%" cellpadding=3 bgcolor="#999999">
										<tr>
											<td colspan="5">Estado <b><bean:write name="formTipoRequerimiento" property='<%= "estadosReales[" + counter + "].value" %>'/></b></td>
										</tr>
										<tr>
										    <td width="25%" align="right">Propiedades:</td>
										    <td width="25%" align="left">
										    	<html:text property='<%= "propiedadEstados[" + counter + "]" %>' size="50" maxlength="50"/>
										    </td>
										    <td width="25%" align="center" colspan="2">
										    	<html:submit property="action">
													Agregar Propiedad (<bean:write name="formTipoRequerimiento" property='<%= "estadosReales[" + counter + "].value" %>'/>)
										    	</html:submit><br><br>
										    	<html:submit property="action">
													Quitar Propiedad (<bean:write name="formTipoRequerimiento" property='<%= "estadosReales[" + counter + "].value" %>'/>)
										    	</html:submit><br><br>
										    </td>
										    <td width="25%" align="left">
										    	<html:select property='<%= "propiedadSeleccionadaEstados[" + counter + "]" %>' size="4">
										    		<html:optionsCollection property='<%= "propiedadesEstados[" + counter + "]" %>'/>
										    	</html:select>
										    </td>
										</tr>
										<tr>
										    <td width="25%" align="right">Estados siguientes:</td>
										    <td width="25%" align="left">
										    	<html:select property='<%= "estadoSiguienteSeleccionadoIzq[" + counter + "]" %>' size="6">
										    		<html:optionsCollection property="estados"/>
										    	</html:select>
										    </td>
										    <td width="25%" align="center" colspan="2">
										    	<html:submit property="action">
													Agregar Estado (<bean:write name="formTipoRequerimiento" property='<%= "estadosReales[" + counter + "].value" %>'/>)
										    	</html:submit><br><br>
										    	<html:submit property="action">
													Quitar Estado (<bean:write name="formTipoRequerimiento" property='<%= "estadosReales[" + counter + "].value" %>'/>)
										    	</html:submit><br><br>
										    </td>
										    <td width="25%" align="left">
										    	<html:select property='<%= "estadoSiguienteSeleccionadoDer[" + counter + "]" %>' size="6">
										    		<html:optionsCollection property='<%= "estadosSiguientes[" + counter + "]" %>'/>
										    	</html:select>
										    </td>
										</tr>
									</table>
									<html:hidden property='<%= "propiedadesIngresadasEstados[" + counter + "]" %>'/>
									<html:hidden property='<%= "estadosSiguientesIngresados[" + counter + "]" %>'/>
									<br>
								</logic:iterate>

								<html:hidden property="estadosIngresados"/>
								<html:hidden property="propiedadesIngresadas"/>
								<html:hidden property="modificacion"/>
								<html:hidden property="nombreTipoModificado"/>
							</html:form>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</BODY>
</html:html>



