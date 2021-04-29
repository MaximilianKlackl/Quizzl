import dao.FlashcardDao;
import model.Flashcard;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Flashcard f1 = new Flashcard("Test1", "Test2");
        Flashcard f2 = new Flashcard("Test2", "Test2");

        EntityManager em = Persistence.createEntityManagerFactory("persistence").createEntityManager();
        FlashcardDao flashcardDao = new FlashcardDao(em);
        flashcardDao.save(f1);
        flashcardDao.save(f2);

        flashcardDao.getAll().forEach(flashcard -> System.out.println(flashcard.getId()));
    }
}
