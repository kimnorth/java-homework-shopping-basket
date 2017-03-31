import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ShoppingBasketTest {

  ShoppingBasket shoppingBasket;
  Product washingPowder;
  Product milk;

  @Before
  public void before(){
    shoppingBasket = new ShoppingBasket();
    washingPowder = new Product("Washing Powder", 400, false);
  }

  @Test
  public void canGiveBasketContents(){
    assertEquals(0, shoppingBasket.getBasketSize());
  }

  @Test
  public void canAddItem(){
    shoppingBasket = new ShoppingBasket();
    shoppingBasket.addItem(washingPowder);
    assertEquals(1, shoppingBasket.getBasketSize());
  }

  @Test
  public void canRemoveItem(){
    shoppingBasket = new ShoppingBasket();
    shoppingBasket.addItem(washingPowder);
    shoppingBasket.deleteItem(washingPowder);
    assertEquals(0, shoppingBasket.getBasketSize());
  }

  @Test
  public void canEmptyBasket(){
    shoppingBasket = new ShoppingBasket();
    shoppingBasket.addItem(washingPowder);
    shoppingBasket.emptyBasket();
    assertEquals(0, shoppingBasket.getBasketSize());
  }

  @Test
  public void canAddUpBasket(){
    Integer expected = 800;
    washingPowder = new Product("Washing Powder", 400, false);
    milk = new Product("Milk", 400, false);
    shoppingBasket.addItem(milk);
    shoppingBasket.addItem(washingPowder);
    shoppingBasket.addUpBasket();
    System.out.println(shoppingBasket.getBasketSize());
    assertEquals( expected, shoppingBasket.getBasketTotal() );
  }

}