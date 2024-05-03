package ru.gb.jseminar.data;

public class Notebook {
    private int ozu;
    private int jd;
    private int cost;
    private String os;
    private String color;
    private String company;


    public Notebook (int ozu, int jd, int cost, String os, String color, String company){
        this.ozu = ozu;
        this.jd = jd;
        this.cost = cost;
        this.os = os;
        this.color = color;
        this.company = company;
    }

    public String get(String what){
        if (what == "ozu"){
            return Integer.toString(ozu);
        } else if (what == "jd"){
            return Integer.toString(jd);
        } else if (what == "cost"){
            return Integer.toString(cost);
        } else if (what == "os"){
            return os;
        } else if (what == "color"){
            return color;
        } else if (what == "company"){
            return company;
        } else {
            return "no such characteristic";
        }
    }

    public String toString(){
        return "[ozu: "+ Integer.toString(ozu) + ", jd: " + Integer.toString(jd) + ", cost: " + Integer.toString(cost) 
            + ", os: " + os + ", color: " + color + ", company: " + company + "]";
    }
}
