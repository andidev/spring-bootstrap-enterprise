<section class="website-info">
    
    <img class="logo" src="src" />
    <hgroup>
        <h1 class="name"><a href="/">Website Name</a></h1>
        <h2 class="description">Website description...</h2>
    </hgroup>
    <address class="address">
        Address Row 1
        Address Row 2
        Address Row 3
    </address>

</section>                   

<div class="main-nav">

    <jsp:include page="/WEB-INF/jsp/application/navmenu.jsp" />
    <jsp:include page="/WEB-INF/jsp/application/middlemenu.jsp" />
    <jsp:include page="/WEB-INF/jsp/application/systemmenu.jsp" />
    <div class="main-search">
        <input name="mainSearch" type="search" placeholder="Search. Press 's'" data-hotkey="s" spellcheck="false" autocomplete="off">
        <ol class="result"></ol>
    </div>

</div>