package com.example.caredirectiontest.api;

import com.example.caredirectiontest.dto.User;
import com.example.caredirectiontest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.caredirectiontest.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) { this.userService = userService;}

    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody final User user){
        // RequestBody는 content-type이 application/json형식만 받음
        try{
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
