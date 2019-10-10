package denis.jumbo.Jumbo.entities;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
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
    private boolean showWarningNumber;
    private String todayOpen;
    private String locationType;
    private boolean collectionPoint;
    private String sapStoreID;
    private String todayClose;
    @Type(type="org.hibernate.spatial.GeometryType")
    private Point location;

}
