package com.chikli.gdi.help;

import java.util.ArrayList;
import java.util.List;

public class Cash {

    public final List<CashDonation> donations = new ArrayList<>();

    public void add(CashDonation cashDonation) {
        donations.add(cashDonation);
    }
}
