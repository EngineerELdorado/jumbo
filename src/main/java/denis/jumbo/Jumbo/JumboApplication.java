package denis.jumbo.Jumbo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.services.IStoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

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
			TypeReference<List<Store>> mapType = new TypeReference<List<Store>>() {};
			InputStream is = TypeReference.class.getResourceAsStream("/stores.json");
			try {
				List<Store> stateList = mapper.readValue(is, mapType);
				stateList.stream().forEach(x->{
                   // x.setLocation(null);
					storeService.save(x);
				});
				System.out.println("States list saved successfully");
				storeService.updateLocations();;
				System.out.println("locations updated");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		};
	}
}
