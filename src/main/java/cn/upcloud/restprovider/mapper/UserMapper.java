package cn.upcloud.restprovider.mapper;

import cn.upcloud.restprovider.model.User;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getallusers();

    @Select("select * from user where username=#{username}")
    User checkuser(String username);

    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(String username,String password);

    @Update("update user set password=#{password} where username=#{username}")
    void updateuser(String username, String password);

    @Delete("delete from user where username=#{username}")
    void deleteuser(String username);
}
