package com.chikli.gdi.help;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nayan on 3/20/16.
 */
public class CashImplementation {
    private List<CashDonation> donations = new ArrayList<>();

    public List<CashDonation> getCashDonationList() {
        return donations;
    }

    public void add(CashDonation cashDonation) {
        donations.add(cashDonation);
    }
}
