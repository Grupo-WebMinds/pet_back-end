package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.service.ServicePetService;

/**
 * Bean definitions for {@link ServiceController}.
 */
public class ServiceController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'serviceController'.
   */
  private static BeanInstanceSupplier<ServiceController> getServiceControllerInstanceSupplier() {
    return BeanInstanceSupplier.<ServiceController>forConstructor(PetShopService.class, ServicePetService.class, PetService.class)
            .withGenerator((registeredBean, args) -> new ServiceController(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'serviceController'.
   */
  public static BeanDefinition getServiceControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceController.class);
    beanDefinition.setInstanceSupplier(getServiceControllerInstanceSupplier());
    return beanDefinition;
  }
}
