package dao;

import datasource.MariaDbConnection;
import datasource.MariaDbJPAConnection;
import entity.Currency;
import entity.CurrencyApp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyDao {

    public void addPersist(Currency currency) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }

    public Currency findByName(String abbrName){
        EntityManager em = MariaDbJPAConnection.getInstance();

        TypedQuery<Currency> query = em.createQuery("select c from Currency c where c.abbrName = :abbr", Currency.class);
        query.setParameter("abbr",abbrName);
        Currency foundCurrency = query.getSingleResult();

        return foundCurrency;
    }

    public Currency findById(int id) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        Currency currency = em.find(Currency.class, id);
        return currency;
    }

    public HashMap<String, Currency> findAll() {
        HashMap<String, Currency> currencies = new HashMap<>();
        EntityManager em = MariaDbJPAConnection.getInstance();
        List<Currency> currencyList = em.createQuery("SELECT c FROM Currency c ORDER BY c.abbrName ASC").getResultList();
        for (Currency currency : currencyList) {
            String abbrName = currency.getAbbrName();
            currencies.put(abbrName, currency);
        }
        return currencies;
    }

    public void updatePersist(Currency currency) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        em.getTransaction().begin();
        em.merge(currency);
        em.getTransaction().commit();
    }

    public void deletePersist(Currency currency) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        em.getTransaction().begin();
        em.remove(currency);
        em.getTransaction().commit();
    }

}
