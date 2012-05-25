package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import comm.CommFactory;
import comm.IComm;

public class Form extends JFrame {

	private JPanel contentPane;
	private JPanel hauptPanel = new JPanel();
	private JTextArea logTextArea = new JTextArea();
	private JScrollPane scrollPane;
	private JTextField inputLine;
	private JRadioButton jRadioButtonSerial = new JRadioButton("Seriell");
	private JRadioButton jRadioButtonSocket = new JRadioButton("Socket");
	private JRadioButton jRadioButtonServerSocket = new JRadioButton(
			"ServerSocket");
	private JTextField jTextFieldPort;
	private JTextField jTextFieldHost;
	private JButton connectButton;

	private IComm comm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Form() {
		createFrame();
	}

	/**
	 * Create the frame.
	 */
	private void createFrame() {

		setTitle("Connection Tester");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		hauptPanel.setLayout(new GridLayout());
		hauptPanel.add(logTextArea);
		logTextArea.setEditable(false);
		scrollPane = new JScrollPane(hauptPanel);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel topPanel = new JPanel(new FlowLayout());
		contentPane.add(topPanel, BorderLayout.NORTH);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButtonSerial);
		buttonGroup.add(jRadioButtonSocket);
		buttonGroup.add(jRadioButtonServerSocket);
		jRadioButtonSerial.setSelected(true);
		jRadioButtonSerial.setActionCommand(CommFactory.SERIAL);
		jRadioButtonSocket.setActionCommand(CommFactory.SOCKET);
		jRadioButtonServerSocket.setActionCommand(CommFactory.SERVERSOCKET);

		//TODO
		jRadioButtonSocket.setEnabled(false);
		jRadioButtonServerSocket.setEnabled(false);

		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
		radioPanel.add(jRadioButtonSerial);
		radioPanel.add(jRadioButtonSocket);
		radioPanel.add(jRadioButtonServerSocket);
		topPanel.add(radioPanel);

		topPanel.add(new JLabel("Host:"));
		jTextFieldHost = new JTextField();
		jTextFieldHost.setPreferredSize(new Dimension(120, 18));
		topPanel.add(jTextFieldHost);

		topPanel.add(new JLabel("Port:"));
		jTextFieldPort = new JTextField();
		jTextFieldPort.setPreferredSize(new Dimension(40, 18));
		topPanel.add(jTextFieldPort);

		connectButton = new JButton(getButtonLabel());
		topPanel.add(connectButton);
		connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connectButtonActionPerformed();
			}
		});

		inputLine = new JTextField();
		contentPane.add(inputLine, BorderLayout.SOUTH);

		inputLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputLineActionPerformed();
			}
		});
	}

	private JRadioButton getConnectTypeButton() {
		if (jRadioButtonSerial.isSelected())
			return jRadioButtonSerial;
		if (jRadioButtonSocket.isSelected())
			return jRadioButtonSocket;
		if (jRadioButtonServerSocket.isSelected())
			return jRadioButtonServerSocket;
		return null;
	}

	private void connectButtonActionPerformed() {
		if (isConnected())
			disconnect();
		else
			connect();
	}

	private void inputLineActionPerformed() {
		String input = inputLine.getText().trim();
		if (!input.equals("")) {
			if (isConnected()) {
				write(input);
				read();
			} else
				log("not connected, input=" + input);
		}
		inputLine.selectAll();
		inputLine.replaceSelection("");
	}

	private void log(String text) {
		logTextArea.append(text);
		logTextArea.append("\r\n");
	}

	private void connect() {
		try {
			String typeName = getConnectTypeButton().getActionCommand();
			log("connect " + typeName);
			Properties p = new Properties();
			p.setProperty("port", jTextFieldPort.getText());
			comm = CommFactory.getComm(typeName);
			comm.connect(p);
			connectButton.setText(getButtonLabel());
			log("connected.");
		} catch (Exception e) {
			log(e.toString());
		}
	}

	private void write(String text) {
		try {
			comm.writeln(text);
		} catch (Exception e) {
			log(e.toString());
		}

	}

	private void read() {
		try {
			log(comm.readln());
		} catch (Exception e) {
			log(e.toString());
		}
	}

	private void disconnect() {
		try {
			comm.disconnect();
			connectButton.setText(getButtonLabel());
			log("disconnected.");
		} catch (Exception e) {
			log(e.toString());
		}
	}

	private boolean isConnected() {
		if (comm == null)
			return false;
		return comm.isConnected();
	}

	private String getButtonLabel() {
		return isConnected() ? "Disconnect" : "Connect";
	}

}