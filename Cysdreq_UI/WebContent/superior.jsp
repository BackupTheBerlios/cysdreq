<logic:notPresent name="user" scope="session">
	<logic:redirect page="/logon.jsp"/>
</logic:notPresent>
<jsp:useBean id="user" scope="session" type="cysdreq_ui.bean.UserBean"/>
<TABLE width="100%">
	<TR>
		<TD align="left">
			Usted está logueado como&nbsp;
			<b><jsp:getProperty name="user" property="longUsername"/></b>
			<logic:present name="user" property="nombreProyecto" scope="session">
				&nbsp;dentro del proyecto&nbsp;
				<b><jsp:getProperty name="user" property="nombreProyecto"/></b>
			</logic:present>
		</TD>
		<TD align="right"><html:link page="/logout.do">Salir</html:link></TD>
	</TR>
</TABLE>
