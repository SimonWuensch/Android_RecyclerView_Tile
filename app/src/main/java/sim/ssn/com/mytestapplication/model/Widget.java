package sim.ssn.com.mytestapplication.model;

public class Widget {

    private String name;
    private int svg;

    public Widget(String name, int svg) {
        this.name = name;
        this.svg = svg;
    }

    public static Widget create(String name, int svg){
        return new Widget(name, svg);
    }

    public int getSvg() {
        return svg;
    }

    public String getName() {
        return name;
    }
}
