<!-- Left navbar links -->
<ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
    </li>
    <li class="nav-item d-none d-sm-inline-block">
        <a href="${pageContext.request.contextPath}/lab/home" class="nav-link">Home</a>
    </li>
    <li class="nav-item d-none d-sm-inline-block">
        <a href="${pageContext.request.contextPath}/lab/contact" class="nav-link">Contact</a>
    </li>
</ul>

<ul class="navbar-nav ml-auto">
    <!-- Messages Dropdown Menu -->
    <!-- Notifications Dropdown Menu -->
    <div id="userRegId">
         <input  disabled style="border:none" type="text" id="id" value="${username}">
    </div>


    <li class="nav-item">
        <div class="pull-right">
                <button type="button" class="btn btn-default btn-flat" id="signInBtn">Sign In</button>
        </div>
    </li>
    <li class="nav-item">
        <div class="pull-right">
            <form action="${pageContext.request.contextPath}/lab/signUp" method="post">
                <button type="submit" class="btn btn-default btn-flat">Sign Up</button>
            </form>
        </div>
    </li>
</ul>
