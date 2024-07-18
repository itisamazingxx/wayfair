<%--
  Created by IntelliJ IDEA.
  User: beauwen
  Date: 7/17/24
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSP文件头 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 用户访问网站首页 -->
<!-- 直接请求customerFurnitureServlet, 获取网站首页要显示的分页数据 -->
<jsp:forward page="/customerFurnitureServlet?action=page&pageNo=1"></jsp:forward>