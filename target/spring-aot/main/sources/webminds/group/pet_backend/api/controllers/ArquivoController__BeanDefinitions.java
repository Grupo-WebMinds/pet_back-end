package webminds.group.pet_backend.api.controllers;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import webminds.group.pet_backend.services.scheduling.SchedulingService;

/**
 * Bean definitions for {@link ArquivoController}.
 */
public class ArquivoController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'arquivoController'.
   */
  private static BeanInstanceSupplier<ArquivoController> getArquivoControllerInstanceSupplier() {
    return BeanInstanceSupplier.<ArquivoController>forConstructor(SchedulingService.class)
            .withGenerator((registeredBean, args) -> new ArquivoController(args.get(0)));
  }

  /**
   * Get the bean definition for 'arquivoController'.
   */
  public static BeanDefinition getArquivoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ArquivoController.class);
    beanDefinition.setInstanceSupplier(getArquivoControllerInstanceSupplier());
    return beanDefinition;
  }
}
