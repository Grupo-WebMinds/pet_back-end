package webminds.group.pet_backend.api.configuration.security;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthenticationUserEntryPoint}.
 */
public class AuthenticationUserEntryPoint__BeanDefinitions {
  /**
   * Get the bean definition for 'authenticationUserEntryPoint'.
   */
  public static BeanDefinition getAuthenticationUserEntryPointBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationUserEntryPoint.class);
    beanDefinition.setInstanceSupplier(AuthenticationUserEntryPoint::new);
    return beanDefinition;
  }
}
