package com.example.caredirectiontest.dto;

import lombok.Data;

@Data
public class User {
    private int userIdx;
    private String userName;
    private int userGender;
    private String userBirth;
    private String userId;
    private String userSalt;
    private String userPw;
}
