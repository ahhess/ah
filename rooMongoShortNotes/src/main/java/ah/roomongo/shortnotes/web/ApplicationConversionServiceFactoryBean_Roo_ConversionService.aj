// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ah.roomongo.shortnotes.web;

import ah.roomongo.shortnotes.domain.Note;
import ah.roomongo.shortnotes.domain.Notebook;
import ah.roomongo.shortnotes.service.NoteService;
import ah.roomongo.shortnotes.service.NotebookService;
import ah.roomongo.shortnotes.web.ApplicationConversionServiceFactoryBean;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    @Autowired
    NoteService ApplicationConversionServiceFactoryBean.noteService;
    
    @Autowired
    NotebookService ApplicationConversionServiceFactoryBean.notebookService;
    
    public Converter<Note, String> ApplicationConversionServiceFactoryBean.getNoteToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ah.roomongo.shortnotes.domain.Note, java.lang.String>() {
            public String convert(Note note) {
                return new StringBuilder().append(note.getTitle()).append(' ').append(note.getContent()).append(' ').append(note.getCreated()).toString();
            }
        };
    }
    
    public Converter<BigInteger, Note> ApplicationConversionServiceFactoryBean.getIdToNoteConverter() {
        return new org.springframework.core.convert.converter.Converter<java.math.BigInteger, ah.roomongo.shortnotes.domain.Note>() {
            public ah.roomongo.shortnotes.domain.Note convert(java.math.BigInteger id) {
                return noteService.findNote(id);
            }
        };
    }
    
    public Converter<String, Note> ApplicationConversionServiceFactoryBean.getStringToNoteConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, ah.roomongo.shortnotes.domain.Note>() {
            public ah.roomongo.shortnotes.domain.Note convert(String id) {
                return getObject().convert(getObject().convert(id, BigInteger.class), Note.class);
            }
        };
    }
    
    public Converter<Notebook, String> ApplicationConversionServiceFactoryBean.getNotebookToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ah.roomongo.shortnotes.domain.Notebook, java.lang.String>() {
            public String convert(Notebook notebook) {
                return new StringBuilder().append(notebook.getName()).append(' ').append(notebook.getAuthor()).append(' ').append(notebook.getCreated()).toString();
            }
        };
    }
    
    public Converter<BigInteger, Notebook> ApplicationConversionServiceFactoryBean.getIdToNotebookConverter() {
        return new org.springframework.core.convert.converter.Converter<java.math.BigInteger, ah.roomongo.shortnotes.domain.Notebook>() {
            public ah.roomongo.shortnotes.domain.Notebook convert(java.math.BigInteger id) {
                return notebookService.findNotebook(id);
            }
        };
    }
    
    public Converter<String, Notebook> ApplicationConversionServiceFactoryBean.getStringToNotebookConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, ah.roomongo.shortnotes.domain.Notebook>() {
            public ah.roomongo.shortnotes.domain.Notebook convert(String id) {
                return getObject().convert(getObject().convert(id, BigInteger.class), Notebook.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getNoteToStringConverter());
        registry.addConverter(getIdToNoteConverter());
        registry.addConverter(getStringToNoteConverter());
        registry.addConverter(getNotebookToStringConverter());
        registry.addConverter(getIdToNotebookConverter());
        registry.addConverter(getStringToNotebookConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}