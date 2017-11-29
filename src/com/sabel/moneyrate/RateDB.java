package com.sabel.moneyrate;

import java.util.ArrayList;
import java.util.Iterator;
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
        Rate rateTMP = new Rate(timestamp, rateEUR, rateUSD);
        return rateList.add(rateTMP);
    } // END public boolean add(long timestamp, double rateEUR, double rateUSD)

    private boolean checkIndex(int index) {
        if (index >= 0 && index < size()) {
            return true;
        }
        return false;
    } // END private boolean checkIndex(int index

    public Rate getLastRate() {
        Rate currentLastRate = null;
        for (Rate rate : rateList) {
            if (currentLastRate != null) {
                if (currentLastRate.getTimestamp() <= rate.getTimestamp()) {
                    currentLastRate = rate;
                } // END SELECTION
            } else {
                currentLastRate = rate;
            } // END FIRST RUN
        } // END FOR
        return currentLastRate;
    } // END public Rate getLastRate()

    public Rate get(int index) {
        if (!checkIndex(index)) {
            System.out.println("Falscher Index!");
            return null;
        } // END IF INDEX
        return rateList.get(index);
    } // END public Rate get(int index)

    public List<Rate> get(long beginTimestamp, long endTimestamp) {
        List<Rate> rateListTime = new ArrayList<>();
        for (Rate rate : rateList) {
            if (rate.getTimestamp() > beginTimestamp && rate.getTimestamp() < endTimestamp) {
                rateListTime.add(rate);
            } // END IF
        } // END FOR
        return rateListTime;
    } // END public List<Rate> get(long beginTimestamp, long endTimestamp)

    public Rate remove(long timestamp) {
        Iterator<Rate> iterator = rateList.iterator();
        while (iterator.hasNext()) {
            Rate rateTMP = iterator.next();
            if (rateTMP.getTimestamp() == timestamp) {
                iterator.remove();
                return rateTMP;
            } // END IF
        } // END WHILE
        return null;
    } // END public Rate remove(long timestamp)

    // OVERRIDE TOSTRING
    @Override
    public String toString() {
        return "RateDB{" +
                "RateList=" + rateList +
                '}';
    }

} // END CLASS RATEDB
