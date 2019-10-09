package denis.jumbo.Jumbo.models;

import lombok.Data;

@Data
public class ApiResponse {

    private String responseCode;
    private String responseMessage;
    private String data;
}
