package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString

@Entity
public class Flashcard extends Card{

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cardlist_id")
    private FlashcardStaple flashcardList;

    public Flashcard(String back, String front){
        super(back, front);
    }

    public Flashcard(){

    }
}
