package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.user.client.UserService;

/**
 * Bean definitions for {@link UserController}.
 */
public class UserController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userController'.
   */
  private static BeanInstanceSupplier<UserController> getUserControllerInstanceSupplier() {
    return BeanInstanceSupplier.<UserController>forConstructor(UserService.class)
            .withGenerator((registeredBean, args) -> new UserController(args.get(0)));
  }

  /**
   * Get the bean definition for 'userController'.
   */
  public static BeanDefinition getUserControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserController.class);
    beanDefinition.setInstanceSupplier(getUserControllerInstanceSupplier());
    return beanDefinition;
  }
}
