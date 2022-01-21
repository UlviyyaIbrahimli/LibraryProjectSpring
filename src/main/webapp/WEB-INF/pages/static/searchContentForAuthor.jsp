


<div style="width:  100%;">
    <form action="${pageContext.request.contextPath}/lab/searchAuthor" method="POST"
          name="formName" enctype="application/x-www-form-urlencoded">
        <div class="row no-gutters">
            <div class="col">
                <input class="form-control border-secondary border-right-0 rounded-0" type="search"  value="${searchTxt}"
                    placeholder="Search Author"   id="searchTxt" name="searchTxt">
            </div>
            <div class="col-auto">
                <button  class="btn btn-outline-secondary border-left-0 rounded-0 rounded-right" id="searchBtnIdForSubject">
                    <i class="fa fa-search"></i>
                </button>
            </div>

        </div>
    </form>
</div>