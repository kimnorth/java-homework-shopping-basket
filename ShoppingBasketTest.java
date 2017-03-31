import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ShoppingBasketTest {

  ShoppingBasket shoppingBasket;

  @Before
  public void before(){
    shoppingBasket = new ShoppingBasket();
  }

  @Test
  public void canGiveBasketContents(){
    assertEquals(0, shoppingBasket.getBasketSize());
  }

  @Test
  public void canAddItem(){
    shoppingBasket = new ShoppingBasket();
    shoppingBasket.addItem("Washing Powder", 400);
    assertEquals(1, shoppingBasket.getBasketSize());
  }

}