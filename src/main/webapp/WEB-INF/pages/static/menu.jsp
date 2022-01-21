<%--
  Created by IntelliJ IDEA.
  User: ulviyyaIbrahimli
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="mt-2">
    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <!-- Add icons to the links using the .nav-icon class
             with font-awesome or any other icon font library -->

        <li class="nav-item">
            <a href="#" class="nav-link">
                <i class="nav-icon fas fa-book-open"></i>
                <p>
                    Browse
                    <i class="right fas fa-angle-left"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/lab/subjectList"
                       class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Subjects</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/lab/authorList" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Authors</p>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/lab/student" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>K-12 Student Library</p>
                    </a>
                </li>

            </ul>
        </li>
        <li class="nav-header">About Us</li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/lab/libraryHistory" class="nav-link" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>History</p>
            </a>
        </li>

        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/lab/addresses" class="nav-link" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>Libraries</p>
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/lab/contact" class="nav-link" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>Contact</p>
            </a>
        </li>
   </ul>
    </nav>
