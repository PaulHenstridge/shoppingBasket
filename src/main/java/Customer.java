public class Customer {
    private String name;
    private Boolean hasLoyaltyCard;
    private Basket basket;

    public Customer(String name, Boolean hasLoyaltyCard, Basket basket) {
        this.name = name;
        this.hasLoyaltyCard = hasLoyaltyCard;
        this.basket = basket;
    }

    public String getName() {
        return name;
    }

    public Boolean getHasLoyaltyCard() {
        return hasLoyaltyCard;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasLoyaltyCard(Boolean hasLoyaltyCard) {
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
