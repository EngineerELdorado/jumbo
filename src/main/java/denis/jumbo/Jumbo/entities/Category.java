package denis.jumbo.Jumbo.entities;

import javax.persistence.*;

@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    Manufacturer manufacturer;
}
