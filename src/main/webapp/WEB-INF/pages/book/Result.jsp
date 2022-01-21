
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="boxx">
    <c:forEach items="${bookList}" var="nb">
        <div class="item">
            <div class="col-sm-2">
                <div class="inner">
                    <a href="${pageContext.request.contextPath}/book/pdf1"><img src="${pageContext.request.contextPath}/resources/dist/img/img.png"/></a>
                </div>
                <button class="btn-lg btn-primary">Read
                </button>
            </div>
        </div>
    </c:forEach>
</div>