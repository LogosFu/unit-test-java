package dressmaker;

public class Dressmaker {
    private String name;
    public Dressmaker(String name) {
        this.name = name;
    }

    public Tshirt tailor(String color) {
        return new Tshirt("XL", color);
    }
}
