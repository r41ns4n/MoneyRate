package com.sabel.moneyrate;

import java.util.List;

public class RateDB {

    // DATAFIELDS
    private List<Rate> rateList;

    // CONSTRUCTORS
    public RateDB(List<Rate> rateList) {
        rateList = rateList;
    } // END DEFAULT CONSTRUCTOR

    // METHODS
    public int size() {
        return rateList.size();
    } // END public int size()

    public boolean add(Rate rate) {
        return rateList.add(rate);
    } // END public boolean add(Rate)

    public boolean add(long timestamp, double rateEUR, double rateUSD) {
        return rateList.add(timestamp, rateEUR, rateUSD);
    }

    private boolean checkIndex (int index) {
        if(index >= 0 && index < size()) {
            return true;
        }
        return false;
    }

    public Rate getLastRate() {

    }

    public Rate get(int index) {

    }

    public List<Rate> get(long beginTimestamp, long endTimestamp) {

    }

    public Rate remove(long timestamp) {
        return rateList.remove(timestamp);
    }

    // OVERRIDE TOSTRING


    @Override
    public String toString() {
        return "RateDB{" +
                "RateList=" + rateList +
                '}';
    }
} // END CLASS RATEDB
