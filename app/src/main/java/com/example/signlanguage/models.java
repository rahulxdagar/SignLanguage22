package com.example.signlanguage;

public class models {
    String desc, name,purl;

    public models() {
    }

    public models(String desc, String name, String purl) {
        this.desc = desc;
        this.name = name;
        this.purl = purl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
