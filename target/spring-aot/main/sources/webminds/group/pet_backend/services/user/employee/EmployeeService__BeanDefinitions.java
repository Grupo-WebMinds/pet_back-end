package webminds.group.pet_backend.services.user.employee;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.domain.user.repositories.EmployeeRepository;

/**
 * Bean definitions for {@link EmployeeService}.
 */
public class EmployeeService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'employeeService'.
   */
  private static BeanInstanceSupplier<EmployeeService> getEmployeeServiceInstanceSupplier() {
    return BeanInstanceSupplier.<EmployeeService>forConstructor(EmployeeRepository.class)
            .withGenerator((registeredBean, args) -> new EmployeeService(args.get(0)));
  }

  /**
   * Get the bean definition for 'employeeService'.
   */
  public static BeanDefinition getEmployeeServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmployeeService.class);
    beanDefinition.setInstanceSupplier(getEmployeeServiceInstanceSupplier());
    return beanDefinition;
  }
}
