package com.example.caredirectiontest.mapper;

import com.example.caredirectiontest.dto.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> list();

    // 회원가입
    @Insert("INSERT INTO user(user_id, user_salt, user_pw) VALUES(#{user.userId},#{user.userSalt},#{user.userPw})")
    // 반환 값으로 AI값을 받아오고 싶으면 사용
    @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    int save(@Param("user") final User user);

}
