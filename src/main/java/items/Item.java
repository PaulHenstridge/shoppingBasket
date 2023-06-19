package items;


public abstract class Item {
    private String title;
    private double price;
    private boolean isBogof;

    public Item(String title, double price, boolean isBogof){
        this.title = title;
        this.price = price;
        this.isBogof = isBogof;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsBogof() {
        return isBogof;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBogof(boolean bogof) {
        isBogof = bogof;
    }
}
