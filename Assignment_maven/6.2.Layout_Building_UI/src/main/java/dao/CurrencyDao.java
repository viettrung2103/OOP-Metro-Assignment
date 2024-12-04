package dao;

import datasource.MariaDbConnection;
import entity.Currency;
import entity.CurrencyApp;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CurrencyDao {
//    CurrencyApp currencyApp;
//
//    public CurrencyDao(){
////        this.currencyApp = new CurrencyApp();
//    }

    public Map<String, Currency> getAllCurrencies() {
        Connection connection = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation, rate FROM currency";
        Map<String, Currency> currencies = new HashMap<>();

        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString(1);
                double rate = rs.getDouble(2);
                Currency currency = new Currency(name, rate);
                currencies.put(name, currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currencies;
    }

    public Currency getCurrency(String currencyStr) {
        Connection connection = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation, rate FROM currency WHERE abbreviation=?";

        String name = null;
        double rate = 0.0;
        int count = 1;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, currencyStr);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                name = rs.getString(1);
                rate = rs.getDouble(2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count == 1) {
            return new Currency(name, rate);
        } else {
            return null;
        }
    }

    public void addPersist(Currency currency) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO currency (abbreviation,rate) VALUE (?,?)";
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, currency.getName());
            ps.setDouble(2, currency.getRate());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
