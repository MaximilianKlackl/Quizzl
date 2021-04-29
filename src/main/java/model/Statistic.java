package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@Setter

@Entity
public class Statistic extends BaseEntity{

    @OneToOne(
            mappedBy = "statistic",
            cascade = CascadeType.ALL)
    private CardList cardList;

    @OneToMany(
            mappedBy = "statistic",
            cascade = {CascadeType.ALL}
    )
    private List<Card> wrongCards;

    private int timeSpend; // in minutes
    private float learnProgress; // in percent
}
