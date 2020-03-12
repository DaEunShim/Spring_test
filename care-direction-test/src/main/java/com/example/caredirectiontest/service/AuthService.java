package com.example.caredirectiontest.service;

import com.example.caredirectiontest.dto.User;
import com.example.caredirectiontest.mapper.UserMapper;
import com.example.caredirectiontest.model.DefaultRes;
import com.example.caredirectiontest.model.LoginReq;
import com.example.caredirectiontest.utils.ResponseMessage;
import com.example.caredirectiontest.utils.StatusCode;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserMapper userMapper;
    private final JWTService jwtService;

    public AuthService(final UserMapper userMapper, final JWTService jwtService){
        this.userMapper=userMapper;
        this.jwtService=jwtService;
    }

    // 로그인 서비스
    public DefaultRes<JWTService.TokenRes> login(final LoginReq loginReq){
        final User user = userMapper.findByUserNameAndPw(loginReq.getName(), loginReq.getPassword());
        if (user != null) {
            //토큰 생성
            final JWTService.TokenRes tokenDto = new JWTService.TokenRes(jwtService.create(user.getUserIdx()));
            return DefaultRes.res(StatusCode.OK, ResponseMessage.SIGN_IN_SUCCESS, tokenDto);
        }
        return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.SIGN_IN_ERROR);
    }

}
