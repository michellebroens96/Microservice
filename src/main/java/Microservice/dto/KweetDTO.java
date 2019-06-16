package Microservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class KweetDTO {

    private int userId;
    private String content;
    private Date date;
}
