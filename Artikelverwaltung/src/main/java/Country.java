import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country {

    @Id
    private int nr;
    private String name;
    private double emissions;
}
