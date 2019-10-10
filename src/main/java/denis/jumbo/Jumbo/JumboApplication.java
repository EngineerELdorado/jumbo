package denis.jumbo.Jumbo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Point;
import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.services.IStoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JumboApplication {

	public static void main(String[] args) {
		SpringApplication.run(JumboApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(IStoreService storeService) {
		return args -> {
			/*
                 Here, I am reading the data from the Json file and writing it to the Database.

			**/
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Store>> typeReference = new TypeReference<List<Store>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("stores.json");
			try {
				List<Store> stores = mapper.readValue(inputStream,typeReference);
				for (Store store: stores){

					store.setLocation(new Point(null,null));
				}
				storeService.save(stores);
				System.out.println("Stores Saved!");
			} catch (IOException e){
				System.out.println("Exception: " + e.getMessage());
			}
		};
	}
}
