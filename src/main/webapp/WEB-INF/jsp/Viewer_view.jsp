<%-- 
    Document   : viewer_view
    Created on : Aug 2, 2012, 4:26:25 PM
    Author     : fkiss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.*,java.util.*"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<portlet:defineObjects />
<html>
    <head>
        <title>National Geographic</title>  
    </head>
        <body>
            <center>
                <p>
                <big>
                    <b>Photo of the day</b>
                </big>
                </p>
            </center>
            <br>
            <center>
                <%
                if(renderRequest.getAttribute("info")==null){
                    %>
                    <p> You didn't choose any website.</p>
                    <%
                }
                else {
                    PortletPreferences prefs = renderRequest.getPreferences();
                    String size = prefs.getValue("size","");
                    size = (String) renderRequest.getAttribute("size");
                    String infoUrl = (String) renderRequest.getAttribute("infoUrl");
                    String info = (String) renderRequest.getAttribute("info");
                %>
                <div class="website" >
                    <a href="<%=infoUrl%>"><font size="15" color="brown"><%=info %> </a>
                </div>
            </center>
            <p align="center">
                <%String photoUrl = (String) renderRequest.getAttribute("photoUrl");%>
                <img src="<%=photoUrl%>" class="primary_photo" height="<%=size%>px"/>
            </p>
            <%
                }
            %>
        </body>
</html>