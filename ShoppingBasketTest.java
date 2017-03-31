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

}