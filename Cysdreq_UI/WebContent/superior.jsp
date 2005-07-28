<jsp:useBean id="user" scope="session" type="cysdreq_ui.bean.UserBean"/>
							<TABLE>
								<TR>
									<TD>Usted está logueado como </TD>
									<TD><b><jsp:getProperty name="user" property="longUsername"/></b></TD>
									<TD> dentro del proyecto </TD>
									<TD><b><jsp:getProperty name="user" property="nombreProyecto"/></b></TD>
								</TR>
							</TABLE>
