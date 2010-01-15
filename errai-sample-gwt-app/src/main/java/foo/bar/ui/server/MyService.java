package foo.bar.ui.server;

import org.jboss.errai.bus.server.annotations.Endpoint;
import org.jboss.errai.bus.server.annotations.Service;

@Service
public class MyService {

	@Endpoint
	public String hello(String msg) {
		return "Hello from MyService.hello(" + msg + ")";	
	}
}
