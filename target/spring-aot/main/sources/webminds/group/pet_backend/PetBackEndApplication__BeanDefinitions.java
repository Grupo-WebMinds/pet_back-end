package webminds.group.pet_backend;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link PetBackEndApplication}.
 */
public class PetBackEndApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'petBackEndApplication'.
   */
  public static BeanDefinition getPetBackEndApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PetBackEndApplication.class);
    beanDefinition.setTargetType(PetBackEndApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(PetBackEndApplication.class);
    beanDefinition.setInstanceSupplier(PetBackEndApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
