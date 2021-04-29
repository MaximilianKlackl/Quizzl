package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@Setter

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Card extends BaseEntity{

    private String front;
    private String back;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "statistic_id")
    private Statistic statistic;

    public Card(String front, String back){

        this.front = front;
        this.back = back;
    }

    public Card() {

    }
}
