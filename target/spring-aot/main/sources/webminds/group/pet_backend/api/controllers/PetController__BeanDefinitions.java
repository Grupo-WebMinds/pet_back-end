package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.user.client.UserService;

/**
 * Bean definitions for {@link PetController}.
 */
public class PetController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'petController'.
   */
  private static BeanInstanceSupplier<PetController> getPetControllerInstanceSupplier() {
    return BeanInstanceSupplier.<PetController>forConstructor(UserService.class, PetService.class)
            .withGenerator((registeredBean, args) -> new PetController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'petController'.
   */
  public static BeanDefinition getPetControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PetController.class);
    beanDefinition.setInstanceSupplier(getPetControllerInstanceSupplier());
    return beanDefinition;
  }
}
