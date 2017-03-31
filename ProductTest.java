import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ProductTest {

  Product milk;

  @Before
  public void before(){
    milk = new Product("Milk", 100, false);
  }

  @Test
  public void testGetName(){
    assertEquals( "Milk", milk.getName() );
  }

  @Test
  public void testGetPrice(){
    Integer expected = 100;
    assertEquals( expected, milk.getPrice() );
  }

  @Test
  public void testGetBogof(){
    assertEquals(false, milk.getBogof() );
  }

}