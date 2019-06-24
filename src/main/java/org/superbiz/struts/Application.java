package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SiteMeshFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean strutsPrepareAndExecuteFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new StrutsPrepareAndExecuteFilter());
        registration.addUrlPatterns("/");
        registration.addUrlPatterns("/addUserForm.action");
        registration.addUrlPatterns("/addUser.action");
        registration.addUrlPatterns("/findUserForm.action");
        registration.addUrlPatterns("/findUser.action");
        registration.addUrlPatterns("/listAllUsers.action");
        registration.setOrder(2);
        return registration;
    }
}
