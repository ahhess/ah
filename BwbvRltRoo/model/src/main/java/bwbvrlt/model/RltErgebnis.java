package bwbvrlt.model;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class RltErgebnis {

    @NotNull
    @Size(max = 4)
    private String disz;

    @NotNull
    private int platz;

    @Value("0.0")
    private double punkte;

    @NotNull
    @ManyToOne
    private RltSpieler rltSpieler;

    @NotNull
    @ManyToOne
    private Rlt rlt;
}
