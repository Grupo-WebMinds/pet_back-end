package webminds.group.pet_backend.services.user.client;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import webminds.group.pet_backend.api.configuration.security.jwt.ManagerTokenJwt;
import webminds.group.pet_backend.domain.user.repositories.AuthUserRepository;

/**
 * Bean definitions for {@link UserService}.
 */
public class UserService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userService'.
   */
  private static BeanInstanceSupplier<UserService> getUserServiceInstanceSupplier() {
    return BeanInstanceSupplier.<UserService>forConstructor(PasswordEncoder.class, AuthUserRepository.class, ManagerTokenJwt.class, AuthenticationManager.class)
            .withGenerator((registeredBean, args) -> new UserService(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'userService'.
   */
  public static BeanDefinition getUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserService.class);
    beanDefinition.setInstanceSupplier(getUserServiceInstanceSupplier());
    return beanDefinition;
  }
}
