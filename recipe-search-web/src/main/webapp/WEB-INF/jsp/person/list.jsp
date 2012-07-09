<%@ include file="../common.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@ include file="../head.jspf" %>
    </head>
    <body>
        <div id="nonFooter">
            <jsp:include page="../header.jsp"/>
            <div id="content">
                <div id="content_main">
                    <h1>People</h1>
                    <table>
                        <c:forEach var="person" items="${people}">
                            <tr>
                                <td>${person.firstName}</td>
                                <td>${person.lastName}</td>
                                <td>${person.birthDate}</td>
                                <td>${person.email}</td>
                                <td>
                                    <a href="edit.form?id=${person.id}">Edit</a>
                                    <a href="delete.html?id=${person.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <c:if test="${empty people}">
                        No people in the DB
                    </c:if>
                    <a href="create.html">New</a>
                </div>
                <jsp:include page="../menu.jsp"/>
            </div>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>