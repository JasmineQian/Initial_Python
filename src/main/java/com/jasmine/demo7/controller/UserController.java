package com.jasmine.demo7.controller;

import com.jasmine.demo7.entity.User;
import com.jasmine.demo7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * @Description:查询所有用户信息
     * 访问地址：http://localhost:port/users/findAll
     * @param request
     */
    @RequestMapping("/findAllpage")
    public String findAllpage(Model model) {
        System.out.println("查询所有用户信息");
        List<User> userList = userService.findAll();
        if(userList.size()>0) {
            System.out.println("查询用户信息成功");
        }
        model.addAttribute("userList", userList);
        return "userList";
    }


    @RequestMapping("/findByIdpage")
    public String findByIdpage(Model model, @RequestParam("userId") int id) {
        System.out.println("根据用户ID查询用户信息");
        User user = userService.findById(id);
        System.out.println(user);
        if(user!=null) {
            System.out.println("查询用户成功！");
            //model.addAttribute(user);
            model.addAttribute("user", user);
            model.addAttribute("message", "查询");
            return "details";
        }else {
            System.out.println("查询用户失败!");
            return "error";
        }
    }

    /**
     * @Description:转向修改页面，获取列表页面传递过来的用户参数，然后保存，在修改页面获取展示，然后再进行修改
     * 访问地址：http://localhost:8080/users/toUpdate?userId=xx&userName=xx&userAge=xx&userSex=xx
     * @return 返回修改页面
     */

    @RequestMapping("/toUpdate")
    public String toUpdate(Model model,@RequestParam("userId") int id,@RequestParam("userName") String name,
                           @RequestParam("userAge") String age,@RequestParam("phone") String phone,@RequestParam("password") String password) {
        System.out.println("转向更新页面,在页面提交之前，并未进行更新");
        //保存用户信息，传递到更新页面
//        request.setAttribute("userId", userId);
//        request.setAttribute("userName", userName);
//        request.setAttribute("userAge", userAge);
//        request.setAttribute("phone", phone);
//        request.setAttribute("password", password);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("phone", phone);
        model.addAttribute("password", password);
        return "update";
    }

    @RequestMapping("/insert")
    public String insert() {
        System.out.println("转页面");
        return "insert";
    }

    /**
     * @Description:根据用户ID删除用户信息
     * 访问地址：http://localhost:8080/users/delete?userId=xx
     */
    @RequestMapping("/deletepage")
    public String delete(HttpServletRequest request,@RequestParam("userId") int userId) {
        int result = userService.delete(userId);
        if(result == 1) {
            System.out.println("删除用户成功!");
            request.setAttribute("message","删除");
            return "success";
        }else {
            System.out.println("删除用户失败!");
            return "error";
        }

    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(HttpServletRequest request) {
        System.out.println("查询所有用户信息");
        List<User> userList = userService.findAll();
        if(userList.size()>0) {
            System.out.println("查询用户信息成功");
        }
        request.setAttribute("userList", userList);
        return userList;
    }


    /**
     * @Description:根据用户ID查询用户信息
     * 访问地址：http://localhost:8080/users/findById?userId=xx
     * @return 返回用户详情页面
     */
    @GetMapping("/findById")
    public User findById(HttpServletRequest request,@RequestParam("userId") int userId) {
        System.out.println("根据用户ID查询用户信息");
        User user = userService.findById(userId);
        if(user!=null) {
            System.out.println("查询用户成功！");
            request.setAttribute("user", user);
            request.setAttribute("message", "查询");
            return user;
        }else {
            System.out.println("查询用户失败!");
            return user;
            //return "error";
        }
    }



    /**
     * @Description:新增用户
     * 访问地址：http://localhost:8080/users/create
     * @param user 传递用户对象参数，在前台页面具体填写了用户的信息(用户名、年龄、性别)
     * @return 返回成功或者失败页面
     */
    @PostMapping("/create")
    public String create(Model model,User user) {
        System.out.println("新增用户");
        int result = userService.create(user.getName(),user.getAge(),user.getPhone(),user.getPassword());
        //int result = userService.create(user.getUserName(), user.getUserAge(), user.getUserSex());
        if(result == 1) {
            System.out.println("新增用户成功！");
            model.addAttribute("message","新增");
            return "success";
        }else {
            System.out.println("新增用户失败!");
            return "error";
        }

    }



    /**
     * @Description:修改用户，获取用户的信息，先展示在页面上，然后用户进行修改
     * 访问地址：http://localhost:8080/users/update
     * @return 返回成功或者失败页面
     */
    @RequestMapping("/update")
    public String update(Model model,User user) {
        System.out.println("修改用户"+user);
        int result = userService.update(user.getId(),user.getName(),user.getAge(),user.getPhone(),user.getPassword());
        //int result = userService.update(user.getUserName(), user.getUserAge(), user.getUserSex(),user.getUserId());
        if(result == 1) {
            System.out.println("修改用户成功！");
            model.addAttribute("message","修改");
            return "success";
        }else {
            System.out.println("修改用户失败!");
            return "error";
        }
    }



}
/**
 * @Controller和@RestController注解的区别：
 @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，
 配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 例如：本来应该到success.jsp页面的，则其显示success.
 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。

**/