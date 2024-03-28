package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.scheduling.SchedulingService;
import webminds.group.pet_backend.services.service.AssignmentServiceEmployeeService;

/**
 * Bean definitions for {@link SchedulingController}.
 */
public class SchedulingController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'schedulingController'.
   */
  private static BeanInstanceSupplier<SchedulingController> getSchedulingControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SchedulingController>forConstructor(PetService.class, AssignmentServiceEmployeeService.class, SchedulingService.class)
            .withGenerator((registeredBean, args) -> new SchedulingController(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'schedulingController'.
   */
  public static BeanDefinition getSchedulingControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SchedulingController.class);
    beanDefinition.setInstanceSupplier(getSchedulingControllerInstanceSupplier());
    return beanDefinition;
  }
}
