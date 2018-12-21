<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>列表页面</title>
    <style>
        body{
            text-align:center;
        }
        p{
            font-size:24px;
            background-color:#ccc;
            text-align:center;
        }
        tr{
            width:400px;
            height:70px;
        }
        td{
            width:100px;
        }
    </style>
</head>
<body>
<center>
    <table border="1" cellspacing="0" cellpadding="0">
        <caption><h2>用户列表</h11></caption>
        <tr>
            <th width="200px;">操作</th>
            <th>用户ID</th>
            <th>用户名</th>
            <th>年龄</th>
            <th>电话号码</th>
            <th>密码</th>
        </tr>
			<#list userList as item>
				<tr align="center">

                    <td>
                        <a href="/users/findByIdpage?userId=${item.id}">查看</a>
                        <a href="/users/toUpdate?userId=${item.id}&userName=${item.name}&userAge=${item.age}&phone=${item.phone}&password=${item.password}">修改</a>
                        <a href="/users/deletepage?userId=${item.id}">删除</a>
                    </td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                    <td>${item.phone}</td>
                    <td>${item.password}</td>
                </tr>
            </#list>
    </table>
</center>
</body>
</html>
