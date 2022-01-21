<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Brand Logo -->
<a href="${pageContext.request.contextPath}/lab/home" class="brand-link">
    <img src="${pageContext.request.contextPath}/resources/dist/img/img.png" alt="Open Library Logo"
         class="brand-image img-circle elevation-3" style="opacity: .8">
    <span class="brand-text font-weight-light">Open Library</span>
</a>

<!-- Sidebar -->
<div class="sidebar">
    <!-- Sidebar user panel (optional) -->
    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
<%--        <div class="image">--%>
<%--            <img src="${pageContext.request.contextPath}/resources/dist/img/img_2.png.jpg"--%>
<%--                 class="img-circle elevation-2" alt="User Image">--%>
<%--        </div>--%>
<%--        <div class="info">--%>
<%--            <a href="#" class="d-block">${admUser.name} ${admUser.surname}</a>--%>
<%--        </div>--%>
    </div>

    <!-- SidebarSearch Form -->
    <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
            <input class="form-control form-control-sidebar" type="search" placeholder="Search"
                   aria-label="Search"/>
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