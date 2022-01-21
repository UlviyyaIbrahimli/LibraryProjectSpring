<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <a href="#"><h5 class="ranBookTitle">Authors</h5></a>
    <ol >
        <c:forEach items="${authorList}" var="s">
            <li value="${s.idAuthor}">
                <form action="${pageContext.request.contextPath}/lab/authorMoreInfo" method="POST"
                      name="formName" enctype="application/x-www-form-urlencoded">
                    <input    hidden  type="text"  value="${s.idAuthor}"
                              id="idAuthor" name="idAuthor">
                    <input disabled class="moreInfoClass"  style="border: none" type="text"  value=" ${s.fullName}"
                           id="fullName" name="fullName">
                         <button  class="moreInfoClass" id="searchBtnId">
                        <i class="fa fa-info-circle"></i>
                    </button>
                </form>


            </li>
        </c:forEach>
    </ol>
</div>
