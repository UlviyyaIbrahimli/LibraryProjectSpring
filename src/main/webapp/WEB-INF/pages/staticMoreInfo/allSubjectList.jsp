<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ulviyyaIbrahimli

  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.css">
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

    <!-- DataTables -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">

    <%----%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/warning.css">
    <%--    jquery css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/jquery/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/sweetCss/sweetalert2.min.css">
    <%--    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">--%>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <c:import url="../static/navStatic.jsp"></c:import>

    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <c:import url="../static/asideStatic.jsp"></c:import>

    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <c:import url="../static/contentHeaderStatic.jsp"></c:import>

    </div>
    <!-- /.content-header -->
    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <!-- Small boxes (Stat box) -->
            <c:import url="../static/statistics.jsp"></c:import>

            <table id="allSubjectList" class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>Subject</th>
                    <th>Description</th>
                    <th>Subject's Book</th>
                </thead>
                <tbody>
                <c:forEach items="${subjectList}" var="sl">
                    <tr>
                        <td>${sl.subject}</td>
                        <td>${sl.description}</td>
                        <td><a href="javascript:showSubjectBook(${sl.id_subject})">Books</a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>

                </tfoot>
            </table>
        </div>

        <%-- </form:form>--%>

        <!-- right col -->
</div>
<!-- /.row (main row) -->
<!-- /.container-fluid -->
</section>
</div>
<%--edit Dialog Div--%>
<div id="merchantListDivId">

    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%--<footer class="main-footer">
    All rights reserved.
</footer>--%>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
</aside>
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

<%--////////////--%>
<script src="${pageContext.request.contextPath}/resources/dist/js/sweetJs/sweetalert2@8.js"></script>


<%-- Jquery UI js--%>
<script src="${pageContext.request.contextPath}/resources/dist/js/jquery/jquery-ui.js"></script>
<!-- DataTables  & Plugins -->
<script src="${pageContext.request.contextPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/jszip/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/pdfmake/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/pdfmake/vfs_fonts.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
<script type="text/javascript">
    $(function () {
        $("#allSubjectList").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
        }).buttons().container()

        //Date picker
        $('#beginDateId').datetimepicker({
            format: 'L'
        });

        $('#endDateId').datetimepicker({
            format: 'L'
        });


    });
</script>
</body>
</html>
