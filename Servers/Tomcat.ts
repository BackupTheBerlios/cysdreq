<?xml version="1.0" encoding="UTF-8"?>
<tomcat-server debug="false" debug-port="-1" name="Tomcat"
   secure="false" version="21">
   <install-dir path="D:/Apache Tomcat 4.0"/>
   <jre path="C:/j2sdk1.4.2_04"/>
   <configuration-ref ref="/Servers/Tomcat.tsc"/>
   <path type="0" value=""/>
   <classpath>
      <classpath-entry kind="lib" path="D:/Apache Tomcat 4.0/bin/bootstrap.jar"/>
      <classpath-entry kind="lib" path="C:/j2sdk1.4.2_04/lib/tools.jar"/>
      <classpath-entry kind="prj" path="/Cysdreq"/>
   </classpath>
   <system-properties/>
   <vm-arguments/>
</tomcat-server>
