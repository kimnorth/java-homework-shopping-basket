import java.util.*;

public class ShoppingBasket {

  private HashMap<String, Integer> basket;

  public ShoppingBasket(){
    this.basket = new HashMap<String, Integer>();
  }

  public int getBasketSize(){
    return this.basket.size();
  }

}