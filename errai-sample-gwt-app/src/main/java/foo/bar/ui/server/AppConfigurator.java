package foo.bar.ui.server;

import com.google.inject.Provider;
import org.jboss.errai.bus.server.annotations.ExtensionComponent;
import org.jboss.errai.bus.server.ext.ErraiConfigExtension;

import java.util.Map;

/**
 * Create a config extension class so we can do things like setup the default tables
 * when the application is deployed, etc.
 */
@ExtensionComponent
public class AppConfigurator implements ErraiConfigExtension
{
  public void configure(Map<Class, Provider> bindings, Map<String, Provider> resourceProviders)
  {
    // provide extension points here
  }
}
