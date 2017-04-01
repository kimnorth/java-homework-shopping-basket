public class Customer {

  private String name;
  private Boolean loyaltyCard;
  private ShoppingBasket basket;

  public Customer(String name, Boolean loyaltyCard) {
    this.name = name;
    this.loyaltyCard = loyaltyCard;
    this.basket = new ShoppingBasket();
  }

  public String getName(){
    return this.name;
  }

  public Boolean getLoyaltyCard(){
    return this.loyaltyCard;
  }

  public Integer getShoppingSize(){
    return this.basket.getBasketSize();
  }


}