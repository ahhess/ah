package aufzug1.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import aufzug1.model.AufzugController;
import aufzug1.model.AufzugData;
import aufzug1.model.Beobachter;
import aufzug1.model.Etage;

/**
 *
 * @author Andy
 */
public class MainFrame extends javax.swing.JFrame {

    private AufzugController controller;
    private AufzugData aufzugData;
    
    private JPanel aufzugPanel;
    private JPanel aussenPanel;
    private JLabel jLabel1;
    
    private class EtagenBeobachter implements Beobachter {

    	private JButton button;
    	private Etage etage;
    	private Color defaultBg;
    	
    	public EtagenBeobachter(JButton b, Etage e) {
    		button = b;
    		defaultBg = button.getBackground();
    		etage = e;
//    		e.registriere(this);
		}
    	
		@Override
		public void aktualisiere() {
			if (etage.isAngefordert())
				button.setBackground(Color.WHITE);
			else 
				button.setBackground(defaultBg);
		}
    	
    }
    private ArrayList<EtagenBeobachter> etagenBeobachters = new ArrayList<EtagenBeobachter>();
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame(AufzugController controller) {        
        this.controller = controller;
//        initComponents();
        initComponents2();
    }
        
    private void initComponents2() {
        aufzugData = controller.getData();
        int anzahlEtagen = aufzugData.getAnzahlEtagen();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        aufzugPanel = new JPanel();
        aufzugPanel.setLayout(new GridLayout(anzahlEtagen+1, 1));

        jLabel1 = new JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText(String.valueOf(aufzugData.getAktuelleEtagennr()));
        aufzugPanel.add(jLabel1);

        aussenPanel = new JPanel();
        aussenPanel.setLayout(new GridLayout(anzahlEtagen+1, 1));
        aussenPanel.add(new JLabel(""));
        
        for (int i = anzahlEtagen-1; i>=0; i--) {
            Etage etage = aufzugData.getEtage(i);
            JButton b = newEtagenButton(etage);
//            etagenBeobachters.add(new EtagenBeobachter(b, etage));
            etage.registriere(new EtagenBeobachter(b, etage));
            aufzugPanel.add(b);

            b = newEtagenButton(etage);
//            etagenBeobachters.add(new EtagenBeobachter(b, etage));
            etage.registriere(new EtagenBeobachter(b, etage));
            aussenPanel.add(b);
        }

        getContentPane().add(aufzugPanel);
        getContentPane().add(aussenPanel);

        pack();
    }

    private JButton newEtagenButton(final Etage etage){
        JButton jButton = new JButton(etage.getLabel());
        jButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                etage.setAngefordert(true);
            	controller.fordereAufzugAnFuerEtage(etage);
            }
        });
        return jButton;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
