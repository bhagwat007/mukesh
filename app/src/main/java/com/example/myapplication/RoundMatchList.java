package com.example.myapplication;


public class RoundMatchList {
    private String mround;
    private String mtype;
    private String mformat;
    private String mdatestart;
    private String mdateend;
    private String match_url;
    private String id;

    public RoundMatchList(String round,String type,String format,String datestart, String dateend, String match_url,String id) {
        mround = round;
        mtype= type;
        mformat= format;
        mdatestart =datestart;
        mdateend= dateend;
        this.match_url = match_url;
        this.id = id;
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
    public String getId(){return id;}
}

