import model.Flashcard;
import model.FlashcardStaple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Flashcard flashcard1 = new Flashcard("test1", "test2");
        Flashcard flashcard2 = new Flashcard("test1", "test2");

        FlashcardStaple flashcardStaple = new FlashcardStaple();
        flashcardStaple.setTopic("Nice");
        List<Flashcard> flashcardList = new ArrayList<>();

        flashcard1.setFlashcardList(flashcardStaple);
        flashcard2.setFlashcardList(flashcardStaple);

        EntityManager em = Persistence.createEntityManagerFactory("persistence").createEntityManager();

        em.getTransaction().begin();
        //em.persist(flashcard1);
        em.getTransaction().commit();
    }
}
