<!-- JSP文件头 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <!-- 设置网页标题 -->
    <title>Wayfair</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <!-- 移动端适配 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- 引用 CSS 样式表，路径为相对于 HTML 文件的位置 -->
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css"/>
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"/>
    <link rel="stylesheet" href="assets/css/style.min.css"/>
    <!-- 引入Jquery -->
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>

    <script type="text/javascript">

        // 会员注册前端用户校验
        $(function () { // 页面加载完毕后执行的function

            // 绑定用户注册时的点击事件(用户名密码验证)
            $("#sub-btn-signup").click(function () {

                // 获取到输入的用户名 (自己校正前端页面)
                var usernameVar = $("#username").val();
                // 编写正则表达式来进行验证
                var usernamePattern = /^\w{6,10}$/; // 正则表达式中间不能有空格
                // 验证
                if (!usernamePattern.test(usernameVar)) {
                    // 如果输入用户名不匹配正则表达式, 展示错误信息
                    $("span[class='errorMsg']").text("用户名格式错误");
                    return false;
                }

                // // 检查用户密码
                var passwordVar = $("#password").val();
                // 编写正则表达式来进行验证
                var passwordPattern = /^\w{6,10}$/;
                // 验证
                if (!passwordPattern.test(passwordVar)) {
                    $("span[class='errorMsg']").text("密码格式错误");
                    return false;
                }

                // 检查用户注册过程中两次输入密码是否相同
                var repwdVar = $("#repwd").val();
                if (repwdVar != passwordVar) {
                    $("span[class='errorMsg']").text("两次密码输入的不相同");
                    return false;
                }

                // 检查用户输入的邮箱信息
                var emailVar = $("#email").val();
                var emailPattern = /^[\w-]+@([a-zA-Z]+\.)+[a-zA-Z]+$/;
                if (!emailPattern.test(emailVar)) {
                    $("span[class='errorMsg']").text("邮箱输入格式不正确");
                    return false;
                }

                // 显示验证通过
                $("span[class='errorMsg']").text("用户验证通过");
                return true;
            })
        })
    </script>

</head>

<body>
<!-- Header Area start  -->
<div class="header section">
    <!-- Header Top Message Start -->
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

            </div>
        </div>
    </div>
    <!-- Header Bottom  Start 手机端的header -->
    <div class="header-bottom d-lg-none sticky-nav bg-white">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img width="280px" src="assets/images/logo/logo.png" alt="Site Logo" /></a>
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
<!-- Header Area End  -->

<!-- login area start -->
<div class="login-register-area pt-70px pb-100px">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-12 ml-auto mr-auto">
                <div class="login-register-wrapper">
                    <div class="login-register-tab-list nav">
                        <a class="active" data-bs-toggle="tab" href="#lg1">
                            <!-- 会员登录标题 -->
                            <h4>Member Log-in</h4>
                        </a>
                        <a data-bs-toggle="tab" href="#lg2">
                            <!-- 会员注册标题 -->
                            <h4>Member Sign-up</h4>
                        </a>
                    </div>
                    <div class="tab-content">
                        <div id="lg1" class="tab-pane active">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <!-- 提示错误信息 -->
                                    <span style="font-size: 18pt; font-weight: bold; float: right; color: gainsboro">
                                    ${requestScope.msg};
                                    </span>
                                    <!-- 用户登录表单 -->
                                    <!-- 给login和register表单增加hidden元素, 分别表示注册和登录 -->
                                    <form action="/userServlet" method="post">
                                        <input type="hidden" name="action" value="login">
                                        <input type="text" name="username" placeholder="Username"/>
                                        <input type="password" name="password" placeholder="Password"/>
                                        <div class="button-box">
                                            <div class="login-toggle-btn">
                                                <input type="checkbox"/>
                                                <a class="flote-none" href="javascript:void(0)">Remember me</a>
                                                <a href="#">Forgot Password?</a>
                                            </div>
                                            <button type="submit" id="sub-btn-login"><span>Log in</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div id="lg2" class="tab-pane">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <!-- 用户注册表单 -->
                                    <span class="errorMsg"
                                          style="float: right; font-weight: bold; font-size: 20pt; margin-left: 10px;"></span>
                                    <form action="/userServlet" method="post">
                                        <input type="hidden" name="action" value="register">
                                        <input type="text" id="username" name="username" placeholder="Username"/>
                                        <input type="password" id="password" name="password" placeholder="输入密码"/>
                                        <input type="password" id="repwd" name="repassword" placeholder="确认密码"/>
                                        <input type="email" name="email" id="email" placeholder="电子邮件"/>
                                        <input type="text" id="code" name="code" style="width: 50%" id="code"
                                               placeholder="CODE"/>　　<img alt="" src="kaptchaServlet" style="width: 120px; height: 50px">
                                        <div class="button-box">
                                            <!-- 前端代码中的button可以另取名id, 用于与jQuery的连接 -->
                                            <button type="submit" id="sub-btn-signup"><span>Sign up</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- login area end -->

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
                                        <li class="li"><a class="single-link" href="login.jsp">登录</a></li>
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