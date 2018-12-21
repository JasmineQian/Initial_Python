<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>新增页面</title>
</head>
<body>
<center>
    <h2>新增用户</h2>
    <form action="/users/create" method="post">
        用户名：<input type="text" name="name" value=""/><br/>
        年龄   ：<input type="text" name="age" value=""/><br/>
        手机号码   ：<input type="text" name="phone" value=""/><br/><br/>
        密码   ：<input type="text" name="password" value=""/><br/><br/>
        <input type="submit" value="新增"/>
    </form>
</center>
</body>
</html>
