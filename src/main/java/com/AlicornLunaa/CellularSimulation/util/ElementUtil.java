package com.AlicornLunaa.CellularSimulation.util;

public class ElementUtil {

    private ElementUtil(){}

    public static float atomicWeight(int protons, int neutrons, int electrons){
        return protons + neutrons + (electrons * 0.001f);
    }

    public static int charge(int electrons){
        return (electrons == 8) ? 0 : (electrons % 8 - 4) * -1;
    }

    public static ElementInfo getInfo(int protonCount, int neutronCount, int electronCount){
        ElementInfo info = new ElementInfo("Unknown", "This element is not known.", charge(electronCount), atomicWeight(protonCount, neutronCount, electronCount), new Color(200, 100, 100));

        switch(protonCount){
            case 1:
                info.name = "Hydrogen";
                info.description = "Explosive and highly flammable gas";
                break;
            case 2:
                info.name = "Helium";
                info.description = "Lightweight!";
                break;
            case 3:
                info.name = "Lithium";
                info.description = "Batteries, anyone?";
                break;
        }

        return info;
    }

}
