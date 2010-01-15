package foo.bar.ui.server;

import java.util.ArrayList;

import org.jboss.errai.bus.server.annotations.Endpoint;
import org.jboss.errai.bus.server.annotations.Service;

import com.istec.pls.base.PlsBaseService;
import com.istec.pls.base.domain.Workplace;
import com.istec.pls.base.guice.ProxyFactory;
import com.istec.pls.base.log.Logger;
import com.istec.pls.base.log.LoggerFactory;

@Service
public class MyService {

	private final Logger logger = LoggerFactory.getLogger(MyService.class);

	@Endpoint
	public String hello(String msg) {
		return "Hello from MyService.hello(" + msg + ")";	
	}
	
	/**
	 * Arbeitsplätze holen
	 */
	@Endpoint
	public ArrayList<Workplace> getArbeitsplaetze() {
			logger.enter();
			PlsBaseService baseService = ProxyFactory
					.create(PlsBaseService.class);
			ArrayList<Workplace> list = baseService.getArbeitsplaetze("10");
			logger.exit();
			return list;
	}
}
