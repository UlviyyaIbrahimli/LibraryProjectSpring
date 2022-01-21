


<div style="display: inline-flex;vertical-align: middle;margin-left: 68%;">
<%--    <div class="dropdown">--%>
        <a href="${pageContext.request.contextPath}/lab/advSearchForParamsIndex"> <button class="btn btn-primary" type="button"  id="advSearchBtnId">Advanced
            <span class="caret"></span></button></a>
<%--        <ul class="dropdown-menu">--%>
<%--             <li><a  class="dropdown-item" href="#">Subject</a></li>--%>
<%--            <li><a class="dropdown-item" href="#">Author</a></li>--%>
<%--            <li><a class="dropdown-item" href="#">Text</a></li>--%>
<%--            <li><a class="dropdown-item" href="#">Advanced</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>

    <form action="${pageContext.request.contextPath}/lab/advSearchBooksAllParams" method="POST"
          name="formName" enctype="application/x-www-form-urlencoded">
    <div class="row no-gutters">
        <div class="col">
            <input class="form-control border-secondary border-right-0 rounded-0" type="search"  placeholder="Search Book"
                   id="searchTxt" name="searchTxt">
        </div>
        <div class="col-auto">
             <button  class="btn btn-outline-secondary border-left-0 rounded-0 rounded-right" id="searchBtnId">
                <i class="fa fa-search"></i>
        </button>
        </div>

    </div>
</div>
</form>