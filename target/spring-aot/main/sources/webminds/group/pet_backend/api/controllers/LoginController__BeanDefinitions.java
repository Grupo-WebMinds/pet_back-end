package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.user.client.UserService;

/**
 * Bean definitions for {@link LoginController}.
 */
public class LoginController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'loginController'.
   */
  private static BeanInstanceSupplier<LoginController> getLoginControllerInstanceSupplier() {
    return BeanInstanceSupplier.<LoginController>forConstructor(UserService.class)
            .withGenerator((registeredBean, args) -> new LoginController(args.get(0)));
  }

  /**
   * Get the bean definition for 'loginController'.
   */
  public static BeanDefinition getLoginControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LoginController.class);
    beanDefinition.setInstanceSupplier(getLoginControllerInstanceSupplier());
    return beanDefinition;
  }
}
