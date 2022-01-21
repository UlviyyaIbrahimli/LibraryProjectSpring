<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<form action="${pageContext.request.contextPath}/lab/createNewAccountReader" method="POST"--%>
<%--      name="formName" enctype="application/x-www-form-urlencoded">--%>
<div class="form-group">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" class="form-control" placeholder="Name">
</div>
<div class="form-group">
    <label for="surname">surname</label>
    <input type="text" name="surname" id="surname" class="form-control" placeholder="Surname">
</div>
<div class="form-group">
    <label for="email">Email</label>
    <input type="email" name="email" id="email" class="form-control" placeholder="example@gmail.com">
</div>
<div class="form-group">
    <label for="username">Status</label>
    <select id="status" name="status"
            class="form-control select2" style="width: 100%;" required>
        <option value="0">Select Status</option>
        <c:forEach items="${status}" var="s">
            <option value="${s.value}">${s.name()}</option>
        </c:forEach>
    </select>
</div>
<div class="form-group">
    <label for="username">User Name</label>
    <input type="text" name="username" id="username" class="form-control" placeholder="User name">
</div>
<div class="form-group">
    <label for="name">Password</label>
    <input type="password" name="password" id="password" class="form-control">
</div>
<div class="form-group">
    <label for="confPassword">Confirm Password</label>
    <input type="password" name="confPassword" id="confPassword" class="form-control">
</div>
<%--</form>--%>