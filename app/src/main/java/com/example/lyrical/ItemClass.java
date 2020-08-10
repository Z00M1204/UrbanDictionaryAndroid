package com.example.lyrical;

public class ItemClass {

    //this is nothing more than just a standard java object class, so i can get and set my strings that i use for each definition card

    String txword;
    String txexplanation;
    String txexample;
    String txbyline;
    String txlikes;
    String txdislikes;

    public ItemClass() {
    }

    public ItemClass(String txword, String txexplanation, String txexample, String txbyline, String txlikes, String txdislikes) {
        this.txword = txword;
        this.txexplanation = txexplanation;
        this.txexample = txexample;
        this.txbyline = txbyline;
        this.txlikes = txlikes;
        this.txdislikes = txdislikes;
    }

    public String getTxword() {
        return txword;
    }

    public String getTxexplanation() {
        return txexplanation;
    }

    public String getTxexample() {
        return txexample;
    }

    public String getTxbyline() {
        return txbyline;
    }

    public String getTxlikes() {
        return txlikes;
    }

    public String getTxdislikes() {
        return txdislikes;
    }

    public void setTxword(String txword) {
        this.txword = txword;
    }

    public void setTxexplanation(String txexplanation) {
        this.txexplanation = txexplanation;
    }

    public void setTxexample(String txexample) {
        this.txexample = txexample;
    }

    public void setTxbyline(String txbyline) {
        this.txbyline = txbyline;
    }

    public void setTxlikes(String txlikes) {
        this.txlikes = txlikes;
    }

    public void setTxdislikes(String txdislikes) {
        this.txdislikes = txdislikes;
    }
}
