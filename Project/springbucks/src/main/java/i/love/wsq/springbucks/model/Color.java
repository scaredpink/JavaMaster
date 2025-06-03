package i.love.wsq.springbucks.model;

public enum Color {
    RED("Red"), GREEN("Green"), BLUE("Blue");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}