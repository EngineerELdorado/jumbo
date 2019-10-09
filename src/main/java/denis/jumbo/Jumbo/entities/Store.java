package denis.jumbo.Jumbo.entities;

import lombok.Data;

@Data
public class Store {

    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String addressName;
    private String uuid;
    private String latitude;
    private String longitude;
    private String complexNumber;
    private boolean showWarningNumber;
    private String todayOpen;
    private String locationType;
    private boolean collectionPoint;
    private String sapStoreID;
    private String todayClose;

}
