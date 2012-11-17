<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="buttonUrl" value="/development/painter/palette/button"/>
<c:url var="colorUrl" value="/development/painter/palette/color"/>
<c:url var="dataUrl" value="/development/painter/palette/data"/>
<c:url var="labelUrl" value="/development/painter/palette/label"/>
<c:url var="layoutUrl" value="/development/painter/palette/layout"/>
<c:url var="menuUrl" value="/development/painter/palette/menu"/>
<c:url var="notificationUrl" value="/development/painter/palette/notification"/>
<c:url var="sizeUrl" value="/development/painter/palette/size"/>

<div class="sub-menu-content" id="sub-menu-content">
    <!-- Group -->
    <div class="group">
        <h3 class="group-header">Overview</h3>  
        <div class="group-content">   

            <!-- Column -->
            <div class="column">

                <div>
                    <a class="button" href="${buttonUrl}">Button</a>
                    <a class="button" href="${colorUrl}">Color</a>
                    <a class="button" href="${dataUrl}">Data</a>
                    <a class="button" href="${labelUrl}">Label</a>
                    <a class="button" href="${layoutUrl}">Layout</a>
                    <a class="button" href="${menuUrl}">Menu</a>
                    <a class="button" href="${notificationUrl}">Notification</a>
                    <a class="button" href="${sizeUrl}">Size</a>
                </div>             

            </div><!-- Column -->  

        </div> 
    </div><!-- Group -->              
</div>