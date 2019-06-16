package Microservice.model;

import lombok.Data;
import nl.tbc.rekeningrijden.database.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Kweet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "userId")
    private int userId;
    private String content;
    private Date date;
}
