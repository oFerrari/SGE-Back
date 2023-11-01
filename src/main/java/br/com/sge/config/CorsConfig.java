/*
 * package br.com.sge.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 * @Configuration public class CorsConfig {
 * 
 * @Bean public WebMvcConfigurer corsConfigurer() { return new
 * WebMvcConfigurer() {
 * 
 * @Override public void addCorsMappings(CorsRegistry registry) {
 * registry.addMapping("/**") .allowedOrigins("http://localhost:8100") //
 * Substitua pelo seu domínio .allowedMethods("GET", "POST", "PUT", "DELETE")
 * .allowedHeaders("*"); } }; } }
 */