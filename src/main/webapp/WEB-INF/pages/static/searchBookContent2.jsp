<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="height: 55px"></div>
<div class="card-body bg-info">
    <h3 class="recBooksTitle"> Advance Search Book</h3>
    <div class="row">
        <div class="form-group col-md-3">
            <label>Title</label>
            <input type="text" placeholder="Title" id="titleId1" name="title1"
                   class="form-control"/>
        </div>
        <div class="form-group col-md-3">
            <label>ISBN</label>
            <input type="text" placeholder="ISBN" id="isbnId1" name="isbn1"
                   class="form-control"/>
        </div>
        <div class="form-group col-md-3">
            <label>Subject</label>
            <input type="text" placeholder="Subject" id="subjectId1" name="subject1"
                   class="form-control"/>
        </div>
        <div class="form-group col-md-3">
            <label>Author</label>
            <input type="text" placeholder="Author" id="authorId1" name="author1"
                   class="form-control"/>
        </div>
        <div class="form-group col-md-3">
            <label>Publisher</label>
            <input type="text" placeholder="Publisher" id="publisherId1" name="publisher1"
                   class="form-control"/>
        </div>

        <div class="form-group col-md-3">
            <label>Publisher Date:</label>
            <div class="input-group date" data-target-input="nearest">
                <input type="text" id="publisherDateId1" placeholder="Publisher Date"
                       class="form-control datetimepicker-input" data-target="#publisherDateId1"
                       data-toggle="datetimepicker"/>
                <div class="input-group-append" data-target="#publisherDateId1"
                     data-toggle="datetimepicker">
                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                </div>
            </div>
        </div>
<%--        <div class="form-group col-md-3">--%>
<%--            <label>Subjects</label>--%>
<%--            <br>--%>
<%--            <td><select id="subjectId1" name="subject1"--%>
<%--                        multiple="multiple"--%>
<%--                        class="form-control select2"  style="width: 100%;">--%>
<%--                &lt;%&ndash;                <option value="0">All Subjects</option>&ndash;%&gt;--%>
<%--                <c:forEach items="${subject}" var="s">--%>
<%--                    <option value="${s.idSubject}">${s.subject}</option>--%>
<%--                </c:forEach>--%>
<%--            </select></td>--%>
<%--        </div>--%>

        <div class="form-group col-md-3">
            <label style="visibility:hidden">Btn</label>
            <button class=" btn-primary col-md-6 form-control" id="advSearchBtnId2">Search
            </button>

        </div>
    </div>
</div>
