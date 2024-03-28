package webminds.group.pet_backend.services.scheduling;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.domain.scheduling.repositories.SchedulingRepository;

/**
 * Bean definitions for {@link SchedulingService}.
 */
public class SchedulingService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'schedulingService'.
   */
  private static BeanInstanceSupplier<SchedulingService> getSchedulingServiceInstanceSupplier() {
    return BeanInstanceSupplier.<SchedulingService>forConstructor(SchedulingRepository.class)
            .withGenerator((registeredBean, args) -> new SchedulingService(args.get(0)));
  }

  /**
   * Get the bean definition for 'schedulingService'.
   */
  public static BeanDefinition getSchedulingServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SchedulingService.class);
    beanDefinition.setInstanceSupplier(getSchedulingServiceInstanceSupplier());
    return beanDefinition;
  }
}
