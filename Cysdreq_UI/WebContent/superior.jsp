<jsp:useBean id="user" scope="session" type="cysdreq_ui.bean.UserBean"/>
							<TABLE>
								<TR>
									<TD>Usted está Logueado como </TD>
									<TD><b><jsp:getProperty name="user" property="longUsername"/></b></TD>
									<logic:notEmpty name="user" property="nombreProyecto">
										<TD> dentro del proyecto </TD>
										<TD><b><jsp:getProperty name="user" property="nombreProyecto"/></b></TD>
									</logic:notEmpty>	
								</TR>
							</TABLE>
