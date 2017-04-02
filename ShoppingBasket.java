import java.util.*;

public class ShoppingBasket {

  private ArrayList<Product> basket;
  private Integer basketTotal;

  public ShoppingBasket(){
    this.basket = new ArrayList<Product>();
    this.basketTotal = 0;
  }

  public Integer getBasketSize(){
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

  public void addUpBasket(){
    Integer total = 0;
    for (Product product : basket) {
      total += product.getPrice();
    }
    this.basketTotal = total;
  }

  public Integer getBasketTotal(){
    return this.basketTotal;
  }

  public ArrayList<Product> getBasketItems(){
    return this.basket;
  }

}