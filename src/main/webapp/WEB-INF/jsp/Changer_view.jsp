<%-- 
    Document   : changer_view
    Created on : Aug 2, 2012, 5:13:21 PM
    Author     : fkiss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.*,java.util.*"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="PhotoChanger" />
<portlet:defineObjects />
<%
PortletPreferences prefs = renderRequest.getPreferences();
String url=null;
%>
<portlet:actionURL var="actionURL">
</portlet:actionURL>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photo Chooser</title>
        <script type="text/javascript">
            function favWebsite()
            {
                var mylist=document.getElementById("myList");
                document.getElementById("favorite").value=mylist.options[mylist.selectedIndex].text;
            }
        </script>
    </head> 
    <body>
        <form name="urlform" target="_self" method="POST" action="<%=actionURL.toString()%>">
             Select website to display photo of the day:
            <select id="myList" onchange="favWebsite()">
                <option></option>
                <option>National Geographic</option>
                <option>ephoto</option>  
                <option>flickr</option>
                <option>xkcd</option>
                <option>naturfoto</option>
            </select>
            <p> <input type="hidden" name="url" element id="favorite" value="<%=url%>"></p>
            <p><input type="submit" name="save" value="<fmt:message key="save"/>"></p>
        </form>
    
    </body>
</html>



<%-- 
<form name="menuform">
    <select name="menu" 
    onChange="value"= this.form.menu.options[this.form.menu.selectedIndex].value;
    return false;">
    <option value="http://photography.nationalgeographic.com/photography/photo-of-the-day/" selected>National Geographic</option>
    <option value="/internet/index.html">500px</option>
    <option value="/internet/javascript/index.html">ephoto,xkcd,http://www.flickr.com/explore/,http://wvs.topleftpixel.com/</option>
    </select>
</form>
<%String url = "%> <%";%>
<%renderRequest.setAttribute("photoUrl", url);%>--%>