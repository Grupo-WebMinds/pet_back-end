package webminds.group.pet_backend.services.pet;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.domain.pet.repositories.PetRepository;

/**
 * Bean definitions for {@link PetService}.
 */
public class PetService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'petService'.
   */
  private static BeanInstanceSupplier<PetService> getPetServiceInstanceSupplier() {
    return BeanInstanceSupplier.<PetService>forConstructor(PetRepository.class)
            .withGenerator((registeredBean, args) -> new PetService(args.get(0)));
  }

  /**
   * Get the bean definition for 'petService'.
   */
  public static BeanDefinition getPetServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PetService.class);
    beanDefinition.setInstanceSupplier(getPetServiceInstanceSupplier());
    return beanDefinition;
  }
}
