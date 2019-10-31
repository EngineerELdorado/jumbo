package denis.jumbo.Jumbo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String by;
    private String comment;
    @ManyToOne
    private Vendor vendor;
    @ManyToOne
    private Phone phone;
    private Date creationDate;
    private Long creationTime;
}
