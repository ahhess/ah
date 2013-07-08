package ah.roomongo.shortnotes.repository;

import ah.roomongo.shortnotes.domain.Notebook;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Notebook.class)
public interface NotebookRepository {

    List<ah.roomongo.shortnotes.domain.Notebook> findAll();
}
