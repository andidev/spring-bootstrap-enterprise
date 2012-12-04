<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<jsp:include page="/WEB-INF/jsp/application/common/sub-menu-js.jsp" />

<c:url var="overviewUrl" value="/home/overview"/>

<div class="sub-menu" id="sub-menu">

    <div class="top-content">

        <p>Home</p>
        <ul class="action-menu" id="action-menu">
            <li class="menu-item overview"><a href="${overviewUrl}">Overview</a></li>
        </ul>
        <br style="clear:left">

    </div>

    <div class="bottom-content">

        <br style="clear:left">

    </div>

</div>

