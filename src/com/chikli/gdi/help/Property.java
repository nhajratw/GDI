package com.chikli.gdi.help;

import java.util.ArrayList;
import java.util.List;

public class Property {
    public final List<PropertyDonation> donations = new ArrayList<>();

    public void add(PropertyDonation propertyDonation) {
        donations.add(propertyDonation);
    }

}
