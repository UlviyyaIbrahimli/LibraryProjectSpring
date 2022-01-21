<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #box {
        overflow-y: visible;
        overflow-x: auto;
        white-space: nowrap;
        vertical-align: text-top;
        margin: 0;
        padding: 0;
        clear: both;
        border-spacing: 5px;
    }

    .item {
        display: table-cell;
        min-width: 12px;
        width: 12px;
        font-size: 10px;
        border: 2px solid #d1d1d1;
        border-radius: 5px;
        padding: 5px;
        margin: 5px;
        white-space: normal;
        line-height: 1.6;
        vertical-align: top;
        text-align: center;
    }

    .btn-group-lg > .btn, .btn-lg {
        line-height: 1;
        width: 130px;
    }
</style>

<a href="${pageContext.request.contextPath}/lab/newBooks"><h5 class="ranBookTitle">News</h5></a>
<div id="box">
    <c:forEach items="${newBookList}" var="nb">
        <div class="item">
            <div class="col-sm-2">
                <div class="inner">
                    <img  src="${nb.picture}"/>
                </div>
                <form action="${pageContext.request.contextPath}/lab/pdf" method="GET"
                      name="formName" enctype="application/x-www-form-urlencoded">
                    <input type="text" name="url" hidden value="${nb.url}">
                    <input type="text" name="title" hidden value="${nb.title}">
                    <button class="btn-lg btn-primary" id="startReadPageBtnId">Read</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<a href="#"><h5 class="ranBookTitle">Detective </h5></a>
<div id="box">
    <c:forEach items="${detectiveBookList}" var="nb">
        <div class="item">
            <div class="col-sm-2">
                <div class="inner">
                        <img src="${nb.picture}"/>
                </div>
                <form action="${pageContext.request.contextPath}/lab/pdf" method="GET"
                      name="formName" enctype="application/x-www-form-urlencoded">
                    <input type="text" name="url" hidden value="${nb.url}">
                    <input type="text" name="title" hidden value="${nb.title}">
                    <button class="btn-lg btn-primary">Read</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<a href="#"><h5 class="ranBookTitle">Romance</h5></a>
<div id="box">
    <c:forEach items="${romanceBookList}" var="nb">
        <div class="item">
            <div class="col-sm-2">
                <div class="inner">
               <img src="${nb.picture}"/>
                </div>
                <form action="${pageContext.request.contextPath}/lab/pdf" method="GET"
                      name="formName" enctype="application/x-www-form-urlencoded">
                    <input type="text" name="url" hidden value="${nb.url}">
                    <input type="text" name="title" hidden value="${nb.title}">
                    <button class="btn-lg btn-primary" >Read</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<a href="#"><h5 class="ranBookTitle">Books We Love</h5></a>
<div id="box">
    <c:forEach items="${romanceBookList}" var="nb">
        <div class="item">
            <div class="col-sm-2">
                <div class="inner">
                        <img src="${nb.picture}"/>
                </div>
                <form action="${pageContext.request.contextPath}/lab/pdf" method="GET"
                      name="formName" enctype="application/x-www-form-urlencoded">
                    <input type="text" name="url" hidden value="${nb.url}">
                    <input type="text" name="title" hidden value="${nb.title}">
                    <button class="btn-lg btn-primary" >Read</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<a href="#"><h5 class="ranBookTitle">Kids</h5></a>
<div id="box">
    <c:forEach items="${kidsBookList}" var="nb">
        <div class="item">
            <div class="col-sm-2">
                <div class="inner">
             <img src="${nb.picture}"/>
                </div>
                <form action="${pageContext.request.contextPath}/lab/pdf" method="GET"
                      name="formName" enctype="application/x-www-form-urlencoded">
                    <input type="text" name="url" hidden value="${nb.url}">
                    <input type="text" name="title" hidden value="${nb.title}">
                    <button class="btn-lg btn-primary" >Read</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<a href="#"><h5 class="ranBookTitle">Authors Alliance & MIT Press</h5></a>
<div id="box">
    <c:forEach items="${pressBookList}" var="nb">
        <div class="item">
            <div class="col-sm-2">
                <div class="inner">
                   <img src="{nb.picture}"/>
                </div>
                <form action="${pageContext.request.contextPath}/lab/pdf" method="GET"
                      name="formName" enctype="application/x-www-form-urlencoded">
                    <input type="text" name="url" hidden value="${nb.url}">
                    <input type="text" name="title" hidden value="${nb.title}">
                    <button class="btn-lg btn-primary" >Read</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.js"></script>--%>

<script>
    // jQuery(function ($) {
    //     $.fn.hScroll = function (amount) {
    //         amount = amount || 10;
    //         $(this).bind("DOMMouseScroll mousewheel", function (event) {
    //             var oEvent = event.originalEvent,
    //                 direction = oEvent.detail ? oEvent.detail * -amount : oEvent.wheelDelta,
    //                 position = $(this).scrollLeft();
    //             position += direction > 0 ? -amount : amount;
    //             $(this).scrollLeft(position);
    //             event.preventDefault();
    //         })
    //     };
    // });

</script>







