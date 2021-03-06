// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ah.roomongo.shortnotes.service;

import ah.roomongo.shortnotes.domain.Note;
import ah.roomongo.shortnotes.repository.NoteRepository;
import ah.roomongo.shortnotes.service.NoteServiceImpl;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect NoteServiceImpl_Roo_Service {
    
    declare @type: NoteServiceImpl: @Service;
    
    declare @type: NoteServiceImpl: @Transactional;
    
    @Autowired
    NoteRepository NoteServiceImpl.noteRepository;
    
    public long NoteServiceImpl.countAllNotes() {
        return noteRepository.count();
    }
    
    public void NoteServiceImpl.deleteNote(Note note) {
        noteRepository.delete(note);
    }
    
    public Note NoteServiceImpl.findNote(BigInteger id) {
        return noteRepository.findOne(id);
    }
    
    public List<Note> NoteServiceImpl.findAllNotes() {
        return noteRepository.findAll();
    }
    
    public List<Note> NoteServiceImpl.findNoteEntries(int firstResult, int maxResults) {
        return noteRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void NoteServiceImpl.saveNote(Note note) {
        noteRepository.save(note);
    }
    
    public Note NoteServiceImpl.updateNote(Note note) {
        return noteRepository.save(note);
    }
    
}
