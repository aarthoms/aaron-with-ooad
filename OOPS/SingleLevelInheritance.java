class SingleLevelInheritance {

    public static void main(String args[]) {

        Calopsita richie = new Calopsita("Richie", "dull-white");
        Budgie cheenku = new Budgie("Cheenku", "cyan-blue");

        cheenku.weight = 100;
        cheenku.beakColor = "blue";

        richie.gender = 'm';

        System.out.println("Cheenku's Gender is: " + cheenku.getGender());
        System.out.println("Richie's Gender is: " + richie.getGender());
    }
}

class Bird {

    public int weight;
    public char gender;

    Bird(int w, char gen) {
        weight = w;
        gender = gen;
    }

    Bird() {}

    void fly() {
        System.out.println("This Bird can Fly");
    }

    char getGender() {
        return gender;
    }
}

class Calopsita extends Bird {

    public String name;
    public String color;

    Calopsita(String nm, String cl) {
        name = nm;
        color = cl;
    }
}

class Budgie extends Bird {

    public String name;
    public String color;
    public String beakColor;

    Budgie(String nm, String cl) {
        name = nm;
        color = cl;
    }

    @Override
    char getGender() {
        return "blue".equals(beakColor) ? 'm' : 'f';
    }
}