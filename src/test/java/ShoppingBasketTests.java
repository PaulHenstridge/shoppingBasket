import items.Book;
import items.CD;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTests {

    private Customer customer;
    private Basket basket;
    private Book book;
    private CD cd;

    @Before
    public void setup() {
        basket = new Basket();
        customer = new Customer("Alice", true, basket);
        book = new Book("Java for Dummies", 15.0, false, "Author Name");
        cd = new CD("Greatest Hits", 10.0, true, "Artist Name");
    }

    @Test
    public void testAddItemToBasket() {
        basket.addItem(book);
        assertEquals(1, basket.getItemCount());
    }

    @Test
    public void testRemoveItemFromBasket() {
        basket.addItem(book);
        basket.removeItem(book);
        assertEquals(0, basket.getItemCount());
    }

    @Test
    public void testEmptyBasket() {
        basket.addItem(book);
        basket.addItem(cd);
        basket.emptyBasket();
        assertEquals(0, basket.getItemCount());
    }

    @Test
    public void testCalcFullPrice() {
        basket.addItem(book); // price 15
        basket.addItem(cd); // price 10
        assertEquals(25.0, basket.calcFullPrice(), 0.01);
    }

    @Test
    public void testCalcDiscountPriceWithoutLoyaltyCard() {
        customer = new Customer("Alice", false, basket);
        basket.addItem(book); // price 15
        basket.addItem(cd); // price 10, total is over 20 so -10%
        assertEquals(22.5, basket.calcDiscountPrice(), 0.01);
    }

    @Test
    public void testCalcDiscountPriceWithLoyaltyCard() {
        basket.addItem(book); // price 15
        basket.addItem(cd); // price 10, total is over 20 so -10%, & -2% for loyalty card
        assertEquals(22.05, basket.calcDiscountPriceWithLoyaltyCard(), 0.01);
    }
}
