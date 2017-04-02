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
    Integer expected = 0;
    assertEquals(expected, shoppingBasket.getBasketSize());
  }

  @Test
  public void canAddItem(){
    shoppingBasket = new ShoppingBasket();
    shoppingBasket.addItem(washingPowder);
    Integer expected = 1;
    assertEquals(expected, shoppingBasket.getBasketSize());
  }

  @Test
  public void canRemoveItem(){
    shoppingBasket = new ShoppingBasket();
    shoppingBasket.addItem(washingPowder);
    shoppingBasket.deleteItem(washingPowder);
    Integer expected = 0;
    assertEquals(expected, shoppingBasket.getBasketSize());
  }

  @Test
  public void canEmptyBasket(){
    shoppingBasket = new ShoppingBasket();
    shoppingBasket.addItem(washingPowder);
    shoppingBasket.emptyBasket();
    Integer expected = 0;
    assertEquals(expected, shoppingBasket.getBasketSize());
  }

  @Test
  public void canAddUpBasket(){
    Integer expected = 800;
    washingPowder = new Product("Washing Powder", 400, false);
    milk = new Product("Milk", 400, false);
    shoppingBasket.addItem(milk);
    shoppingBasket.addItem(washingPowder);
    shoppingBasket.addUpBasket();
    assertEquals( expected, shoppingBasket.getBasketTotal() );
  }

  @Test
  public void testCanAddMultipleIdenticalItems(){
    milk = new Product("Milk", 400, true);
    shoppingBasket.addItem(milk);
    shoppingBasket.addItem(milk);
    Integer expected = 2;
    assertEquals(expected, shoppingBasket.getBasketSize());
  }

}