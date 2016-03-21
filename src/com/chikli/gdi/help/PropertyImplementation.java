package com.chikli.gdi.help;

import java.util.ArrayList;
import java.util.List;

public class PropertyImplementation {
    private List<PropertyDonation> donations = new ArrayList<>();

    public List<PropertyDonation> getPropertyDonationList() {
        return donations;
    }

    public void add(PropertyDonation propertyDonation) {
        donations.add(propertyDonation);
    }
}
