<jsp:useBean id="user" scope="session" type="cysdreq_ui.bean.UserBean"/>
							<TABLE>
								<TR>
									<TD>Usted est� Logueado como </TD>
									<TD><b><jsp:getProperty name="user" property="longUsername"/></b></TD>
								</TR>
							</TABLE>
