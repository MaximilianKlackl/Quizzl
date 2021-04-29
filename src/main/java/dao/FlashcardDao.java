package dao;

import model.Flashcard;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class FlashcardDao implements Dao<Flashcard>{

    private final EntityManager em;

    public FlashcardDao(EntityManager em){
        this.em = em;
    }

    @Override
    public Optional<Flashcard> get(long id) {
        return Optional.ofNullable(em.find(Flashcard.class, id));
    }

    @Override
    public void save(Flashcard flashcard) {
        executeInsideTransaction(em -> em.persist(flashcard));
    }

    @Override
    public void update(Flashcard flashcard) {
        executeInsideTransaction(em -> em.merge(flashcard));
    }

    @Override
    public void delete(Flashcard flashcard) {
        executeInsideTransaction(em -> em.remove(flashcard));
    }

    @Override
    public List<Flashcard> getAll() {
        Query query = em.createNativeQuery("SELECT * FROM card WHERE DTYPE='Flashcard'", Flashcard.class);
        return query.getResultList();
    }

    @Override
    public void deleteAll(List<Flashcard> list) {
        // there is properly a better way to do this
        for (Flashcard f: list) {
            delete(f);
        }
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
