<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 杨麟
  Date: 2022-3-15
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery-3.4.1.js"></script>
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/bootstrap-paginator.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-8">
        <h1 class="h1">回复信息列表</h1>
    </div>
    <div class="col-md-8">
        <a href="/ReplyDetail/add?invid=${Invid}" class="btn btn-info">添加回复</a>
        <a href="/invitation/MainUI" class="btn btn-info">返回帖子列表</a>
    </div>
    <div class="col-md-10">
        <table class="table table-condensed table-bordered table-hover">
            <tr>
                <td>回复内容</td>
                <td>回复昵称</td>
                <td>发布时间</td>
            </tr>
            <c:forEach items="${PageInfo.list}" var="rep">
                <tr>
                    <td>${rep.content}</td>
                    <td>${rep.author}</td>
                    <td><fmt:formatDate value="${rep.createdate}" pattern="yyyy-MM-dd"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-8">
        <!--分页组件-->
        <ul id="page"></ul>
    </div>

</div>
</body>
<script>

    $(function() {
        var currentPage = ${PageInfo.pageNum};
        var totalPages = ${PageInfo.pages};
        $("#page").bootstrapPaginator({
            bootstrapMajorVersion:3, //对应的bootstrap版本
            currentPage: currentPage, //当前页数
            numberOfPages: 10, //每次显示页数
            totalPages:totalPages, //总页数
            useBootstrapTooltip:false,
            itemTexts : function(type, page, current) {//设置分页按钮显示字体样式
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            //点击事件
            onPageClicked: function (event, originalEvent, type, page) {
                console.log(page);

                window.location.href = "/ReplyDetail/detail/${Invid}?pageNum="+page;

            }
        });
    });
</script>
</html>
