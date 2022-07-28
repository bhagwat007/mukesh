package com.example.myapplication;


public class RoundList {
    private String mround;
    private String mtype;
    private String mformat;
    private String mdatestart;
    private String mdateend;
    private String match_url;

    public RoundList(String round,String type,String format,String datestart, String dateend, String match_url) {
        mround = round;
        mtype= type;
        mformat= format;
        mdatestart =datestart;
        mdateend= dateend;
        this.match_url = match_url;
    }

    public String getRound() {
        return mround;
    }
    public String getMtype() {
        return mtype;
    }

    public String getMformat() {
        return mformat;
    }

    public String getMdatestart() {
        return mdatestart;
    }

    public String getMdateend() {
        return mdateend;
    }

    public String getMatch_url(){ return match_url;}
}

