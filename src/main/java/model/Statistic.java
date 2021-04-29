package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statistic_id")
    private long id;

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
