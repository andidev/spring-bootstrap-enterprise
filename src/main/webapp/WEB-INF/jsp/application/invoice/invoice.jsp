<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<div class="menu-content" id="menu-content"> 

    <jsp:include page="/WEB-INF/jsp/application/${menu}/sub-menu.jsp" />
    <jsp:include page="/WEB-INF/jsp/application/${menu}/${subMenu}/${subMenu}.jsp" />

</div>
