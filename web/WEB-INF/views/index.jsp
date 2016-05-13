<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Loan Service Page</title>
</head>

<body>
<spring:form method="post" modelAttribute="loanJSP" action="approve-loan">
    First name: <spring:input path="client.firstName"/> <br/>
    Last name: <spring:input path="client.lastName"/> <br/><br/>
    Amount: <spring:input path="amount"/> <br/>
    Term: <spring:input path="termDays"/> <br/>
    <spring:button>Approve loan</spring:button>
</spring:form>
</body>

</html>