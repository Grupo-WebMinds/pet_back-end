package webminds.group.pet_backend.services.petShop;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.domain.petShop.repositories.PetShopRepository;

/**
 * Bean definitions for {@link PetShopService}.
 */
public class PetShopService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'petShopService'.
   */
  private static BeanInstanceSupplier<PetShopService> getPetShopServiceInstanceSupplier() {
    return BeanInstanceSupplier.<PetShopService>forConstructor(PetShopRepository.class)
            .withGenerator((registeredBean, args) -> new PetShopService(args.get(0)));
  }

  /**
   * Get the bean definition for 'petShopService'.
   */
  public static BeanDefinition getPetShopServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PetShopService.class);
    beanDefinition.setInstanceSupplier(getPetShopServiceInstanceSupplier());
    return beanDefinition;
  }
}
