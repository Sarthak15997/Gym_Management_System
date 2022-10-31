<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if ((session.getAttribute("memberDetails") == null) || (session.getAttribute("memberDetails") == "")) {
%>
 <c:redirect url="../"></c:redirect>
<%}else{%>

<%@include file="../member_include/member_template.jsp" %>
<%@include file="../member_include/trainerDetails.jsp" %>
<%@include file="../member_include/member_footer.jsp" %>
<%@include file="../member_include/member_logout_alert.jsp" %>
<%}%>