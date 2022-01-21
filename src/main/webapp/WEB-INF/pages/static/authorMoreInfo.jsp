<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 class="headerClass">${subject}</h4>
<div id="more">
    <p><label>Full Name:  </label>${author.fullName}</p>
    <p><label>Day of Birth:</label>${author.dob}</p>
   <p><label>Nationality:</label>${author.nationality}</p>
    <p style="font-size: 15px; font-family: cursive;font-style: italic;color: black">

    </p>
</div>

<h2 class="header-panel">The Author books</h2>
<div class="container" id="contId">
    <div class="row" id="aa">
        <c:forEach items="${bookList}" var="nb">
            <div class="col-lg-auto">
                <div class="inner">
                        <img  class="bookId" src="${nb.picture}"/>
                    <form action="${pageContext.request.contextPath}/lab/pdf" method="GET"
                          name="formName" enctype="application/x-www-form-urlencoded">
                        <input type="text" name="url" hidden value="${nb.url}">
                        <input type="text" name="title" hidden value="${nb.title}">
                        <button class="btn-lg btn-primary" style="width: 66%;" id="startReadPageBtnId">Read</button>
                    </form>
                </div>
                <br>
                <label class="infoLabel">Title:</label><input type="text" class="infoBookItem" disabled value="${nb.title}"><br>
                <label class="infoLabel">Isbn: </label> <input type="text"  disabled class="infoBookItem" value="${nb.isbn}"><br>
                <label class="infoLabel">Writer: </label> <input type="text"  disabled class="infoBookItem"
                                                                 value="${nb.authorFullName}"><br>
                <label class="infoLabel">Subject: </label> <input type="text" disabled class="infoBookItem" value="${nb.subject}"><br>
                <label class="infoLabel">Star</label><input type="text" disabled class="infoBookItem" value="${nb.star}"><br>
                <label class="infoLabel">Publisher</label><input type="text" disabled class="infoBookItem" value="${nb.publisher}"><br>
                <label class="infoLabel">Publish Date</label><input type="text" disabled class="infoBookItem" value="${nb.publisherDate}"><br>
                <label class="infoLabel">Descrition</label><input type="text" disabled class="infoBookItem" value="${nb.description}"><br>

                <div style="height: 50px;background-color: inherit">
                </div>
            </div>
        </c:forEach>

    </div>
</div>

