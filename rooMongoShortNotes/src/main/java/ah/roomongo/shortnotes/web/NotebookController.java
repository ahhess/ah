package ah.roomongo.shortnotes.web;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ah.roomongo.shortnotes.domain.Notebook;
import ah.roomongo.shortnotes.service.NoteService;

@RequestMapping("/notebooks")
@Controller
@RooWebScaffold(path = "notebooks", formBackingObject = Notebook.class)
public class NotebookController {
}
