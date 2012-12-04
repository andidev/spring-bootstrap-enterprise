<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<jsp:include page="/WEB-INF/jsp/application/common/sub-menu-js.jsp" />

<c:url var="searchUrl" value="/shipment/search"/>
<c:url var="createUrl" value="/shipment/create"/>
<c:url var="invoiceUrl" value="/invoice/view/${invoiceId}"/>
<c:url var="priceListUrl" value="/price-list/view/${priceListId}"/>

<div class="sub-menu" id="sub-menu">

    <div class="top-content">

        <p>Shipment</p>
        <ul class="action-menu" id="action-menu">
            <li class="menu-item menu-item search">
                <a href="${searchUrl}">Search</a>
            </li>
            <li class="menu-item menu-item create">
                <a href="${createUrl}">Create</a>
            </li>
        </ul>
        <br style="clear:left">

    </div>

    <div class="bottom-content">

        <p>Show</p>
        <ul class="reference-menu" id="reference-menu">
            <li class="menu-item menu-item invoice">
                <a href="${invoiceUrl}">Invoice<span class="arrow ui-icon ui-icon-arrow-1-w" /></a>
            </li>
            <li class="menu-item menu-item price-list">
                <a href="${priceListUrl}">Price List<span class="arrow ui-icon ui-icon-arrow-1-w" /></a>
                
            </li>
        </ul>
        <br style="clear:left">

    </div>

</div>

