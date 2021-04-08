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
            case 4:
                info.name = "Beryllium";
                info.description = "Silvery white, soft and low density";
                break;
            case 5:
                info.name = "Boron";
                info.description = "Good for pyrotechnics";
                break;
            case 6:
                info.name = "Carbon";
                info.description = "Life";
                break;
            case 7:
                info.name = "Nitrogen";
                info.description = "Cold when liquid";
                break;
            case 8:
                info.name = "Oxygen";
                info.description = "Even colder when liquid";
                break;
            case 9:
                info.name = "Fluorine";
                info.description = "Hrngh, teeth";
                break;
            case 10:
                info.name = "Neon";
                info.description = "Lights up bright";
                break;
            case 11:
                info.name = "Sodium";
                info.description = "Explosive";
                break;
            case 12:
                info.name = "Magnesium";
                info.description = "Ignites up bright";
                break;
            case 13:
                info.name = "Aluminium";
                info.description = "Aluminium or aluminium?";
                break;
            case 14:
                info.name = "Silicon";
                info.description = "Computers chips and other things";
                break;
            case 15:
                info.name = "Phosphorous";
                info.description = "Matches use this a lot";
                break;
            case 16:
                info.name = "Sulfur";
                info.description = "Smells bad";
                break;
            case 17:
                info.name = "Chlorine";
                info.description = "Don't mix with ammonia :)";
                break;
            case 18:
                info.name = "Argon";
                info.description = "Non-reactive";
                break;
            case 19:
                info.name = "Potassium";
                info.description = "Very-reactive";
                break;
            case 20:
                info.name = "Calcium";
                info.description = "Strong bones";
                break;
            case 21:
                info.name = "Scandium";
                info.description = "Used in things from mercury lamps to aerospace";
                break;
            case 22:
                info.name = "Titanium";
                info.description = "Strong";
                break;
            case 23:
                info.name = "Vanadium";
                info.description = "Good for alloying with steel";
                break;
            case 24:
                info.name = "Chromium";
                info.description = "I think its chrome";
                break;
            case 25:
                info.name = "Manganese";
                info.description = "Used in alloys, but brittle on its own";
                break;
            case 26:
                info.name = "Iron";
                info.description = "Only below Y=64";
                break;
            case 27:
                info.name = "Cobalt";
                info.description = "Resists corrosion";
                break;
            case 28:
                info.name = "Nickel";
                info.description = "Not the money kind";
                break;
            case 29:
                info.name = "Copper";
                info.description = "Pipes and heat transfer";
                break;
            case 30:
                info.name = "Zinc";
                info.description = "Used in many things";
                break;
            case 31:
                info.name = "Gallium";
                info.description = "Melts near room temperature";
                break;
            case 32:
                info.name = "Germanium";
                info.description = "Good for circuits";
                break;
            case 33:
                info.name = "Arsenic";
                info.description = "Doesn't taste too good";
                break;
            case 34:
                info.name = "Selenium";
                info.description = "Helps in your body's thyroid";
                break;
            case 35:
                info.name = "Bromine";
                info.description = "Good as a flame retardant";
                break;
            case 36:
                info.name = "Krypton";
                info.description = "Superman?";
                break;
            case 37:
                info.name = "Rubidium";
                info.description = ""; // Continue here
                break;
            case 38:
                info.name = "Strontium";
                info.description = "";
                break;
            case 39:
                info.name = "Yttrium";
                info.description = "";
                break;
            case 40:
                info.name = "Zirconium";
                info.description = "";
                break;
            case 41:
                info.name = "Niobium";
                info.description = "";
                break;
            case 42:
                info.name = "Molybdenum";
                info.description = "";
                break;
            case 43:
                info.name = "Technetium";
                info.description = "";
                break;
            case 44:
                info.name = "Ruthenium";
                info.description = "";
                break;
            case 45:
                info.name = "Rhodium";
                info.description = "";
                break;
            case 46:
                info.name = "Palladium";
                info.description = "";
                break;
            case 47:
                info.name = "Silver";
                info.description = "";
                break;
            case 48:
                info.name = "Cadmium";
                info.description = "";
                break;
            case 49:
                info.name = "Indium";
                info.description = "";
                break;
            case 50:
                info.name = "Tin";
                info.description = "";
                break;
            case 51:
                info.name = "Antimony";
                info.description = "";
                break;
            case 52:
                info.name = "Tellurium";
                info.description = "";
                break;
            case 53:
                info.name = "Iodine";
                info.description = "";
                break;
            case 54:
                info.name = "Xenon";
                info.description = "";
                break;
            case 55:
                info.name = "Cesium";
                info.description = "";
                break;
            case 56:
                info.name = "Barium";
                info.description = "";
                break;
            case 57:
                info.name = "Lanthanum";
                info.description = "";
                break;
            case 58:
                info.name = "Cerium";
                info.description = "";
                break;
            case 59:
                info.name = "Praseodymium";
                info.description = "";
                break;
            case 60:
                info.name = "Neodymium";
                info.description = "";
                break;
            case 61:
                info.name = "Promethium";
                info.description = "";
                break;
            case 62:
                info.name = "Samarium";
                info.description = "";
                break;
            case 63:
                info.name = "Europium";
                info.description = "";
                break;
            case 64:
                info.name = "Gadolinium";
                info.description = "";
                break;
            case 65:
                info.name = "Terbium";
                info.description = "";
                break;
            case 66:
                info.name = "Dysprosium";
                info.description = "";
                break;
            case 67:
                info.name = "Holmium";
                info.description = "";
                break;
            case 68:
                info.name = "Erbium";
                info.description = "";
                break;
            case 69:
                info.name = "Thulium";
                info.description = "";
                break;
            case 70:
                info.name = "Ytterbium";
                info.description = "";
                break;
            case 71:
                info.name = "Lutetium";
                info.description = "";
                break;
            case 72:
                info.name = "Hafnium";
                info.description = "";
                break;
            case 73:
                info.name = "Tantalum";
                info.description = "";
                break;
            case 74:
                info.name = "Tungsten";
                info.description = "";
                break;
            case 75:
                info.name = "Rhenium";
                info.description = "";
                break;
            case 76:
                info.name = "Osmium";
                info.description = "";
                break;
            case 77:
                info.name = "Iridium";
                info.description = "";
                break;
            case 78:
                info.name = "Platinum";
                info.description = "";
                break;
            case 79:
                info.name = "Gold";
                info.description = "";
                break;
            case 80:
                info.name = "Mercury";
                info.description = "";
                break;
            case 81:
                info.name = "Thallium";
                info.description = "";
                break;
            case 82:
                info.name = "Lead";
                info.description = "";
                break;
            case 83:
                info.name = "Bismuth";
                info.description = "";
                break;
            case 84:
                info.name = "Polonium";
                info.description = "";
                break;
            case 85:
                info.name = "Astatine";
                info.description = "";
                break;
            case 86:
                info.name = "Radon";
                info.description = "";
                break;
            case 87:
                info.name = "Francium";
                info.description = "";
                break;
            case 88:
                info.name = "Radium";
                info.description = "";
                break;
            case 89:
                info.name = "Actinium";
                info.description = "";
                break;
            case 90:
                info.name = "Thorium";
                info.description = "";
                break;
            case 91:
                info.name = "Protactinium";
                info.description = "";
                break;
            case 92:
                info.name = "Uranium";
                info.description = "";
                break;
            case 93:
                info.name = "Neptunium";
                info.description = "";
                break;
            case 94:
                info.name = "Plutonium";
                info.description = "";
                break;
            case 95:
                info.name = "Americium";
                info.description = "";
                break;
            case 96:
                info.name = "Curium";
                info.description = "";
                break;
            case 97:
                info.name = "Berkelium";
                info.description = "";
                break;
            case 98:
                info.name = "Californium";
                info.description = "";
                break;
            case 99:
                info.name = "Einsteinium";
                info.description = "";
                break;
            case 100:
                info.name = "Fermium";
                info.description = "";
                break;
            case 101:
                info.name = "Mendelevium";
                info.description = "";
                break;
            case 102:
                info.name = "Nobelium";
                info.description = "";
                break;
            case 103:
                info.name = "Lawrencium";
                info.description = "";
                break;
            case 104:
                info.name = "Rutherfordium";
                info.description = "";
                break;
            case 105:
                info.name = "Dubnium";
                info.description = "";
                break;
            case 106:
                info.name = "Seaborgium";
                info.description = "";
                break;
            case 107:
                info.name = "Bohrium";
                info.description = "";
                break;
            case 108:
                info.name = "Hassium";
                info.description = "";
                break;
            case 109:
                info.name = "Meitnerium";
                info.description = "";
                break;
            case 110:
                info.name = "Darmstadtium";
                info.description = "";
                break;
            case 111:
                info.name = "Roentgenium";
                info.description = "";
                break;
            case 112:
                info.name = "Copernicium";
                info.description = "";
                break;
            case 113:
                info.name = "Ununtrium";
                info.description = "";
                break;
            case 114:
                info.name = "Flerovium";
                info.description = "";
                break;
            case 115:
                info.name = "Ununpentium";
                info.description = "";
                break;
            case 116:
                info.name = "Livermorium";
                info.description = "";
                break;
            case 117:
                info.name = "Ununseptium";
                info.description = "";
                break;
            case 118:
                info.name = "Ununoctium";
                info.description = "";
                break;
        }

        return info;
    }

}
