package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.service.AssignmentServiceEmployeeService;
import webminds.group.pet_backend.services.service.ServicePetService;
import webminds.group.pet_backend.services.user.client.UserService;
import webminds.group.pet_backend.services.user.employee.EmployeeService;

/**
 * Bean definitions for {@link EmployeeController}.
 */
public class EmployeeController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'employeeController'.
   */
  private static BeanInstanceSupplier<EmployeeController> getEmployeeControllerInstanceSupplier() {
    return BeanInstanceSupplier.<EmployeeController>forConstructor(EmployeeService.class, UserService.class, PetShopService.class, ServicePetService.class, AssignmentServiceEmployeeService.class)
            .withGenerator((registeredBean, args) -> new EmployeeController(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'employeeController'.
   */
  public static BeanDefinition getEmployeeControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmployeeController.class);
    beanDefinition.setInstanceSupplier(getEmployeeControllerInstanceSupplier());
    return beanDefinition;
  }
}
