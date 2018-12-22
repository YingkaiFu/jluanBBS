package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import cn.edu.ncu.jiluan.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krito on 2018/12/19
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     @Description 获取全部分类信息
     @Param
     @Return List<UserEntity>
     */
    @RequestMapping(value = "userMgr",method = RequestMethod.GET)
    public List<UserEntity> findAll(Model model){
        model.addAttribute("userList",userService.findAll());
        return userService.findAll();
    }

    @RequestMapping(value = "/userDel/{userId}",method = RequestMethod.GET)
    public String deleteUserEntityByUserId(@PathVariable Integer userId){
        userService.deleteUserEntityByUserId(userId);
        return "userMgr";
    }


}
