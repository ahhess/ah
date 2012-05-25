package comm;

import java.util.Properties;

public interface IComm {

	void connect(Properties properties) throws Exception;
	void disconnect() throws Exception;
	byte[] read() throws Exception;
	void write(byte[] bytes) throws Exception;
	void writeln(String string) throws Exception;
	String readln() throws Exception;
	public abstract boolean isConnected();
	
}
