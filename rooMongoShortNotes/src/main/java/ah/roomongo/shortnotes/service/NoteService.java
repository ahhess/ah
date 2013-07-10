package ah.roomongo.shortnotes.service;

import org.springframework.roo.addon.layers.service.RooService;

import ah.roomongo.shortnotes.domain.Notebook;

@RooService(domainTypes = { ah.roomongo.shortnotes.domain.Note.class })
public interface NoteService {

	void updateNotesWithNoteBook(Notebook notebook);

	void removeNotes(Notebook notebook);
}
