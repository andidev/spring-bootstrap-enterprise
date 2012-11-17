<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<c:url var="homeUrl" value="/home"/>
<c:url var="shipmentUrl" value="/shipment"/>
<c:url var="invoiceUrl" value="/invoice"/>
<c:url var="priceListUrl" value="/price-list"/>
<c:url var="developmentUrl" value="/development"/>
<c:url var="currentUserSettingsUrl" value="/settings/user"/>
<c:url var="systemSettingsUrl" value="/settings/system"/>
<c:url var="companySettingsUrl" value="/settings/company"/>
<c:url var="userSettingsUrl" value="/settings/user"/>
<c:url var="logoutUrl" value="/logout"/>

<!-- menu specific javascript -->
<script type="text/javascript">

    $(function() {
        $('#menu .menu-item.${menu}').addClass("selected")
    });

</script>

<!-- navigation bar TODO: chenge name to navigation bar form menu bar?
see http://woorkup.com/2010/08/09/best-practices-to-design-a-perfect-html-navigation-bar/ -->
<div class="menu" id="menu">

    <div class="left-content">

        <ul class="domain-menu" id="domain-menu">
            <li class="menu-item home">
                <a href="${homeUrl}">Home</a>
            </li>
            <li class="menu-item shipment">
                <a href="${shipmentUrl}">Shipments</a>
            </li>
            <li class="menu-item invoice">
                <a href="${invoiceUrl}">Invoices</a>
            </li>
            <li class="menu-item price-list">
                <a href="${priceListUrl}">Price Lists</a>
            </li>
        </ul>

    </div>


    <div class="right-content">

        <ul class="system-menu" id="system-menu">
<%-- 
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="menu-item development">
                    <a href="${developmentUrl}">Development</a>
                </li>
            </sec:authorize>
--%>                
            <li class="menu-item admin">
                <a href="${currentUserSettingsUrl}" class="settings">Settings</a>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <ul class="hover-menu">
                        <li class="menu-item system">
                            <a href="${systemSettingsUrl}">System</a>
                        </li>
                        <li class="menu-item company">
                            <a href="${companySettingsUrl}">Company</a>
                        </li>
                        <li class="menu-item user">
                            <a href="${userSettingsUrl}">User</a>
                        </li>
                    </ul>
                </sec:authorize>

            </li>
            <li class="menu-item logout">
                <a href="${logoutUrl}">Logout ${username}</a>
            </li>
        </ul>

    </div>

    <br style="clear:left"/>

</div>