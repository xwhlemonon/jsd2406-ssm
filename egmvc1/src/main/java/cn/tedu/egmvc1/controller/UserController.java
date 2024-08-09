package cn.tedu.egmvc1.controller;

import cn.tedu.egmvc1.pojo.dto.UserInsertDTO1;
import cn.tedu.egmvc1.pojo.dto.UserUpdateDTO1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("user/insert")
    @ResponseBody
    public String insertUser(UserInsertDTO1 user) {
        String name = user.getName();
        Double salary = user.getSalary();
        String job = user.getJob();
        return "姓名：" + name + "\t工资：" + salary + "\t岗位：" + job;
    }

    @RequestMapping("user/select")
    @ResponseBody
    public String selectUser() {
        return "查询成功···";
    }

    @RequestMapping("user/update")
    @ResponseBody
    public String updateUser(UserUpdateDTO1 user) {
        String id = user.getId();
        String name = user.getName();
        Double salary = user.getSalary();
        String job = user.getJob();
        return id + "\t" + name + "\t" + salary + "\t" + job + "\t修改成功";
    }

    @RequestMapping("user/delete")
    @ResponseBody
    public String deleteUser(String id) {
        return id + "\t已删除";
    }
}
