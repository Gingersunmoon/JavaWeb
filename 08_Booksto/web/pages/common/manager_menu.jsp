<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/4
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<%--    a标签回车是传到servlet的doget方法中，所以servlet记得重写servlet--%>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="manager/orderServlet?action=showAllOrders">订单管理</a>
    <a href="/08_Booksto">返回商城</a>
</div>
