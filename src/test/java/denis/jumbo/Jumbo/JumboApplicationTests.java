package denis.jumbo.Jumbo;

import denis.jumbo.Jumbo.controllers.StoreController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JumboApplicationTests {
	@Autowired
	StoreController storeController;
	@Test
	public void contextLoads() {

		storeController.findAll();
	}

}
