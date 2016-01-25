<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:importAttribute name="scriptjs"/>
<tiles:importAttribute name="stylecss"/>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>

    <!-- stylesheets -->
    <c:forEach var="css" items="${stylecss}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    <!-- end stylesheets -->
</head>
<body>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>

<!-- scripts -->
<c:forEach var="script" items="${scriptjs}">
    <script data-main="${script}" src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- end scripts -->

</body>
</html>