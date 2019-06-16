package Microservice.model;

import lombok.Data;
import nl.tbc.rekeningrijden.database.model.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
public class Kweet extends BaseEntity {

    private int userId;
    private String content;
    private Date date;
}
