public class MenuItem {

    private int order;
    private String name;
    private double price;

    public MenuItem(int order, String name, double price) {
        this.order = order;
        this.name = name;
        this.price = price;
    }

    public int order() {
        return order;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

}