<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>修改页面</title>
</head>
<body>
<center>
    <h2>修改用户</h2>
    <form action="/users/update" method="post">
        <input type="hidden" name="id" value="${id}"/>
        用户名：<input type="text" name="name" value="${name}"/><br/>
        年龄   ：<input type="text" name="age" value="${age}"/><br/>
        手机   ：<input type="text" name="phone" value="${phone}"/><br/><br/>
        密码   ：<input type="text" name="password" value="${password}"/><br/><br/>
        <input type="submit" value="修改"/>
    </form>
</center>
</body>
</html>
