import items.Item;

import java.util.HashMap;

public class Basket implements ITotalable {
    private HashMap<Item, Integer> shopping;
    private static final double LOYALTY_CARD_DISCOUNT = 0.02;
    private static final double BASKET_VALUE_DISCOUNT = 0.10;

    public Basket() {
        this.shopping = new HashMap<>();
    }

    public void addItem(Item item) {
        this.shopping.put(item, this.shopping.getOrDefault(item, 0) + 1);
    }

    public void removeItem(Item item) {
        this.shopping.put(item, this.shopping.get(item) - 1);
        if(this.shopping.get(item) == 0) {
            this.shopping.remove(item);
        }
    }

    public void emptyBasket() {
        this.shopping.clear();
    }

    public int getItemCount() {
        return this.shopping.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public Double calcFullPrice() {
        return this.shopping.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public Double calcDiscountPrice() {
        double discountPrice = this.shopping.entrySet().stream()
                .mapToDouble(entry -> {
                    Item item = entry.getKey();
                    int quantity = entry.getValue();
                    double price = item.getPrice();
                    if (item.getIsBogof()) {
                        price *= ((quantity / 2) + (quantity % 2));
                    } else {
                        price *= quantity;
                    }
                    return price;
                })
                .sum();

        if (discountPrice > 20) {
            discountPrice *= (1 - BASKET_VALUE_DISCOUNT);
        }

        return discountPrice;
    }

    public Double calcDiscountPriceWithLoyaltyCard() {
        double discountPrice = calcDiscountPrice();
        discountPrice *= (1 - LOYALTY_CARD_DISCOUNT);
        return discountPrice;
    }
}
