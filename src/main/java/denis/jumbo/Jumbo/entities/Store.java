package denis.jumbo.Jumbo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "stores")
@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * This class is a Representation of each store.
 */
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String addressName;
    private String uuid;
    private Double latitude;
    private Double longitude;
    private String complexNumber;
    private boolean showWarningMessage;
    private String todayOpen;
    private String locationType;
    private boolean collectionPoint;
    private String sapStoreID;
    private String todayClose;
    /**
     * This geometry value is not in our Json file.
     * I am adding it to make the query faster by calculating distances from it.
     */

    @JsonIgnore
    private Geometry location;

    public Store(){

    }
}
