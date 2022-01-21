<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ulviyyaIbrahimli
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Open Library</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/jqvmap/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote-bs4.min.css">
    <link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bookCss.css">
   <link href="${pageContext.request.contextPath}/resources/dist/css/multipleSelect/bootstrap-multiselect.css">

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <c:import url="../static/navStatic.jsp"></c:import>
    </nav>

    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-light-primary elevation-4">
        <!-- Brand Logo -->
        <a href="${pageContext.request.contextPath}/lab/home" class="brand-link">
            <img src="${pageContext.request.contextPath}/resources/dist/img/img.png" alt="library Logo"
                 class="brand-image-xl img-size-64 elevation-5" style="opacity: .8">
            <span class="brand-text font-weight-light" style="color: blue">Open Library</span>
        </a>

        <!-- SidebarSearch Form -->
        <div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
                <input class="form-control form-control-sidebar" type="search" placeholder="Search"
                       aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-sidebar">
                        <i class="fas fa-search fa-fw"></i>
                    </button>
                </div>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <c:import url="../static/menu.jsp"></c:import>
        <!-- /.sidebar-menu -->
</div>
<!-- /.sidebar -->
</aside>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <%--                    <h1 class="m-lg-1" style="text-align: center">Searching Books</h1>--%>
                </div><!-- /.col -->

            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <!-- Small boxes (Stat box) -->
            <c:import url="../static/searchBookContent2.jsp"></c:import>
            <!-- right col -->
            <div id="resultHeadId" style="height: 55px;">
                <hr style="color: lightskyblue">
<%--                <h4 class="recBooksTitle">Searching result</h4>--%>
                <hr style="color: lightskyblue">
            </div>
            <div style="height: 30px"></div>
            <div class="container" id="contId">
                <div class="row" id="aa">
                    <c:forEach items="${bookList}" var="nb">
                        <div class="col-lg-auto">
                            <div class="inner">
                                    <img  class="bookId" ${nb.picture}/>
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
                            <div style="height: 50px;background-color: inherit">
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>

        <!-- right col -->
        <%--        </div>--%>
        <!-- /.row (main row) -->
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
</aside>
<c:import url="../static/footer.jsp"></c:import>
<!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="${pageContext.request.contextPath}/resources/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="${pageContext.request.contextPath}/resources/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="${pageContext.request.contextPath}/resources/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="${pageContext.request.contextPath}/resources/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="${pageContext.request.contextPath}/resources/plugins/moment/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath}/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/resources/dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${pageContext.request.contextPath}/resources/dist/js/pages/dashboard.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bookJs.js"></script>
<script src="${pageContext.request.contextPath}/resources/dist/js/multipleSelect/bootstrap-multiselect.js"></script>

<script>
    $(document).ready(function () {
        //Date picker
        $('#publisherDateId1').datetimepicker({
            format: 'L'
        });
        // $('#subjectId1').multiselect();

    });
</script>

</body>
</html>


