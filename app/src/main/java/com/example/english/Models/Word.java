package com.example.english.Models;

public class Word {
    private String ukr, eng, category;

    public Word(String ukr, String eng, String category) {
        this.ukr = ukr;
        this.eng = eng;
        this.category = category;
    }

    public String getUkr() {
        return ukr;
    }

    public String getEng() {
        return eng;
    }

    public String getCategory() {
        return category;
    }

    public void setUkr(String ukr) {
        this.ukr = ukr;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
