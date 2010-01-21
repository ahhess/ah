package foo.bar.ui.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.istec.pls.base.StatusMessageListener;
import com.istec.pls.base.guice.ProxyFactoryModule;
import com.istec.pls.base.guice.tx.TxDataSourceModule;
import com.istec.pls.base.guice.web.AbstractWebBootstrap;
import com.istec.pls.base.guice.web.UserProviderModule;


/**
 * Bootstrap für das PLS Standard GUI.
 * 
 * Der "Bootstrap" Listener ist für die Initialisierung der Guice/Spring
 * Maschinerie für deklarative Transaktionen in Web-Anwendungen erforderlich.
 * 
 * Er benötigt den Kontextparameter "Bootstrap.DataSource.JndiName", der den
 * JNDI Namen der zu verwendenden DataSource enthalten muss.
 */
public class PlsBootstrap extends AbstractWebBootstrap {

	private static final String BOOTSTRAPPER = PlsBootstrap.class.getSimpleName();

	private final Log logger = LogFactory.getLog(PlsBootstrap.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure() {
		logger.info("About to start config sequence for " + BOOTSTRAPPER);

		install(new TxDataSourceModule(getDataSource()));
//		install(new StandardServletModule());
		install(new UserProviderModule());
		install(new ProxyFactoryModule());

		logger.info("Completed config sequence for " + BOOTSTRAPPER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void postConfigure() {
		logger.info("Entering postConfigure step for " + BOOTSTRAPPER);

		StatusMessageListener.start();
		logger.info("Started " + StatusMessageListener.class.getSimpleName());

		logger.info("Finished postConfigure step for " + BOOTSTRAPPER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onShutdown() {
		logger.info("Initiating shutdown of " + BOOTSTRAPPER);

		StatusMessageListener.stop();
		logger.info("Stopped " + StatusMessageListener.class.getSimpleName());

		logger.info("Completed shutdown of " + BOOTSTRAPPER);
	}
}
