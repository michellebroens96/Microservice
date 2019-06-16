package Microservice.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int userId;
    private String name;
    private String username;
    private String password;
    private String location;
    private String web;
    private String bio;
    private String image;
    private String token;
}
