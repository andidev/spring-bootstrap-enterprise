<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>${title}</title>

        <jsp:include page="/WEB-INF/jsp/common/include.jsp" />
        
    </head>

    <body class="body">
        <div class="body-content"> 

            <jsp:include page="/WEB-INF/jsp/application/menu.jsp" />
            <h1 id="banner">Unauthorized</h1>
            <hr/>
            <p class="message">Access denied!</p>
        </div>
    </body>

</html>