package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.user.client.UserService;

/**
 * Bean definitions for {@link PetShopController}.
 */
public class PetShopController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'petShopController'.
   */
  private static BeanInstanceSupplier<PetShopController> getPetShopControllerInstanceSupplier() {
    return BeanInstanceSupplier.<PetShopController>forConstructor(PetShopService.class, UserService.class)
            .withGenerator((registeredBean, args) -> new PetShopController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'petShopController'.
   */
  public static BeanDefinition getPetShopControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PetShopController.class);
    beanDefinition.setInstanceSupplier(getPetShopControllerInstanceSupplier());
    return beanDefinition;
  }
}
