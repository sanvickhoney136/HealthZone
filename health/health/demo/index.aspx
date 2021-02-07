<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="index.aspx.cs" Inherits="HealthZonemr.demo.index" %>

<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Health Zone</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="../assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="../assets/vendors/jvectormap/jquery-jvectormap.css">
    <!-- End plugin css for this page -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../assets/css/demo/style.css">
    <!-- End layout styles -->

    <link rel="shortcut icon" href="../assets/images/favicon.png" />
</head>
<body>
    <script src="../assets/js/preloader.js"></script>
    <div class="body-wrapper">
        <!-- partial:partials/_sidebar.html -->
        <aside class="mdc-drawer mdc-drawer--dismissible mdc-drawer--open">
            <div class="mdc-drawer__header">
                <a href="/index.aspx" class="brand-logo">
                    <img src="../assets/images/logo.png" style="height: 85px; width: 166px;" alt="logo">
                </a>
            </div>
            <div class="mdc-drawer__content">

                <div class="mdc-list-group">
                    <nav class="mdc-list mdc-drawer-menu">
                        <div class="mdc-list-item mdc-drawer-item">
                            <a class="mdc-drawer-link" href="index.aspx">
                                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">home</i>
                                Dashboard
              </a>
                        </div>


                        <div class="mdc-list-item mdc-drawer-item">
                            <a class="mdc-drawer-link" href="pages/samples/OverEmployee.aspx">
                                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">grid_on</i>
                                Overall Employees
              </a>
                        </div>
                        <div class="mdc-list-item mdc-drawer-item">
                            <a class="mdc-drawer-link" href="pages/samples/Chat.aspx">
                                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">pie_chart_outlined</i>
                                Chatboard
              </a>
                        </div>

                    </nav>

                </div>
                <div class="profile-actions">

                    <a href="pages/samples/login.aspx">Logout</a>
                </div>

            </div>
        </aside>
        <!-- partial -->
        <div class="main-wrapper mdc-drawer-app-content">
            <!-- partial:partials/_navbar.html -->
            <header class="mdc-top-app-bar">
                <div class="mdc-top-app-bar__row">
                    <div class="mdc-top-app-bar__section mdc-top-app-bar__section--align-start">
                        <button class="material-icons mdc-top-app-bar__navigation-icon mdc-icon-button sidebar-toggler">menu</button>
                        <span class="mdc-top-app-bar__title">Health Zone!</span>
                        <div class="mdc-text-field mdc-text-field--outlined mdc-text-field--with-leading-icon search-text-field d-none d-md-flex">
                            <i class="material-icons mdc-text-field__icon">search</i>
                            <input class="mdc-text-field__input" id="text-field-hero-input">
                            <div class="mdc-notched-outline">
                                <div class="mdc-notched-outline__leading"></div>
                                <div class="mdc-notched-outline__notch">
                                    <label for="text-field-hero-input" class="mdc-floating-label">Search..</label>
                                </div>
                                <div class="mdc-notched-outline__trailing"></div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-top-app-bar__section mdc-top-app-bar__section--align-end mdc-top-app-bar__section-right">
                        <div class="menu-button-container menu-profile d-none d-md-block">

                            <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">

                                    <li class="mdc-list-item" role="menuitem">

                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">Logout</h6>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="divider d-none d-md-block"></div>
                        <div class="menu-button-container d-none d-md-block">

                            <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon-only">
                                            <i class="mdi mdi-alert-circle-outline text-primary"></i>
                                        </div>

                                    </li>
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon-only">
                                            <i class="mdi mdi-progress-download text-primary"></i>
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">Update</h6>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>






                        <div class="menu-button-container">

                            <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                                <h6 class="title"><i class="mdi mdi-bell-outline mr-2 tx-16"></i>Notifications</h6>
                                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon">
                                            <i class="mdi mdi-email-outline"></i>
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">You received a new message</h6>
                                            <small class="text-muted">6 min ago </small>
                                        </div>
                                    </li>
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon">
                                            <i class="mdi mdi-account-outline"></i>
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">New user registered</h6>
                                            <small class="text-muted">15 min ago </small>
                                        </div>
                                    </li>
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon">
                                            <i class="mdi mdi-alert-circle-outline"></i>
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">System Alert</h6>
                                            <small class="text-muted">2 days ago </small>
                                        </div>
                                    </li>
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon">
                                            <i class="mdi mdi-update"></i>
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">You have a new update</h6>
                                            <small class="text-muted">3 days ago </small>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="menu-button-container">

                            <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                                <h6 class="title"><i class="mdi mdi-email-outline mr-2 tx-16"></i>Messages</h6>
                                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail">
                                            <img src="../assets/images/faces/face4.jpg" alt="user">
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">Mark send you a message</h6>
                                            <small class="text-muted">1 Minutes ago </small>
                                        </div>
                                    </li>
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail">
                                            <img src="../assets/images/faces/face2.jpg" alt="user">
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">Cregh send you a message</h6>
                                            <small class="text-muted">15 Minutes ago </small>
                                        </div>
                                    </li>
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail">
                                            <img src="../assets/images/faces/face3.jpg" alt="user">
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">Profile picture updated</h6>
                                            <small class="text-muted">18 Minutes ago </small>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="menu-button-container d-none d-md-block">
                            <button class="mdc-button mdc-menu-button">
                                <i class="mdi mdi-arrow-down-bold-box"></i>
                            </button>
                            <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon-only">
                                            <i class="mdi mdi-lock-outline text-primary"></i>
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">Lock screen</h6>
                                        </div>
                                    </li>
                                    <li class="mdc-list-item" role="menuitem">
                                        <div class="item-thumbnail item-thumbnail-icon-only">
                                            <i class="mdi mdi-logout-variant text-primary"></i>
                                        </div>
                                        <div class="item-content d-flex align-items-start flex-column justify-content-center">
                                            <h6 class="item-subject font-weight-normal">Logout</h6>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- partial -->
            <div class="page-wrapper mdc-toolbar-fixed-adjust">
                <main class="content-wrapper">
                    <div class="mdc-layout-grid">
                        <div class="mdc-layout-grid__inner">
                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-3-desktop mdc-layout-grid__cell--span-4-tablet">
                                <div class="mdc-card info-card info-card--success">
                                    <div class="card-inner">
                                        <h5 class="card-title">Get Some Idea about Health illness</h5>
                                        <h5 class="font-weight-light pb-2 mb-1 border-bottom"></h5>
                                        <p class="tx-12 text-muted">80% target reached</p>
                                        <div class="card-icon-wrapper">
                                            <i class="material-icons">dvr</i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-3-desktop mdc-layout-grid__cell--span-4-tablet">
                                <div class="mdc-card info-card info-card--danger">
                                    <div class="card-inner">
                                        <h5 class="card-title">Analyze Health Record TCS Organisation</h5>
                                        <h5 class="font-weight-light pb-2 mb-1 border-bottom"></h5>
                                        <p class="tx-12 text-muted">target reached</p>
                                        <div class="card-icon-wrapper">
                                            <i class="material-icons">trending_up</i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-3-desktop mdc-layout-grid__cell--span-4-tablet">
                                <div class="mdc-card info-card info-card--primary">
                                    <div class="card-inner">
                                        <h5 class="card-title">Direct Communication  with Our experts</h5>
                                        <h5 class="font-weight-light pb-2 mb-1 border-bottom"></h5>
                                        <p class="tx-12 text-muted">90% Problem Suggest</p>
                                        <div class="card-icon-wrapper">
                                            <i class="material-icons">trending_up</i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                <div class="mdc-card">
                           <%--         <div class="d-flex justify-content-between">
                                        <h4 class="card-title mb-0">Get Some Idea about Diseases</h4>
                                        <div>
                                            <i class="material-icons refresh-icon">Clear Idea</i>
                                            <i class="material-icons options-icon ml-2">more_vert</i>
                                        </div>
                                    </div>--%>


				
                                    <div class="d-block d-sm-flex justify-content-between align-items-center">
                                    </div>








                                </div>
                            </div>
                </main>
                <!-- partial:partials/_footer.html -->
                <footer>
                    <div class="mdc-layout-grid">
                        <div class="mdc-layout-grid__inner">
                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6-desktop">
                                <span class="text-center text-sm-left d-block d-sm-inline-block tx-14">Copyright © <a href="#" target="_blank">HealthZone.com </a>2021</span>
                            </div>
                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6-desktop d-flex justify-content-end">
                                <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center tx-14"><a href="#" target="_blank"></a></span>
                            </div>
                        </div>
                    </div>
                </footer>
                <!-- partial -->
            </div>
        </div>
    </div>
    <!-- plugins:js -->
    <script src="../assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page-->
    <script src="../assets/vendors/chartjs/Chart.min.js"></script>
    <script src="../assets/vendors/jvectormap/jquery-jvectormap.min.js"></script>
    <script src="../assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <!-- End plugin js for this page-->
    <!-- inject:js -->
    <script src="../assets/js/material.js"></script>
    <script src="../assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page-->
    <script src="../assets/js/dashboard.js"></script>
    <!-- End custom js for this page-->
</body>
</html>
