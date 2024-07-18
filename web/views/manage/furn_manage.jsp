<!-- JSP标签头 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSP文件头 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title>Wayfair</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <!-- 移动端适配 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css"/>
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"/>
    <link rel="stylesheet" href="assets/css/style.min.css">

    <!-- 引入Jquery -->
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("a.deleteCss").click(function () { // 页面加载完毕后执行
                // 获取要删除的家具id
                var furnName = $(this).parent().parent().find("td:eq(1)").text();
                return confirm("Confirm to delete " + furnName + "?");
            });
        });
    </script>
</head>

<body>
<!-- Header Area start  -->
<div class="header section">
    <!-- Header Top  End -->
    <!-- Header Bottom  Start -->
    <div class="header-bottom d-none d-lg-block">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->

                <!-- Header Action Start -->
                <div class="col align-self-center">
                    <div class="header-actions">
                        <div class="header_account_list">
                            <a href="javascript:void(0)" class="header-action-btn search-btn"><i
                                    class="icon-magnifier"></i></a>
                            <div class="dropdown_search">
                                <form class="action-form" action="#">
                                    <input class="form-control" placeholder="Enter your search key" type="text">
                                    <button class="submit" type="submit"><i class="icon-magnifier"></i></button>
                                </form>
                            </div>
                        </div>
                        <!-- Single Wedge Start -->
                        <div class="header-bottom-set dropdown">
                            <a href="#">后台管理</a>
                        </div>
                        <div class="header-bottom-set dropdown">
                            <a href="views/manage/furn_add.jsp?pageNo=${requestScope.page.pageNo}">Add Furniture</a>
                        </div>
                    </div>
                </div>
                <!-- Header Action End -->
            </div>
        </div>
    </div>
    <!-- Header Bottom  End -->
    <!-- Header Bottom  Start 手机端的header -->
    <div class="header-bottom d-lg-none sticky-nav bg-white">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img width="280px" src="assets/images/logo/logo.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->
            </div>
        </div>
    </div>
    <!-- Main Menu Start -->
    <div style="width: 100%;height: 50px;background-color: black"></div>
    <!-- Main Menu End -->
</div>
<!-- Cart Area Start -->
<div class="cart-main-area pt-100px pb-100px">
    <div class="container">

        <h3 class="cart-page-title">Wayfair Product Management</h3>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <form action="#">
                    <div class="table-content table-responsive cart-table-content">
                        <table>
                            <thead>
                            <tr>
                                <th>Products</th>
                                <th>Name</th>
                                <th>Manufacturer</th>
                                <th>Price</th>
                                <th>Sales</th>
                                <th>Stock</th>
                                <th>Operation</th>
                            </tr>
                            </thead>

                            <!-- 前端页面的家具展示部分, 根据数据库所存信息展示全部商品内容-->
                            <tbody>
                            <!-- 取出后端furnitureList里全部商品, 展示 -->
                            <!-- requestScope是从furnitureServlet接收到的转发请求 -->
                            <c:forEach items="${requestScope.page.items}" var="furniture">
                            <tr>
                                <td class="product-thumbnail">
                                    <a href="#"><img class="img-responsive ml-3" src="${furniture.img}"
                                                     alt=""/></a>
                                </td>
                                <td class="product-name"><a href="#">${furniture.name}</a></td>
                                <td class="product-name"><a href="#">${furniture.manufacturer}</a></td>
                                <td class="product-price-cart"><span class="amount">${furniture.price}</span></td>
                                <td class="product-quantity">
                                    100
                                </td>
                                <td class="product-quantity">
                                    80
                                </td>
                                <!-- 前端产品修改 & 删除操作 -->
                                <td class="product-remove">
                                    <a href="manage/furnitureServlet?action=listSingle&id=${furniture.id}&pageNo=${requestScope.page.pageNo}"><i class="icon-pencil"></i></a>
                                    <a class="deleteCss" href="manage/furnitureServlet?action=delete&id=${furniture.id}&pageNo=${requestScope.page.pageNo}"><i class="icon-close"></i></a>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </form>
            </div>
        </div>

        <!-- 家居管理后台分页导航条内容 -->
        <div class="pro-pagination-style text-center mb-md-30px mb-lm-30px mt-6" data-aos="fade-up">
            <ul>
                <!-- 如果当前页 > 1, 才显示上一页内容 -->
                <c:if test="${requestScope.page.pageNo > 1}">
                    <li><a href="manage/furnitureServlet?action=page&pageNo=${requestScope.page.pageNo - 1}">上一页</a></li>
                </c:if>

                <c:set var="begin" value="1"/>
                <c:set var="end" value="${requestScope.page.totalPage}"/>

                <c:forEach begin="${begin}" end="${end}" var="i">
                    <!-- 如果当前页 使用class="active"修饰 -->
                    <c:if test="${i == requestScope.page.pageNo}">
                        <li><a class="active" href="manage/furnitureServlet?action=page&pageNo=${i}">${i}</a></li>
                    </c:if>

                    <c:if test="${i != requestScope.page.pageNo}">
                        <li><a href="manage/furnitureServlet?action=page&pageNo=${i}">${i}</a></li>
                    </c:if>

                </c:forEach>

                <c:if test="${requestScope.page.pageNo < requestScope.page.totalPage}">
                    <li><a href="manage/furnitureServlet?action=page&pageNo=${requestScope.page.pageNo + 1}">下一页</a></li>
                </c:if>

                <li><a>总页数${requestScope.page.totalPage}页</a></li>
            </ul>
        </div>

    </div>
</div>
<!-- Cart Area End -->

<!-- Footer Area Start -->
<div class="footer-area">
    <div class="footer-container">
        <div class="footer-top">
            <div class="container">
                <div class="row">
                    <!-- Start single blog -->
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-sm-6 col-lg-3 mb-md-30px mb-lm-30px" data-aos="fade-up"
                         data-aos-delay="400">
                        <div class="single-wedge">
                            <h4 class="footer-herading">信息</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="about.html">关于我们</a></li>
                                        <li class="li"><a class="single-link" href="#">交货信息</a></li>
                                        <li class="li"><a class="single-link" href="privacy-policy.html">隐私与政策</a></li>
                                        <li class="li"><a class="single-link" href="#">条款和条件</a></li>
                                        <li class="li"><a class="single-link" href="#">制造</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-2 col-sm-6 mb-lm-30px" data-aos="fade-up" data-aos-delay="600">
                        <div class="single-wedge">
                            <h4 class="footer-herading">我的账号</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="my-account.html">我的账号</a>
                                        </li>
                                        <li class="li"><a class="single-link" href="cart.html">我的购物车</a></li>
                                        <li class="li"><a class="single-link" href="login.html">登录</a></li>
                                        <li class="li"><a class="single-link" href="wishlist.html">感兴趣的</a></li>
                                        <li class="li"><a class="single-link" href="checkout.html">结账</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="800">

                    </div>
                    <!-- End single blog -->
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row flex-sm-row-reverse">
                    <div class="col-md-6 text-right">
                        <div class="payment-link">
                            <img src="#" alt="">
                        </div>
                    </div>
                    <div class="col-md-6 text-left">
                        <p class="copy-text">Copyright &copy; 2021 韩顺平教育~</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Area End -->
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
<!-- Main Js -->
<script src="assets/js/main.js"></script>
</body>
</html>