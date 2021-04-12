<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.atguigu.pojo.Person" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/3
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person=new Person();
    person.setName("姜科");
    person.setPhone(new String[]{"15271034538", "15271025258"});
    List<String> cities =new ArrayList<>();
    cities.add("shanghai");
    cities.add("beijing");
    cities.add("shenzheng");
    person.setCities(cities);
    Map<String,Object> map=new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);
    pageContext.setAttribute("p",person);
%>
输出person:${person}<br/>
</body>
</html>
