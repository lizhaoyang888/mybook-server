<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <script type="text/javascript" src="statics/js/json2.js"></script>
    <script type="text/javascript" src="statics/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            testRequestBody();
        });
        function testRequestBody() {
            $.ajax("${pageContext.request.contextPath}/myperson/query",
                {
                    dataType:"json",
                    type:"post",
                    contentType:"application/json",
                    data:JSON.stringify({name:"杰克",password:"123456"}),
                    async:true,
                    success:function(data) {
                    console.log(data);
                    $("#id").html(data.id);
                    $("#name").html(data.name);
                    $("#password").html(data.password);
                },
                error:function() {
                    alert("数据发送失败");
                }
            });
        }

    </script>
</head>
<body>
编号：<span id="id"></span><br>
书名：<span id="name"></span><br>
作者：<span id="password"></span><br>
</body>
</html>
