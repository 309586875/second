package cn.wh.mss;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.wh.mss.web.interceptor.CheckLoginInterceptor;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/views/");
		view.setSuffix(".jsp");
		return view;
	}
	
//	@Bean
//	public CheckLoginInterceptor checkLoginInterceptor() {
//		return new CheckLoginInterceptor();
//	}
//	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
//		registry.addInterceptor(checkLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
	
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
