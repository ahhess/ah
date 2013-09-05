// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ah.roomongo.shortnotes.web;

import ah.roomongo.shortnotes.domain.Note;
import ah.roomongo.shortnotes.service.NoteService;
import ah.roomongo.shortnotes.service.NotebookService;
import ah.roomongo.shortnotes.web.NoteController;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect NoteController_Roo_Controller {
    
    @Autowired
    NoteService NoteController.noteService;
    
    @Autowired
    NotebookService NoteController.notebookService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String NoteController.create(@Valid Note note, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, note);
            return "notes/create";
        }
        uiModel.asMap().clear();
        noteService.saveNote(note);
        return "redirect:/notes/" + encodeUrlPathSegment(note.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String NoteController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Note());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (notebookService.countAllNotebooks() == 0) {
            dependencies.add(new String[] { "notebook", "notebooks" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "notes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String NoteController.show(@PathVariable("id") BigInteger id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("note", noteService.findNote(id));
        uiModel.addAttribute("itemId", id);
        return "notes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String NoteController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("notes", noteService.findNoteEntries(firstResult, sizeNo));
            float nrOfPages = (float) noteService.countAllNotes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("notes", noteService.findAllNotes());
        }
        addDateTimeFormatPatterns(uiModel);
        return "notes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String NoteController.update(@Valid Note note, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, note);
            return "notes/update";
        }
        uiModel.asMap().clear();
        noteService.updateNote(note);
        return "redirect:/notes/" + encodeUrlPathSegment(note.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String NoteController.updateForm(@PathVariable("id") BigInteger id, Model uiModel) {
        populateEditForm(uiModel, noteService.findNote(id));
        return "notes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String NoteController.delete(@PathVariable("id") BigInteger id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Note note = noteService.findNote(id);
        noteService.deleteNote(note);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/notes";
    }
    
    void NoteController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("note_created_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    void NoteController.populateEditForm(Model uiModel, Note note) {
        uiModel.addAttribute("note", note);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("notebooks", notebookService.findAllNotebooks());
    }
    
    String NoteController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}