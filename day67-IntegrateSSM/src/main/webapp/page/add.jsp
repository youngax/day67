<%--
  Created by IntelliJ IDEA.
  User: 杨麟
  Date: 2022-3-15
  Time: 19:08
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
                <h1 class="h1">添加回复</h1>
            <form action="" class="form-group">
                <table class="table table-bordered">
                    <input type="hidden" name="invid" value="${Invid}">
                    <tr>
                        <td><label for="content" class="control-label">回复内容</label></td>
                        <td><textarea class="form-control" rows="3" id="content" name="content"></textarea></td>
                    </tr>
                    <tr>
                        <td><label for="author" class="control-label">回复昵称</label></td>
                        <td><input type="text" id="author" name="author" class="form-control"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="col-md-8">
                                <input type="submit" class="btn btn-info" value="提交">
                                <a href="/ReplyDetail/detail/${Invid}" class="btn btn-info">返回</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
<script>
    if(${addmsg != null and addmsg != ''}){
        alert("${addmsg}");
    }
</script>
</body>
</html>
