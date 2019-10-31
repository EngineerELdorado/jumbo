package denis.jumbo.Jumbo.models;

import lombok.Data;

@Data
public class Address {

    private Double longitude;
    private Double latitude;
    private String country;
    private String city;
    private String area;
}
