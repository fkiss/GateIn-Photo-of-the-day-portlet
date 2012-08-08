<%-- 
    Document   : viewer_edit
    Created on : Aug 2, 2012, 5:12:25 PM
    Author     : fkiss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.*,java.util.*"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="PhotoViewer" />
<portlet:defineObjects />
<%
PortletPreferences prefs = renderRequest.getPreferences();
String size = (String) renderRequest.getAttribute("size");
if(size == null) size = prefs.getValue("size","");
%>
<portlet:actionURL var="actionURL">
</portlet:actionURL>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photo Viewer</title>
    </head>
    <body>
            <p>
                <form name="sizeform" target="_self" method="POST" action="<%=actionURL.toString()%>">
                    <p> Size: <input type="text" name="size" value="<%=size%>" maxlength="4">px </p>
                    <p><input type="submit" name="save" value="<fmt:message key="save"/>"></p>
                </form>
            </p>   
    </body>
</html>