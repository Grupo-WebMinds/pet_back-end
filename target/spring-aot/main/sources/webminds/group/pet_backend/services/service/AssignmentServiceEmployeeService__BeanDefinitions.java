package webminds.group.pet_backend.services.service;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.domain.service.repositories.AssignmentServiceEmployeeRepository;

/**
 * Bean definitions for {@link AssignmentServiceEmployeeService}.
 */
public class AssignmentServiceEmployeeService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'assignmentServiceEmployeeService'.
   */
  private static BeanInstanceSupplier<AssignmentServiceEmployeeService> getAssignmentServiceEmployeeServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AssignmentServiceEmployeeService>forConstructor(AssignmentServiceEmployeeRepository.class)
            .withGenerator((registeredBean, args) -> new AssignmentServiceEmployeeService(args.get(0)));
  }

  /**
   * Get the bean definition for 'assignmentServiceEmployeeService'.
   */
  public static BeanDefinition getAssignmentServiceEmployeeServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AssignmentServiceEmployeeService.class);
    beanDefinition.setInstanceSupplier(getAssignmentServiceEmployeeServiceInstanceSupplier());
    return beanDefinition;
  }
}
