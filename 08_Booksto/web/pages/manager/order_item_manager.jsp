<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <div>
        <a href="manager/orderServlet?action=showAllOrders">返回</a>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>图书编号</td>
            <td>图书名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>订单号</td>
        </tr>

        <c:forEach items="${requestScope.orderItems}" var="orderItem">
            <tr>
                <td>${orderItem.id}</td>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
                <td>${orderItem.orderId}</td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>
