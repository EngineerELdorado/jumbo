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
import java.util.Date;

@Data
@Entity(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String country;
    private String city;
    private String area;
    private Double latitude;
    private Double longitude;
    private boolean isOpen;
    private boolean verified;
    private String phone;
    private String password;
    private String image;
    @JsonIgnore
    private Geometry location;
    private Long creationTime;
    private Date creationDate;

    public Vendor(){

    }
}
