<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>


<h1>Categories</h1>

<%@include file="../common/message.jspf"%>
<br/>

<c:forEach var = "cat" items="${categories}">
    <%--podswietla ostatnio dodane lub zmodyfikowane--%>
    <c:set var="style" value=""/>
    <c:if test="${cat.id eq lastModified}">
        <c:set var="style" value="color: coral"/>
    </c:if>

    <span style="${style}">(${cat.id}) <a href="/edit_categories.html?id=${cat.id}">${cat.name}</a></span> <br />
    <%--<c:choose>--%>
        <%--<c:when test="${cat.id eq lastModified}">--%>
           <%--<span style="color: coral;font-style: italic">(${cat.id})
           <a href=“<c:url value=“/edit_categories.html”>
           <c:param name=“id” value=“${cat.id}“/>
           </c:url>“>${cat.name}</a></span><br/>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--(${cat.id}) <a href="/edit_categories.html"></a> ${cat.name} <br/>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>
</c:forEach>
<br/>
<a href="new_categories.html"> dodaj nową kategorię</a>

</body>
</html>
