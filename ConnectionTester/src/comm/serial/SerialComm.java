package comm.serial;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import jssc.SerialPort;

import comm.IComm;

public class SerialComm implements IComm {

	private SerialPort serialPort;
	private String encoding = System.getProperty("file.encoding");
	private boolean isConnected = false;

	@Override
	public void connect(Properties properties) throws Exception {

		if (properties == null)
			properties = new Properties();

		String port = properties.getProperty("port", "COM1");
		if ("".equals(port))
			port = "COM1";
		int baudrate = Integer.parseInt(properties.getProperty("baudrate",
				"9600"));
		int databits = Integer
				.parseInt(properties.getProperty("databits", "8"));
		int stopbits = Integer
				.parseInt(properties.getProperty("stopbits", "1"));
		int parity = Integer.parseInt(properties.getProperty("parity", "0"));
		encoding = properties.getProperty("encoding", "ASCII");

		System.out.println("opening port " + port);

		serialPort = new SerialPort(port);
		serialPort.openPort();
		// serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8,
		// SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		serialPort.setParams(baudrate, databits, stopbits, parity);
		isConnected = true;
	}

	@Override
	public void disconnect() throws Exception {
		serialPort.closePort();
		isConnected = false;
	}

	@Override
	public byte[] read() throws Exception {
		ByteArrayOutputStream buf = new ByteArrayOutputStream(); 
		byte[] b = serialPort.readBytes(1);
		while (b[0] != 13) {
			buf.write(b);
			b = serialPort.readBytes(1);
		}
		return buf.toByteArray();
	}

	@Override
	public String readln() throws Exception {
//		return read().toString();
		
		String s = "";
		StringBuffer sb = new StringBuffer();
		while (!"\r".equals(s)) {
			s = serialPort.readString(1);
			sb.append(s);
		}
		return sb.toString();
	}

	@Override
	public void write(byte[] bytes) throws Exception {
		serialPort.writeBytes(bytes);
	}

	/** special write line with explicit charset encoding and trailing CRLF */
	@Override
	public void writeln(String string) throws Exception {
		String text = string + "\r\n";
		write(text.getBytes(encoding));
	}

	@Override
	public boolean isConnected() {
		return isConnected;
	}

//	public void setConnected(boolean isConnected) {
//		this.isConnected = isConnected;
//	}

}
