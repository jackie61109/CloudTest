package com.test.cloud.cloudtest.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CloudListItem implements Serializable {
    private ArrayList<CloudItems> items;

    public ArrayList<CloudItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<CloudItems> items) {
        this.items = items;
    }
}
