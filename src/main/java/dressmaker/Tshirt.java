package dressmaker;

public class Tshirt {
    private String size;
    private String color;

    public Tshirt(String size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        Tshirt t = (Tshirt)obj;
        return this.size.equals(t.size) && this.color.equals(t.color);
    }
}
