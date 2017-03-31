import java.util.*;

public class ShoppingBasket {

  private ArrayList<Product> basket;

  public ShoppingBasket(){
    this.basket = new ArrayList<Product>();
  }

  public int getBasketSize(){
    return this.basket.size();
  }

  public void addItem(Product product){
    basket.add(product);
  }

  public void deleteItem(Product product){
      basket.remove(product);
    }

  public void emptyBasket(){
    this.basket = new ArrayList<Product>();
  }

}