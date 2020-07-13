package com.singlestone.techreview.contactentry.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

    @Column
    String first;
    @Column
    String middle;
    @Column
    String last;

    public Name() { }

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() { return first; }
    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() { return middle; }
    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() { return last; }
    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return this.first + " " + this.middle + " " + this.last;
    }
}
