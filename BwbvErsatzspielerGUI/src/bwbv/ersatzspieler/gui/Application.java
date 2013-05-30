package bwbv.ersatzspieler.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import bwbv.ersatzspielercheck.ErsatzspielerCheck;
import bwbv.ersatzspielercheck.SpielerMap;
import bwbv.ersatzspielercheck.model.Spieler;
import bwbv.ersatzspielercheck.model.Verein;
import javax.swing.JFileChooser;

/**
 * BWBV Ersatzpieler Application and Main Frame
 * 
 * @author Andy
 */
public class Application extends javax.swing.JFrame {

	private static final String SPT[] = { "SpT1", "SpT2", "SpT3", "SpT4",
			"SpT4a", "SpT5", "SpT6", "SpT7", "SpT8", "SpT8a" };
	private static final Logger logger = Logger.getLogger(Application.class
			.getName());
	private static String cfg = "../bwbvErsatzspieler/data/ErsatzspielerCheck.properties";

	private ErsatzspielerCheck ec;
	private VereinModel vereinModel = new VereinModel();
	private VereinsspielerModel vereinsspielerModel = new VereinsspielerModel();
	private SpielerModel spielerModel1 = new SpielerModel();
	private DefaultTableModel spieltagModel = new DefaultTableModel();
	private Verein vereinSelected;

	public Application() throws Exception {
		ec = new ErsatzspielerCheck();
		initComponents();
		performEcInit(cfg);
		performEcCheck();
		configFilename.setText(cfg);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSpieler = new javax.swing.ButtonGroup();
        buttonGroupVereinsspieler = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        configFilename = new javax.swing.JTextField();
        configButton = new javax.swing.JButton();
        checkButton = new javax.swing.JButton();
        browseButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        rbFalscheinsatz1 = new javax.swing.JRadioButton();
        rbFestgespielte1 = new javax.swing.JRadioButton();
        rbErsatzspieler1 = new javax.swing.JRadioButton();
        jScrollPaneSpielerTable = new javax.swing.JScrollPane();
        spielerTable = new javax.swing.JTable();
        jSplitPaneVereine = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPaneVereinTable = new javax.swing.JScrollPane();
        vereinTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbSpieler = new javax.swing.JRadioButton();
        rbErsatzspieler = new javax.swing.JRadioButton();
        rbFestgespielte = new javax.swing.JRadioButton();
        rbFalscheinsatz = new javax.swing.JRadioButton();
        jScrollPaneVereinsspielerTable = new javax.swing.JScrollPane();
        vereinsspielerTable = new javax.swing.JTable();
        jScrollPaneSpieltage = new javax.swing.JScrollPane();
        spieltagTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        msgTextPane = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Konfig-Datei:");

        configButton.setText("Init");
        configButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configButtonActionPerformed(evt);
            }
        });

        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        browseButton.setText("Durchsuchen...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configFilename)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(browseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkButton)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(configFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(configButton)
                    .addComponent(checkButton)
                    .addComponent(browseButton))
                .addContainerGap())
        );

        buttonGroupSpieler.add(rbFalscheinsatz1);
        rbFalscheinsatz1.setSelected(true);
        rbFalscheinsatz1.setText("Falscheinsatz");
        rbFalscheinsatz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFalscheinsatz1ActionPerformed(evt);
            }
        });

        buttonGroupSpieler.add(rbFestgespielte1);
        rbFestgespielte1.setText("Festgespielte");
        rbFestgespielte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFestgespielte1ActionPerformed(evt);
            }
        });

        buttonGroupSpieler.add(rbErsatzspieler1);
        rbErsatzspieler1.setText("Ersatzspieler");
        rbErsatzspieler1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbErsatzspieler1ActionPerformed(evt);
            }
        });

        spielerTable.setAutoCreateRowSorter(true);
        spielerTable.setModel(spielerModel1);
        jScrollPaneSpielerTable.setViewportView(spielerTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneSpielerTable, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbFalscheinsatz1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbFestgespielte1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbErsatzspieler1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFestgespielte1)
                    .addComponent(rbFalscheinsatz1)
                    .addComponent(rbErsatzspieler1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSpielerTable, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Spieler", jPanel4);

        jPanel2.setPreferredSize(new java.awt.Dimension(250, 430));

        jLabel2.setText("Vereine");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        vereinTable.setAutoCreateRowSorter(true);
        vereinTable.setModel(vereinModel);
        vereinTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        vereinTable.getSelectionModel().addListSelectionListener(new VereinSelectionListener());
        vereinTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        vereinTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        jScrollPaneVereinTable.setViewportView(vereinTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneVereinTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneVereinTable, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
        );

        jSplitPaneVereine.setLeftComponent(jPanel2);

        buttonGroupVereinsspieler.add(rbSpieler);
        rbSpieler.setText("Spieler");
        rbSpieler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSpielerActionPerformed(evt);
            }
        });

        buttonGroupVereinsspieler.add(rbErsatzspieler);
        rbErsatzspieler.setText("Ersatzspieler");
        rbErsatzspieler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbErsatzspielerActionPerformed(evt);
            }
        });

        buttonGroupVereinsspieler.add(rbFestgespielte);
        rbFestgespielte.setSelected(true);
        rbFestgespielte.setText("Festgespielte");
        rbFestgespielte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFestgespielteActionPerformed(evt);
            }
        });

        buttonGroupVereinsspieler.add(rbFalscheinsatz);
        rbFalscheinsatz.setText("Falscheinsatz");
        rbFalscheinsatz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFalscheinsatzActionPerformed(evt);
            }
        });

        vereinsspielerTable.setAutoCreateRowSorter(true);
        vereinsspielerTable.setModel(vereinsspielerModel);
        vereinsspielerTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        vereinsspielerTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        jScrollPaneVereinsspielerTable.setViewportView(vereinsspielerTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rbSpieler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbErsatzspieler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbFestgespielte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFalscheinsatz)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPaneVereinsspielerTable, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSpieler)
                    .addComponent(rbErsatzspieler)
                    .addComponent(rbFestgespielte)
                    .addComponent(rbFalscheinsatz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneVereinsspielerTable, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
        );

        jSplitPaneVereine.setRightComponent(jPanel3);

        jTabbedPane1.addTab("Vereine", jSplitPaneVereine);

        spieltagTable.setModel(spieltagModel);
        spieltagTable.setColumnSelectionAllowed(true);
        jScrollPaneSpieltage.setViewportView(spieltagTable);
        spieltagTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTabbedPane1.addTab("Spieltage", jScrollPaneSpieltage);

        msgTextPane.setEditable(false);
        msgTextPane.setText(msgBuffer);
        jScrollPane2.setViewportView(msgTextPane);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}// GEN-LAST:event_exitMenuItemActionPerformed

	private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkButtonActionPerformed
		performEcCheck();
	}// GEN-LAST:event_checkButtonActionPerformed

	private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser chooser = new JFileChooser(configFilename.getText());
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION)
            configFilename.setText(chooser.getSelectedFile().getAbsolutePath());
	}// GEN-LAST:event_browseButtonActionPerformed

	private void configButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_configButtonActionPerformed
		performEcInit(configFilename.getText());
	}// GEN-LAST:event_configButtonActionPerformed

	private void rbSpielerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbSpielerActionPerformed
		showSpieler(vereinSelected);
	}// GEN-LAST:event_rbSpielerActionPerformed

	private void rbFestgespielteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbFestgespielteActionPerformed
		showSpieler(vereinSelected);
	}// GEN-LAST:event_rbFestgespielteActionPerformed

	private void rbErsatzspielerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbErsatzspielerActionPerformed
		showSpieler(vereinSelected);
	}// GEN-LAST:event_rbErsatzspielerActionPerformed

	private void rbFalscheinsatzActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbFalscheinsatzActionPerformed
		showSpieler(vereinSelected);
	}// GEN-LAST:event_rbFalscheinsatzActionPerformed

	private void rbErsatzspieler1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbErsatzspieler1ActionPerformed
		showSpieler();
	}// GEN-LAST:event_rbErsatzspieler1ActionPerformed

	private void rbFestgespielte1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbFestgespielte1ActionPerformed
		showSpieler();
	}// GEN-LAST:event_rbFestgespielte1ActionPerformed

	private void rbFalscheinsatz1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbFalscheinsatz1ActionPerformed
		showSpieler();
	}// GEN-LAST:event_rbFalscheinsatz1ActionPerformed

	// /////////////////////////////////////////

	private void performEcInit(String configFilename) {
		try {
			ec.init(new String[] { configFilename });
			showSpieltage();
		} catch (Exception ex) {
			addMsg(ex.toString());
		}
	}

	private void performEcCheck() {
		try {
			ec.processEinsaetze();
			ec.checkErsatzspieler();
			showVereine();
			showSpieler();
		} catch (Exception ex) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE,
					null, ex);
			addMsg(ex.toString());
		}
	}

	private void showVereine() {
		if (ec.getSpielerMap() != null) {
			vereinModel.setVereine(ec.getSpielerMap().getVereine());
		}
	}

	private void showSpieler() {
		if (ec.getSpielerMap() != null) {
			if (rbErsatzspieler1.isSelected())
				spielerModel1.setSpielerMap(ec.getErsatzspielerMap());
			else if (rbFalscheinsatz1.isSelected())
				spielerModel1.setSpielerList(ec.getFalschspieler());
			else
				spielerModel1.setSpielerList(ec.getFestgespielt());
			spielerTable.tableChanged(null);
		}
	}

	private void showSpieler(Verein verein) {
		if (verein != null) {
			vereinSelected = verein;
		}
		if (vereinSelected != null) {
			if (rbErsatzspieler.isSelected())
				vereinsspielerModel.setSpielerMap(vereinSelected
						.getErsatzspielerMap());
			else if (rbFalscheinsatz.isSelected())
				vereinsspielerModel.setSpielerList(vereinSelected
						.getFalschspieler());
			else if (rbFestgespielte.isSelected())
				vereinsspielerModel.setSpielerList(vereinSelected
						.getFestgespielt());
			else
				vereinsspielerModel.setSpielerMap(vereinSelected
						.getSpielerMap());
			vereinsspielerTable.tableChanged(null);
		}
	}

	private String msgBuffer = "";

	private void addMsg(String msg) {
		msgBuffer += msg + "\n";
		msgTextPane.setText(msgBuffer);
	}

	private void showSpieltage() {
		if (ec != null && ec.getSpieltage() != null) {
			int size = ec.getSpieltage().size();
			Object[][] spieltage = new String[size][2];
			int i = 0;
			for (Map.Entry<Object, Object> entry : ec.getSpieltage().entrySet()) {
				spieltage[i][0] = entry.getKey();
				spieltage[i][1] = entry.getValue();
				i++;
			}
			spieltagModel = new DefaultTableModel(spieltage, new String[] {
					"Datum", "SpT Nr." });
			spieltagTable.setModel(spieltagModel);
		}
	}

	private class VereinModel extends AbstractTableModel {
		List<Verein> list = null;

		public void setVereine(HashMap<String, Verein> vereineMap) {
			list = new ArrayList<Verein>(vereineMap.values());
			// Collections.sort(list);
		}

		@Override
		public int getRowCount() {
			return list == null ? 0 : list.size();
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0)
				return "Nr.";
			else
				return "Name";
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0)
				return list.get(rowIndex).getNummer();
			else
				return list.get(rowIndex).getName();
		}

		public Verein getVerein(int rowIndex) {
			return list.get(rowIndex);
		}
	}

	private class VereinSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				showSpieler(vereinModel.getVerein(vereinTable
						.convertRowIndexToModel(vereinTable.getSelectedRow())));
			}
		}
	}

	private class VereinsspielerModel extends AbstractTableModel {

        protected List<Spieler> list = null;

		public void setSpielerList(List spielerList) {
			list = spielerList;
		}

		public void setSpielerMap(SpielerMap spielerMap) {
			list = new ArrayList<Spieler>(spielerMap.values());
		}

		@Override
		public int getRowCount() {
			return list == null ? 0 : list.size();
		}

		@Override
		public int getColumnCount() {
			return 16;
		}
        
		@Override
		public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Name";
                case 1:
                    return "Vorname";
                case 2:
                    return "Pos.VR";
                case 3:
                    return "Pos.RR";
                case 4:
                    return "M.VR";
                case 5:
                    return "M.RR";
            }
			return SPT[columnIndex - 6];
			// return "SpT" + String.valueOf(columnIndex - 5);
		}

        public Class getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 2:
                case 3:
                case 4:
                case 5:
                    return Integer.class;
            }
            return String.class;
        }

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Spieler s = list.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return s.getNachname();
			case 1:
				return s.getVorname();
			case 2:
				return s.getRangVR();
			case 3:
				return s.getRangRR();
			case 4:
				return s.getStammMannschaftVR();
			case 5:
				return s.getStammMannschaftRR();
			}
			if (columnIndex < 16) {
				return "" + s.getMannschaftseinsatz()[columnIndex - 6][0] + "-"
						+ s.getMannschaftseinsatz()[columnIndex - 6][1];
			}

			return null;
		}

		public Spieler getSpieler(int rowIndex) {
			return list.get(rowIndex);
		}
	}

	/**
	 * Vereinsspieler + vorangestellter VereinsnameVR + VereinsnameRR
	 */
	private class SpielerModel extends VereinsspielerModel {

		@Override
		public int getColumnCount() {
			return super.getColumnCount() + 2;
		}

		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0)
				return "Verein VR";
			else if (columnIndex == 1)
				return "Verein RR";
			return super.getColumnName(columnIndex - 2);
		}
        
		@Override
		public Class getColumnClass(int columnIndex) {
			if (columnIndex <=1)
				return String.class;
			return super.getColumnClass(columnIndex - 2);
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				Spieler s = list.get(rowIndex);
				return s.getVereinVR() == null ? "" : s.getVereinVR().getName();
			} else if (columnIndex == 1) {
				Spieler s = list.get(rowIndex);
				return s.getVereinRR() == null ? "" : s.getVereinRR().getName();
			}
			return super.getValueAt(rowIndex, columnIndex - 2);
		}
	}

	public static void main(String args[]) {

		if (args.length > 0)
			cfg = args[0];

		if (System.getProperty("java.util.logging.properties") == null)
			System.setProperty("java.util.logging.properties",
					"logging.properties");

		/*
		 * Set the Nimbus look and feel
		 */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(Application.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Application app = new Application();
                    // TODo maximize
					app.setVisible(true);
				} catch (Exception ex) {
					Logger.getLogger(Application.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton browseButton;
    private javax.swing.ButtonGroup buttonGroupSpieler;
    private javax.swing.ButtonGroup buttonGroupVereinsspieler;
    private javax.swing.JButton checkButton;
    private javax.swing.JButton configButton;
    private javax.swing.JTextField configFilename;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneSpielerTable;
    private javax.swing.JScrollPane jScrollPaneSpieltage;
    private javax.swing.JScrollPane jScrollPaneVereinTable;
    private javax.swing.JScrollPane jScrollPaneVereinsspielerTable;
    private javax.swing.JSplitPane jSplitPaneVereine;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextPane msgTextPane;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JRadioButton rbErsatzspieler;
    private javax.swing.JRadioButton rbErsatzspieler1;
    private javax.swing.JRadioButton rbFalscheinsatz;
    private javax.swing.JRadioButton rbFalscheinsatz1;
    private javax.swing.JRadioButton rbFestgespielte;
    private javax.swing.JRadioButton rbFestgespielte1;
    private javax.swing.JRadioButton rbSpieler;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JTable spielerTable;
    private javax.swing.JTable spieltagTable;
    private javax.swing.JTable vereinTable;
    private javax.swing.JTable vereinsspielerTable;
    // End of variables declaration//GEN-END:variables
}
