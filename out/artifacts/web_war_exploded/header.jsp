<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
    <img alt="Books" src="images/cabbage-banner.jpg">
    <h1><span>Chat App</span></h1>
    <nav>
        <ul>
            <c:choose>
                <c:when test="${param.title=='Home'}">
                    <li id="actual"><a href="Controller?action=Home">Home</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="Controller?action=Home">Home</a></li>
                </c:otherwise>
            </c:choose>
            <c:if test="${user!=null}">
                <c:choose>
                    <c:when test="${param.title=='Chat'}">
                        <li id="actual"><a href="Controller?action=Chat">Chat</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="Controller?action=Chat">Chat</a></li>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </ul>
    </nav>
    <h2>
        ${param.title}
    </h2>

</header>