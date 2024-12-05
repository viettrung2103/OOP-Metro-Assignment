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
//    public Map<String, Currency> getAllCurrencies() {
//        Connection connection = MariaDbConnection.getConnection();
//        String sql = "SELECT abbreviation, rate FROM currency";
//        Map<String, Currency> currencies = new HashMap<>();
//
//        try {
//            Statement s = connection.createStatement();
//            ResultSet rs = s.executeQuery(sql);
//
//            while (rs.next()) {
//                String name = rs.getString(1);
//                double rate = rs.getDouble(2);
//                Currency currency = new Currency(name, rate);
//                currencies.put(name, currency);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return currencies;
//    }
//
//    public Currency getCurrency(String currencyStr) {
//        Connection connection = MariaDbJPAConnection.getConnection();
//        String sql = "SELECT abbreviation, rate FROM currency WHERE abbreviation=?";
//
//        String name = null;
//        double rate = 0.0;
//        int count = 0;
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, currencyStr);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                count++;
//                name = rs.getString(1);
//                rate = rs.getDouble(2);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (count == 1) {
//            return new Currency(name, rate);
//        } else {
//            return null;
//        }
//    }

    public void addPersist(Currency currency) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }

    public Currency findByName(String abbrName){
        EntityManager em = MariaDbJPAConnection.getInstance();
//        Query query = entitymanager.createNamedQuery("find employee by id");
//
//        query.setParameter("id", 1204);
        TypedQuery<Currency> query = em.createQuery("select c from Currency c where c.abbrName = :abbr", Currency.class);
        query.setParameter("abbr",abbrName);
//        System.out.println("test"+em.createQuery("select c from Currency c where c.abbrName = :abbrName"));
//        System.out.println("query: "+query.getResultList());
//        System.out.println("single querry "+query.getSingleResult());
        Currency foundCurrency = query.getSingleResult();
//        Currency currency = em.createQuery("select c from Currency c where c.abbrName = :abbrName").getResultList()[0];
//        Currency mockCurrenty = new Currency("MOC",1);
        return foundCurrency;
    }

    public Currency findById(int id) {
        EntityManager em = MariaDbJPAConnection.getInstance();
        Currency currency = em.find(Currency.class, id);
        return currency;
    }

    public Map<String, Currency> findAll() {
        Map<String, Currency> currencies = new HashMap<>();
        EntityManager em = MariaDbJPAConnection.getInstance();
        List<Currency> currencyList = em.createQuery("select c from Currency c").getResultList();
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
