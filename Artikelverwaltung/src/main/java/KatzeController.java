import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class KatzeController {
    private List<Katze> katzen;

    public KatzeController() {
        katzen = List.of(
                new Katze("Toto", 666),
                new Katze("Mimi", 3),
                new Katze("Felix", 5)
        );
    }

    public List<Katze> getKatzen() {
        return katzen;
    }

    public void setKatzen(List<Katze> katzen) {
        this.katzen = katzen;
    }
}
