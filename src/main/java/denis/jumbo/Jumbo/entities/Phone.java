package denis.jumbo.Jumbo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "phones")
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Manufacturer manufacturer;
    @ManyToOne
    private Category category;
    private String manufacturer_name;
    private String category_name;
    private String vendor_type;
    private String vendor_name;
    private String vendor_country;
    private String vendor_city;
    private String vendor_area;
    private Double vendor_latitude;
    private Double vendor_longitude;
    private boolean vendor_verified;
    private Double price;
    private String image;
    @JsonIgnore
    private Geometry vendor_location;
    private Long creationTime;
    private Date creationDate;
}
