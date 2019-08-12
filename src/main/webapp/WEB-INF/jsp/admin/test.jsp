<%--
  Created by IntelliJ IDEA.
  User: AARON
  Date: 2019/6/7
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"  %>
<html>
<head>
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <title>Title</title>
</head>
<body>
<form action="showdata" method="post" enctype="multipart/form-data">
    number <input type="number" name="id">
    file <input type="file" name="testFile" multiple="multiple">
    date<input type="date" name="setDate">
    <input type="submit">
  <%--  text<input type="text">
    button<input type="button">
    checkbox<input type="checkbox">&lt;%&ndash;&ndash;%&gt;
    color <input type="color">
    date<input type="date">
    datetime-local <input type="datetime-local">
    email<input type="email">
    hidden<input type="hidden">
    image<input type="image">
    month<input type="month">
    password <input type="password">
    radio<input type="radio">
    range<input type="range">
    reset <input type="reset">
    search<input type="search">
    tel <input type="tel">
    time<input type="time">
    url<input type="url">
    week<input type="week">
    submit<input type="submit">--%>
</form>
<button onclick="add()" >点击此按钮进入新增界面</button>
<button href="addtest">点击此按钮进入新增界面2</button>


<button onclick="testAjax()">点击此按钮执行ajax请求get</button>



<script>
    // $(document).ready(function () {
    //
    // });
    function add(){
        alert("当前界面的url是"+window.location.href)
        window.location.href="addtest";
    }

    function testAjax(){
        alert("===========");
        var jsonObject={
            "exitTheStage":"退出阶段",
            "exitTime":"2018-02-25",
            "exitRatio":"34",
            "residualRatio":"23",
            "quitMoney":"5210000"
        };
        $.ajax({
            url:'testAjax',
            type:'post',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(jsonObject),
            success:function(result){
                if(result==200){
                    alert("新增成功");
                }
            }
        });
    };
</script>
</body>
</html>
