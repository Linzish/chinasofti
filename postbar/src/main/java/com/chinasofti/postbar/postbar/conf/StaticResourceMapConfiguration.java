package com.chinasofti.postbar.postbar.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 实现静态资源的映射
 * 保证能够访问到诸如.js,.css等静态资源
 * @ClassName StaticResourceMapConfiguration
 * @author 郑泽锋
 * @date 2018年4月11日
 */
@Configuration
public class StaticResourceMapConfiguration extends WebMvcConfigurationSupport {
	private static Logger log = LoggerFactory.getLogger(StaticResourceMapConfiguration.class);
	/*@Value("${HTML_PATH}")
	private String HTML_PATH;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info(HTML_PATH);
		registry.addResourceHandler("/**").addResourceLocations("file:D:/Program/idea/ChinaSoft/base/html/");
		super.addResourceHandlers(registry);
	}*/

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/chinasofti/**","/postbar/static/chinasofti/**", "/index.html").addResourceLocations("classpath:/chinasofti/");
		registry.addResourceHandler("/static/**", "/postbar/static/**").addResourceLocations("classpath:/static/");
		// windows
		registry.addResourceHandler("/audio/**", "/postbar/audio/**").addResourceLocations("file:D:/Program/idea/ChinaSoft-CloudVer/audio/");
		// linux
//		registry.addResourceHandler("/audio/**", "/postbar/audio/**").addResourceLocations("file:/audio/");
//		registry.addResourceHandler("/headPhoto/**", "/postbar/headPhoto/**").addResourceLocations("classpath:/headPhoto/");
		registry.addResourceHandler("/headPhoto/**", "/postbar/headPhoto/**").addResourceLocations("file:D:/Program/idea/ChinaSoft-CloudVer/headPhoto/");
//		registry.addResourceHandler("/headPhoto/**", "/postbar/headPhoto/**").addResourceLocations("file:/headPhoto/");
//		registry.addResourceHandler("/kindeditorImage/**", "/postbar/kindeditorImage/**").addResourceLocations("classpath:/kindeditorImage/");
		registry.addResourceHandler("/kindeditorImage/**", "/postbar/kindeditorImage/**").addResourceLocations("file:D:/Program/idea/ChinaSoft-CloudVer/kindeditorImage/");
//		registry.addResourceHandler("/kindeditorImage/**", "/postbar/kindeditorImage/**").addResourceLocations("file:/kindeditorImage/");
	}

}
