package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.util.*;

public class Molecule extends Cell {

    // Variables

    // Functions
    public String toString(){
        return String.format("{ Name: '%s', Desc: '%s', Charge: %f, Mass: %f }", name, description, charge, mass);
    }

    public void addCell(){

    }

    // Constructor
    public Molecule(int protonCount, int neutronCount, int electronCount){
        super("Molecule", "A collections of atoms", 0, 0, new Color(200, 200, 200), CellType.MOLECULE);

        ElementInfo info = ElementUtil.getInfo(protonCount, neutronCount, electronCount);
        name = info.name;
        description = info.description;
        charge = info.charge;
        mass = info.mass;
        color = info.color;
    }

}
