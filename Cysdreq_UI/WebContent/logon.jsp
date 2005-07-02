
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="htmlx"%>
<html:html>
<HEAD>

<%@ page 
language="java"

contentType="text/html; charset=ISO-8859-1"

%>


<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<TITLE>Cysdreq</TITLE>
</HEAD>

<BODY>

<P>
    <html:errors/>
	<html:form action="/logon.do">
		<TABLE border="1">
			<TBODY>
				<TR>
					<TD><bean:message key="logon.username"/></TD>
					<TD><html:text property="usuario"></html:text></TD>
				</TR>
				<TR>
					<TD>Password:</TD>
					<TD><html:password property="password"></html:password></TD>
				</TR>
			</TBODY>
		</TABLE>
		<html:submit>Submit</html:submit>
	</html:form>
</P>
</BODY>
</html:html>
