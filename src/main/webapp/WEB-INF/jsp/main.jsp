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

        <link href="/stylesheets/screen.css" media="screen, projection" rel="stylesheet" type="text/css" />
        <link href="/stylesheets/print.css" media="print" rel="stylesheet" type="text/css" />
        <!--[if IE]>
            <link href="/stylesheets/ie.css" media="screen, projection" rel="stylesheet" type="text/css" />
        <![endif]-->

        <link href="/stylesheets/compass_bootstrap.css" media="screen, projection" rel="stylesheet" type="text/css" />

    </head>

    <body>

        <!-- sticky footer
        http://stackoverflow.com/a/8825714/217657 -->
        <div id="holder">
            <header id="header">
                <div class="container">

                    <jsp:include page="/WEB-INF/jsp/main/pageheader.jsp" />

                </div>
            </header>

            <div id="page">
                <div class="container">

                    <jsp:include page="/WEB-INF/jsp/page.jsp" />

                </div>
            </div>

            <footer id="footer">
                <div class="container">

                    <jsp:include page="/WEB-INF/jsp/main/pagefooter.jsp" />

                </div>
            </footer>
        </div>         

    </body>

</html>
