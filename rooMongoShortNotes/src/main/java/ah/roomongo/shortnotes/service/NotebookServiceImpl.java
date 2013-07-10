package ah.roomongo.shortnotes.service;

import org.springframework.beans.factory.annotation.Autowired;

import ah.roomongo.shortnotes.domain.Notebook;
import ah.roomongo.shortnotes.repository.NotebookRepository;

public class NotebookServiceImpl implements NotebookService {

    @Autowired
    NotebookRepository notebookRepository;

    @Autowired
    NoteService noteService;
    
	public void saveNotebook(Notebook notebook) {
        updateNotebook(notebook);
    }
	
	public Notebook updateNotebook(Notebook notebook) {
		Notebook notebook2 = notebookRepository.save(notebook);
		noteService.updateNotesWithNoteBook(notebook2);
		return notebook2;
	}

	public void deleteNotebook(Notebook notebook) {
		noteService.removeNotes(notebook);
        notebookRepository.delete(notebook);
    }
}
