<%--
  Created by IntelliJ IDEA.
  User: ankur
  Date: 4/2/13
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="bootcamp.demo.Book" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<h3>Adding books for ${author.name}</h3>
<g:form action="saveBooks">
    <g:hiddenField name="id" value="${author.id}"/>
    <g:select name="books"
              from="${Book.list()}"
              size="5" multiple="yes" optionKey="id"
              value="${author?.books}"/>
    <g:submitButton name="save" value="Save"/>
</g:form>
</body>
</html>