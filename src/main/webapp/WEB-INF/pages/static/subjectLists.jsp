<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<a href="#"><h5 class="ranBookTitle">Subjects</h5></a>
    <ol >
    <c:forEach items="${subject}" var="s">
        <li value="${s.idSubject}">
            <form action="${pageContext.request.contextPath}/lab/subjectMoreInfo" method="POST"
               name="formName" enctype="application/x-www-form-urlencoded">
            <input    hidden  type="text"  value="${s.idSubject}"
                   id="idSubject" name="idSubject">
                <input disabled class="moreInfoClass"  style="border: none" type="text"  value=" ${s.subject}"
                        id="subject" name="subject">
            <button  class="moreInfoClass" id="searchBtnId">
                <i class="fa fa-info-circle"></i>
            </button>
        </form>


        </li>
    </c:forEach>
    </ol>
</div>
