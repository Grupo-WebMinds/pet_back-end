package webminds.group.pet_backend.api.configuration.security;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SecurityConfiguration}.
 */
public class SecurityConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SecurityConfiguration apply(RegisteredBean registeredBean,
      SecurityConfiguration instance) {
    AutowiredFieldValueResolver.forRequiredField("authenticationUserService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("authenticationUserEntryPoint").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
