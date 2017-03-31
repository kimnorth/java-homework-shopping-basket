import java.util.*;

public class ShoppingBasket {

  private HashMap<String, Integer> basket;

  public ShoppingBasket(){
    this.basket = new HashMap<String, Integer>();
  }

  public int getBasketSize(){
    return this.basket.size();
  }

  public void addItem(String item, Integer price){
    basket.put(item, price);
  }

  public void deleteItem(String item){
    this.basket.remove(item);
  }

  public void emptyBasket(){
    this.basket = new HashMap<String, Integer>();
  }

}