package ifrs.dev;
import javax.enterprise.context.ApplicationScoped;

import ifrs.dev.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FakeRepository implements PanacheRepository<Usuario> {
   //...not necessay implementation
}