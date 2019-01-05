package cn.wh.mss;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyInitizlizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
		}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
//	@Override
//	protected Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
//		servletContext.addFilter(arg0, arg1)
//		return super.registerServletFilter(servletContext, filter);
//	}
	
	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {

		Dynamic filter = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.setInitParameter("forceRequestEncoding", "true");
		filter.setInitParameter("forceResponseEncoding", "true");
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

		super.registerContextLoaderListener(servletContext);
	}
}
