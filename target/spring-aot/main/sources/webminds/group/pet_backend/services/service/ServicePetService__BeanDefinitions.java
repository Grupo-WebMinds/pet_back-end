package webminds.group.pet_backend.services.service;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.domain.service.repositories.ServicePetRepository;

/**
 * Bean definitions for {@link ServicePetService}.
 */
public class ServicePetService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'servicePetService'.
   */
  private static BeanInstanceSupplier<ServicePetService> getServicePetServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ServicePetService>forConstructor(ServicePetRepository.class)
            .withGenerator((registeredBean, args) -> new ServicePetService(args.get(0)));
  }

  /**
   * Get the bean definition for 'servicePetService'.
   */
  public static BeanDefinition getServicePetServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServicePetService.class);
    beanDefinition.setInstanceSupplier(getServicePetServiceInstanceSupplier());
    return beanDefinition;
  }
}
