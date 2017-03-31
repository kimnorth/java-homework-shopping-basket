import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ProductTest {

  Product milk;

  @Before
  public void before(){
    milk = new Product("Milk", 400, false);
  }

  @Test
  public void testGetName(){
    assertEquals( "Milk", milk.getName() );
  }

}