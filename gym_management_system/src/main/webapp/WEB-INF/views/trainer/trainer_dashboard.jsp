<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if ((session.getAttribute("trainerDetails") == null) || (session.getAttribute("trainerDetails") == "")) {
%>
 <c:redirect url="../"></c:redirect>
<%}else{%>

<%@include file="../trainer_include/trainer_template.jsp" %>
<%@include file="../trainer_include/trainer_cards.jsp" %>
<%@include file="../trainer_include/trainer_footer.jsp" %>
<%@include file="../trainer_include/trainer_logout_alert.jsp" %>
<%}%>