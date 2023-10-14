package com.example.quickstartlessons.kotlin.lessonnine;

public class Main {

    public static void main(String[] args) {
        Employer employer = new Employer(new Bob(), new John());
        employer.design();
        employer.develop();
    }
}

class Employer implements WhoCanDesign, WhoCanDevelop {
    private WhoCanDesign whoCanDesign;
    private WhoCanDevelop whoCanDevelop;

    public Employer(WhoCanDesign whoCanDesign, WhoCanDevelop whoCanDevelop) {
        this.whoCanDesign = whoCanDesign;
        this.whoCanDevelop = whoCanDevelop;
    }

    @Override
    public void design() {
        whoCanDesign.design();
    }

    @Override
    public void develop() {
        whoCanDevelop.develop();
    }
}

interface WhoCanDesign {
    void design();
}

interface WhoCanDevelop {
    void develop();
}

class Bob implements WhoCanDesign {

    @Override
    public void design() {
        System.out.println("designed by Bob");
    }
}

class John implements WhoCanDevelop {

    @Override
    public void develop() {
        System.out.println("developed by John");
    }
}


