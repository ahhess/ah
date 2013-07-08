// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ah.roomongo.shortnotes.service;

import ah.roomongo.shortnotes.domain.Notebook;
import ah.roomongo.shortnotes.service.NotebookService;
import java.math.BigInteger;
import java.util.List;

privileged aspect NotebookService_Roo_Service {
    
    public abstract long NotebookService.countAllNotebooks();    
    public abstract void NotebookService.deleteNotebook(Notebook notebook);    
    public abstract Notebook NotebookService.findNotebook(BigInteger id);    
    public abstract List<Notebook> NotebookService.findAllNotebooks();    
    public abstract List<Notebook> NotebookService.findNotebookEntries(int firstResult, int maxResults);    
    public abstract void NotebookService.saveNotebook(Notebook notebook);    
    public abstract Notebook NotebookService.updateNotebook(Notebook notebook);    
}
