package webminds.group.pet_backend.api.configuration.security;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;
import webminds.group.pet_backend.api.configuration.security.jwt.ManagerTokenJwt;
import webminds.group.pet_backend.api.configuration.security.jwt.ManagerTokenJwt__Autowiring;

/**
 * Bean definitions for {@link SecurityConfiguration}.
 */
public class SecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'securityConfiguration'.
   */
  public static BeanDefinition getSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityConfiguration.class);
    beanDefinition.setTargetType(SecurityConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(SecurityConfiguration.class);
    InstanceSupplier<SecurityConfiguration> instanceSupplier = InstanceSupplier.using(SecurityConfiguration$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(SecurityConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'filterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getFilterChainInstanceSupplier() {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(SecurityConfiguration.class, "filterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).filterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'filterChain'.
   */
  public static BeanDefinition getFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SecurityFilterChain.class);
    beanDefinition.setInstanceSupplier(getFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'authManager'.
   */
  private static BeanInstanceSupplier<AuthenticationManager> getAuthManagerInstanceSupplier() {
    return BeanInstanceSupplier.<AuthenticationManager>forFactoryMethod(SecurityConfiguration.class, "authManager", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).authManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'authManager'.
   */
  public static BeanDefinition getAuthManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(AuthenticationManager.class);
    beanDefinition.setInstanceSupplier(getAuthManagerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwtAuthenticationEntryPointBean'.
   */
  private static BeanInstanceSupplier<AuthenticationUserEntryPoint> getJwtAuthenticationEntryPointBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationUserEntryPoint>forFactoryMethod(SecurityConfiguration.class, "jwtAuthenticationEntryPointBean")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).jwtAuthenticationEntryPointBean());
  }

  /**
   * Get the bean definition for 'jwtAuthenticationEntryPointBean'.
   */
  public static BeanDefinition getJwtAuthenticationEntryPointBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(AuthenticationUserEntryPoint.class);
    beanDefinition.setInstanceSupplier(getJwtAuthenticationEntryPointBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwtAuthenticationFilterBean'.
   */
  private static BeanInstanceSupplier<AuthenticationUserFilter> getJwtAuthenticationFilterBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationUserFilter>forFactoryMethod(SecurityConfiguration.class, "jwtAuthenticationFilterBean")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).jwtAuthenticationFilterBean());
  }

  /**
   * Get the bean definition for 'jwtAuthenticationFilterBean'.
   */
  public static BeanDefinition getJwtAuthenticationFilterBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(AuthenticationUserFilter.class);
    beanDefinition.setInstanceSupplier(getJwtAuthenticationFilterBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwtAuthenticationUtilBean'.
   */
  private static BeanInstanceSupplier<ManagerTokenJwt> getJwtAuthenticationUtilBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ManagerTokenJwt>forFactoryMethod(SecurityConfiguration.class, "jwtAuthenticationUtilBean")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).jwtAuthenticationUtilBean());
  }

  /**
   * Get the bean definition for 'jwtAuthenticationUtilBean'.
   */
  public static BeanDefinition getJwtAuthenticationUtilBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(ManagerTokenJwt.class);
    InstanceSupplier<ManagerTokenJwt> instanceSupplier = getJwtAuthenticationUtilBeanInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(ManagerTokenJwt__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(SecurityConfiguration.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(PasswordEncoder.class);
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'corsConfigurationSource'.
   */
  private static BeanInstanceSupplier<CorsConfigurationSource> getCorsConfigurationSourceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CorsConfigurationSource>forFactoryMethod(SecurityConfiguration.class, "corsConfigurationSource")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).corsConfigurationSource());
  }

  /**
   * Get the bean definition for 'corsConfigurationSource'.
   */
  public static BeanDefinition getCorsConfigurationSourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(CorsConfigurationSource.class);
    beanDefinition.setInstanceSupplier(getCorsConfigurationSourceInstanceSupplier());
    return beanDefinition;
  }
}
