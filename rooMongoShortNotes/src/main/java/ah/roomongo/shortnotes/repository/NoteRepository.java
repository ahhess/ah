package ah.roomongo.shortnotes.repository;

import ah.roomongo.shortnotes.domain.Note;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Note.class)
public interface NoteRepository {

    List<ah.roomongo.shortnotes.domain.Note> findAll();
}
