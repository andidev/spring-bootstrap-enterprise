<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<jsp:include page="/WEB-INF/jsp/application/common/sub-menu-js.jsp" />

<c:url var="searchUrl" value="/price-list/search"/>
<c:url var="createUrl" value="/price-list/create"/>
<c:url var="shipmentUrl" value="/shipment/view/${shipmentId}"/>
<c:url var="invoiceUrl" value="/invoice/view/${invoiceId}"/>

<div class="sub-menu" id="sub-menu">

    <div class="top-content">

        <p>Price List</p>
        <ul class="action-menu" id="action-menu">
            <li class="menu-item search"><a href="${searchUrl}">Search</a></li>
            <li class="menu-item create"><a href="${createUrl}">Create</a></li>
        </ul>
        <br style="clear:left">

    </div>

    <div class="bottom-content">

        <p>Show</p>
        <ul class="reference-menu" id="reference-menu">
            <li class="menu-item show-invoice"><a href="${shipmentUrl}">Shipment<span class="arrow ui-icon ui-icon-arrow-1-w" /></a></li>
            <li class="menu-item show-invoice"><a href="${invoiceUrl}">Invoice<span class="arrow ui-icon ui-icon-arrow-1-w" /></a></li>
        </ul>
        <br style="clear:left">

    </div>

</div>

