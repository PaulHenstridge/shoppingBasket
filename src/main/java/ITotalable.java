public interface ITotalable {
    Double calcFullPrice();

    Double calcDiscountPrice(boolean hasLoyaltyCard);
}
