package cn.tedu._5springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {
    @RequestMapping("bmi/get")
    @ResponseBody
    public String bmi(Double height, Double weight) {
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            return "偏瘦";
        } else if (bmi < 24) {
            return "正常";
        } else if (bmi < 27) {
            return "微胖";
        } else {
            return "猪？";
        }
    }
}
