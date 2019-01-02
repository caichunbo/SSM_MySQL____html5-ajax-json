<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户页面</title>

</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function getJson() {
        $.ajax({
            url: "${pageContext.request.contextPath }/user/getUsersJSON.do",
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            <!-- 向后端传输的数据 -->
            data:  '{"id" : 9, "userName" : "手机11", "passWord" : "21548"}',
            // data : JSON.stringify({
            //     id : $("#user_id").val(),
            // }),
            success: function (result) { <!-- 处理后端返回的数据 -->
                var message = JSON.stringify(result);
                alert(message);

                //json循环添加进表格
                for(var i = 0; i<result.length; i++) {

                    var tr = $("<tr></tr>"); //赋值
                    tr.html('<td>'+result[i].id+'</td><td>'+result[i].userName+'</td><td >'+result[i].passWord+'</td>');
                    //添加进id为table中
                    $("#table").append(tr);

                }

//               $("#select-box").html("查询成功" + message);
            },
            error: function (result) {
 //               $("#select-box").html("查询失败");
            }
        });
    }

    /**
     * 传值到另一个页面
     */
    function passValue() {
        window.location.href="${pageContext.request.contextPath}/page/list.do?id=5";
    }


    function requestJson() {
        $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/user/requestJson.do',
                contentType: 'application/json;charset=utf-8',
                data: '{"id" : 9, "userName" : "手机11", "passWord" : "21548"}',
                success: function (data) {
                    alert(data);
                }
            }
        );
    }


    function responseJson() {
        $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/user/responseJson.do',
                data: 'userName=手机22&passWord=99922',
                success: function (data) {
                    alert(data);
                }
            }
        );
    }
</script>
<body>

<a href="index.jsp">首页</a>&nbsp;<br/>

<input type="submit" value="requestJson" onclick="requestJson()"/>
<br>

<input type="submit" value="responseJson" onclick="responseJson()"/>
<br>

<input type="submit" value="获取后台传来的json" onclick="getJson()"/>
<br>

<input type="submit" value="get传值到html页面" onclick="passValue()"/>

<br>


<table id="table" width="100%" border=1 >
    <tr>
        <td>id</td>
        <td>账户</td>
        <td>密码</td>
    </tr>
</table>

</body>
</html>