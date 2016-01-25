<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
    <nav>
        <div class="container-fluid">
            <p class="navbar-text pull-right">
                <sec:authentication var="user" property="principal"/>
                You are logged in as: <strong>
                <sec:authorize access="isAuthenticated()">
                    <%--<strong>${user.getFullName()}</strong>--%>
                    <a href="${pageContext.servletContext.contextPath}/logout" class="btn btn-default btn-sm" role="button">Logout</a>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <strong>Guest</strong>
                </sec:authorize>
            </strong>
            </p>
        </div>
    </nav>
</header>
