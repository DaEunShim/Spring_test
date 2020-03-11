package com.example.caredirectiontest.service;

import com.example.caredirectiontest.dto.User;
import com.example.caredirectiontest.mapper.UserMapper;
import com.example.caredirectiontest.model.DefaultRes;
import com.example.caredirectiontest.utils.ResponseMessage;
import com.example.caredirectiontest.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;

    // 생성자
    public UserService(final UserMapper userMapper) { this.userMapper = userMapper;}

    public DefaultRes save(final User user){
        try{
            userMapper.save(user);
            return DefaultRes.res(StatusCode.CREATED,ResponseMessage.SIGN_UP_INSERT_SUCCESS);
        } catch(Exception e){
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
