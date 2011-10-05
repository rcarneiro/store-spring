<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="tr" uri="http://myfaces.apache.org/trinidad"%>
<%@taglib prefix="trh" uri="http://myfaces.apache.org/trinidad/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<c:if test="${not empty pageContext.request.userPrincipal}"> 
   Bem-vindo, <strong>${pageContext.request.userPrincipal.name}</strong> &nbsp;|&nbsp; <a href="${pageContext.request.contextPath}/j_spring_security_logout">Sair</a>
</c:if>
