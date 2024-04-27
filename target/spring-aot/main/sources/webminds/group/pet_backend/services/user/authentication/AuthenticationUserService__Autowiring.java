package webminds.group.pet_backend.services.user.authentication;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AuthenticationUserService}.
 */
public class AuthenticationUserService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AuthenticationUserService apply(RegisteredBean registeredBean,
      AuthenticationUserService instance) {
    AutowiredFieldValueResolver.forRequiredField("authUserRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
