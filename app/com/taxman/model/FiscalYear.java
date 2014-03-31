package com.taxman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rory.payne on 19/03/14.
 */
public class FiscalYear extends Object implements Serializable {

    public static List<Rates> FYSettings = new ArrayList<Rates>();

    public void addFY(Rates rates) {
        FYSettings.add(rates);
    }

    public Rates getFY(int x) {
        return FYSettings.get(x);
    }

    public Rates getFYByName(String s) {
        Rates r = new Rates("NN/NN", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        for (int i = 0; i<FYSettings.size(); i++) {
            if (s.equals(FYSettings.get(i).getFiscal())) {
                r = FYSettings.get(i);
            }
        }
        return r;
    }

    @Override
    public String toString() {
        String total = "\n";
        for(int i=0; i<FYSettings.size(); i++) {
            Rates r = FYSettings.get(i);
            total += "Option: " + i+1 + " - " + r.toString();
        }
        return total;
    }

    public String fiscalToString() {
        String total = "\n";
        for(int i=0; i<FYSettings.size(); i++) {
            Rates r = FYSettings.get(i);
            int option = i+1;
            total += "\nOption: " + option + " - " + r.fiscalToString();
        }
        return total;
    }

    public static List<String> FYs() {
        List<String> all = new ArrayList<String>();
        for (int i = 0; i<FYSettings.size(); i++) {
            Rates r = FYSettings.get(i);
            all.add(r.fiscalToString());
        }
        return all;
    }
}

