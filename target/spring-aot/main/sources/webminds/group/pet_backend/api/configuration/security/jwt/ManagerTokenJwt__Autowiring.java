package webminds.group.pet_backend.api.configuration.security.jwt;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ManagerTokenJwt}.
 */
public class ManagerTokenJwt__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ManagerTokenJwt apply(RegisteredBean registeredBean, ManagerTokenJwt instance) {
    AutowiredFieldValueResolver.forRequiredField("secret").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("jwtTokenValidity").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
