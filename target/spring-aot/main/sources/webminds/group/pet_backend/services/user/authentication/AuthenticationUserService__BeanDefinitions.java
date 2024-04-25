package webminds.group.pet_backend.services.user.authentication;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthenticationUserService}.
 */
public class AuthenticationUserService__BeanDefinitions {
  /**
   * Get the bean definition for 'authenticationUserService'.
   */
  public static BeanDefinition getAuthenticationUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationUserService.class);
    InstanceSupplier<AuthenticationUserService> instanceSupplier = InstanceSupplier.using(AuthenticationUserService::new);
    instanceSupplier = instanceSupplier.andThen(AuthenticationUserService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
