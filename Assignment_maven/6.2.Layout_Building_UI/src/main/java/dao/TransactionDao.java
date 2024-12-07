package dao;

import datasource.MariaDbJPAConnection;
import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.LinkedList;
import java.util.List;

public class TransactionDao {

    public void addPersist(Transaction transaction) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
    }

    public Transaction findById(int id) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        Transaction transaction = em.find(Transaction.class, id);
        return transaction;
    }

    public List<Transaction> findAll() {
        List<Transaction> transactions = new LinkedList<>();
        EntityManager em = MariaDbJPAConnection.getInstance();
        TypedQuery<Transaction> query = em.createQuery("SELECT t FROM Transaction t", Transaction.class);
        transactions = query.getResultList();
//        transactions =
        return transactions;
    }

    public void updatePersist(Transaction transaction){
        EntityManager em = MariaDbJPAConnection.getInstance();
        em.getTransaction().begin();
        em.merge(transaction);
        em.getTransaction().commit();
    }

    public void deletePersist(Transaction transaction){
        EntityManager em = MariaDbJPAConnection.getInstance();
        em.getTransaction().begin();
        em.remove(transaction);
        em.getTransaction().commit();
    }

}
