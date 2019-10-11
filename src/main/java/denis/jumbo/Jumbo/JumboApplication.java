package denis.jumbo.Jumbo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.services.IStoreService;
import denis.jumbo.Jumbo.utils.GeoUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableScheduling
public class JumboApplication {

	Logger LOG = LogManager.getLogger(JumboApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JumboApplication.class, args);
	}

	/**
	 * Here I am reading the data from the Json File and storing it to the Database.
	 * We could just use the plain file to process the closest stores.
	 * But that approach would take big linear time complexity.
	 * Of course our aim is to make the user experience as great as possible.
	 * So we can fetch stores from the DB instead and have a constant time complexity.
	 * before saving the stores to the Database I am giving it a Geometry value for future queries.
	 * @param storeService
	 * @return
	 */
	@Bean
	CommandLineRunner runner(IStoreService storeService) {
		return args -> {
			/*
                 Here, I am reading the data from the Json file and writing it to the Database.

			**/
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			TypeReference<List<Store>> mapType = new TypeReference<List<Store>>() {};
			InputStream is = TypeReference.class.getResourceAsStream("/stores.json");
			try {
				List<Store> stateList = mapper.readValue(is, mapType);
				stateList.stream().forEach(x->{

					Geometry geometry = null;
					try {
						geometry = GeoUtils.wktToGeometry(String.format("POINT (%s %s)",String.valueOf( x.getLatitude()), String.valueOf(x.getLongitude())));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					x.setLocation(geometry);
					storeService.save(x);
				});
				System.out.println("States list saved successfully");
				//storeService.updateLocations();
			} catch (IOException e) {
				System.out.println("Exception");
				System.out.println(e.getMessage());
			}
		};
	}

    @Scheduled(fixedRate = 600000)
    public void keepServerAlive(){

        final String uri = "https://jumbo-store.herokuapp.com/keeServerAlive/";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        LOG.info("KEEPING THE SERVER ALIVE");
    }
}
