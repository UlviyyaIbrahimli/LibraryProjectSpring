<%--
  Created by IntelliJ IDEA.
  User: ulviyyaIbrahimli
  Date: 2021-03-17
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row lightblue" >
    <div class="col-lg-3 col-6">
        <!-- small box -->
        <div class="small-box bg-blue">
            <div class="inner">
                <h3>${allBookCount}</h3>
                <p>All Books Count In Library</p>
            </div>
            <div class="icon">
                <i class="icon ion-ios-book"></i>
            </div>
            <a href="${pageContext.request.contextPath}/static/randomBookList" class="small-box-footer">Show Random Books<i
                    class="fas fa-arrow-circle-right"></i></a>
        </div>
    </div>
    <!-- ./col -->
    <div class="col-lg-3 col-6">
        <!-- small box -->
        <div class="small-box bg-gradient-gray-dark">
            <div class="inner">
                <h3>${allSubjectCount}</h3>
                <p>Book's Subjects Count</p>
            </div>
            <div class="icon">
                <i class="icon ion-ios-bookmarks"></i>
            </div>
            <a href="${pageContext.request.contextPath}/static/allSubjectList" class="small-box-footer">Subject's List<i
                    class="fas fa-arrow-circle-right"></i></a>
        </div>
    </div>
    <!-- ./col -->
    <div class="col-lg-3 col-6">
        <!-- small box -->
        <div class="small-box bg-gradient-lightblue">
            <div class="inner">
                <h3>${registrationReaderCount}</h3>
                <p>Unique Visitors Count</p>
            </div>
            <div class="icon">
                <i class="icon ion-person"></i>
            </div>
            <a href="${pageContext.request.contextPath}/static/readerMoreInfo" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
        </div>
    </div>
    <!-- ./col -->
    <div class="col-lg-3 col-6">
        <!-- small box -->
        <div class="small-box bg-gradient-gray">
            <div class="inner">
                <h3>${registrationReaderCount}</h3>
                <p>More Than Read Books</p>
            </div>
            <div class="icon">
                <i class="icon ion-ios-book-outline"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
        </div>
    </div>

</div>

</div>
