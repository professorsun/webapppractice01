package cn.upcloud.restprovider.controller;

import cn.upcloud.restprovider.mapper.UserMapper;
import cn.upcloud.restprovider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/user/test")
    public String test(){
        return "test it";
    }
    @RequestMapping("/user/getallusers")
    public List<User> getallusers(){
        List<User> userList= userMapper.getallusers();
        return userList;
    }
    @RequestMapping("/user/checkuser")
    public User checkuser(String username){
        User user = userMapper.checkuser(username);
        return user;
    }

    @RequestMapping("/user/adduser")
    public String adduser(String username,String password){
        User user = userMapper.checkuser(username);
        if(user!=null){
            return "the user  "+username+"has been used,ple select another name!";
                    }else{
            userMapper.adduser(username,password);
            return "the user"+username+"added";
        }
    }

    @RequestMapping("/user/updateuser")
    public void updateuser(String username,String password){
        userMapper.updateuser(username,password);

    }

    @RequestMapping("/user/deleteuser")
    public String deleteuser(String username){
        userMapper.deleteuser(username);
        User checkuser = userMapper.checkuser(username);
        if(checkuser!=null){
            return "operation failed ple delete again";
        }else{
            return "the delete operation succesed!";
        }

    }


}
