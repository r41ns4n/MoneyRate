package com.sabel.moneyrate;

import java.sql.SQLException;
import java.util.Date;

public class JMain {
    public static void main(String[] args) {


        // OBJEKT RATE
        Rate rate1 = new Rate(new Date().getTime() / 1000, 8845.45, 2.06);
        Rate rate2 = new Rate(new Date().getTime() / 1000, 8845.86, 2.16);
        Rate rate3 = new Rate(new Date().getTime() / 1000, 8845.60, 1.06);

        RateService rateService = null;
        try {
            rateService = new RateService();
            rateService.save(rate1);
            rateService.save(rate2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rateService.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    } // END MAIN

} // END CLASS JMAIN
