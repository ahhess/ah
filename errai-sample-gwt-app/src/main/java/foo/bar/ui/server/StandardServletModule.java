package foo.bar.ui.server;

import com.google.inject.servlet.ServletModule;


/**
 * Dieses Modul initialisiert die Guice-Servlet Request und Session Scopes,
 * die Voraussetzung für die UserToken Injection sind.
 *
 * Hier können die Servlets für das PLS Basis-GUI registriert und gemappt werden.
 * Eine alternative bzw. additive Konfiguration über die web.xml ist möglich.
 *
 * Achtung: alle Servlets oder Filter die hier programmatisch registriert werden
 * müssen entweder mit {@literal @}Singleton annotiert sein oder explizit als
 * Singleton gebunden (siehe GWTEventService) werden!
 * Vgl.: http://code.google.com/p/google-guice/wiki/ServletModule
 */
public class StandardServletModule extends ServletModule {

	// Wahrscheinlich brauchen wir ab GWT 1.6 an dieser Stelle stattdessen "/Modulname"
	private final String myModulePath = "";

	/**
	 * Dies ist der Callback, der von Guice aufgerufen wird
	 * (sozusagen der Einstieg in dieses Modul).
	 */
	@Override
	protected void configureServlets() {
		doRegistration(myModulePath);
	}

	/**
	 * Abgeleitete fachliche Module müssen diese Methode im {@link #configureServlets()}
	 * Aufruf mit ihrem eigenen Modulpfad aufrufen damit die Servlets des Basis GUI
	 * registriert werden.
	 * @param modulePath ModulPfad des abgeleiteten (fachlichen) Servlet Moduls.
	 */
	protected void configureServlets(final String modulePath) {
		doRegistration(modulePath);
	}

	private void doRegistration(final String modulePath) {
		// 1) BaseRpcService Servlet registrieren (ist bereits mit @Singletom annotiert)
//		serve(modulePath + "/baseRpcService").with(BaseRpcServiceImpl.class);

		// 2) UrmRpcService Servlet registrieren (ist bereits mit @Singletom annotiert)
//		serve(modulePath + "/urmRpcService").with(UrmRpcServiceImpl.class);

		// 3a) GWTEventService Servlet als Singleton binden
//		bind(EventServiceImpl.class).in(Scopes.SINGLETON);
		// 3b) GWTEventService Servlet registrieren
//		serve(modulePath + "/gwteventservice").with(EventServiceImpl.class);
	}
}
