<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 杨麟
  Date: 2022-3-15
  Time: 11:42
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
            <h1 class="h1">帖子列表</h1>
        </div>
        <div class="col-md-8">
            <form action="/invitation/MainUI" class="form-inline" name="form">
                <input type="hidden" name="pageNum" id="pageNum">
                <label class="control-label">帖子标题</label>
                <input type="text" class="form-control" name="searchTitle" value="${SearchTitle}">
                <input type="submit" class="btn" value="搜索">
            </form>
        </div>
        <div class="col-md-10">
            <table class="table table-condensed table-bordered table-hover">
                <tr>
                    <td>标题</td>
                    <td>内容摘要</td>
                    <td>作者</td>
                    <td>发布时间</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${PageInfo.list}" var="inv">
                    <tr>
                        <td>${inv.title}</td>
                        <td>${inv.summary}</td>
                        <td>${inv.author}</td>
                        <td><fmt:formatDate value="${inv.createdate}" pattern="yyyy-MM-dd"/> </td>
                        <td>
                            <a href="/ReplyDetail/detail/${inv.id}" class="btn btn-info">查看回复</a>
                            <a href="javascript:Del(${inv.id})" class="btn btn-danger">删除</a>
                        </td>
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
    function Del(id){
        if(confirm("确认删除该条发帖和帖子回复信息？")){
            window.location.href = "/invitation/del/" + id;
        }
    }

    //提示信息
    if(${delmsg != null and delmsg != ''}){
        alert("${delmsg}");
    }


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

                $("#pageNum").val(page);

                document.form.submit();

            }
        });
    });
</script>
</html>
