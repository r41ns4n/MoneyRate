package com.sabel.moneyrate;

import java.sql.*;

public class RateService {

    // DATAFIELD
    private Connection connection;
    private PreparedStatement pStatInsert;
    private PreparedStatement pStatSelect;
    private PreparedStatement pStatSelectLast;
    private static final String URL = "jdbc:sqlite:d:\\G I3A\\Programmierung\\sqliteDB\\rate.sqlite";
    private static final String SQLSELECT = "SELECT * FROM rates";
    private static final String SQLINSERT = "INSERT INTO rates (tstamp, rateEUR, rateUSD) VALUES (?,?,?)";

    // CONSTRUCTOR
    public RateService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.pStatInsert = connection.prepareStatement(SQLINSERT);
        this.pStatSelect = connection.prepareStatement(SQLSELECT);
    } // END public RateService() throws SQLException

    // METHODS
    public void save(Rate rate) throws SQLException {
        pStatInsert.setLong(1, rate.getTimestamp());
        pStatInsert.setDouble(2, rate.getRateEUR());
        pStatInsert.setDouble(3, rate.getRateUSD());
        this.pStatInsert.executeUpdate();
    } // END public void save(Rate rate) throws SQLException

    public RateDB readAllRates() throws SQLException {
        RateDB rateDB = new RateDB();
        ResultSet resultSet = pStatSelect.executeQuery();
        while (resultSet.next()) {
            Rate rate = new Rate();
            rate.setTimestamp(resultSet.getLong(1));
            rate.setRateEUR(resultSet.getDouble(2));
            rate.setRateUSD(resultSet.getDouble(3));
            rateDB.add(rate);
        }
        return rateDB;
    } // END RateDB readAllRates() throws SQLException


    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    } // END public void close() throws SQLException

} // END CLASS RATE SERVICE
