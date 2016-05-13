<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Risk evaluation report</title>
</head>
<body>
<H4>Hi ${loanJSP.client.firstName}!</H4>
Your IP adress : ${loanJSP.ipAddress} ; Attempt : ${ipAttempts}
<br/>
Loan request created on : ${loanJSP.applicationTS}
<br/>
<br/>
First name : ${loanJSP.client.firstName}
<br/>
Last name : ${loanJSP.client.lastName}
<br/>
<H4>Loan options</H4>
Amount : ${loanJSP.amount}
<br/>
Term (days) : ${loanJSP.termDays}
<H4>Status</H4>
<c:choose>
    <c:when test="${isLoanApproved == true}">
        Approved
    </c:when>
    <c:otherwise>
        Not approved
    </c:otherwise>
</c:choose>
</body>
</html>
