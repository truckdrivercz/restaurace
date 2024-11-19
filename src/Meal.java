public class Meal {

    private int order;
    private String category;

    public Meal(int order, String category) {
        this.order = order;
        this.category = category;
    }

    public int order() {
        return order;
    }

    public String category() {
        return category;
    }
}
