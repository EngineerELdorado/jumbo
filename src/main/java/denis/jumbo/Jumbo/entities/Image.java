package denis.jumbo.Jumbo.entities;

import javax.persistence.*;

@Entity(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Phone phone;
    private String link;
}
