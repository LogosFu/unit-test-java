package dressmaker;

public class Dressmaker {
    private String name;
    public Dressmaker(String name) {
        this.name = name;
    }

    public Tshirt tailor(String size, String color) {
        return new Tshirt(size, color);
    }
}
