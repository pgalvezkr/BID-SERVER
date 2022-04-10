package com.witbooking.bidserver.filters;

import org.slf4j.Logger;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SessionKeyFilter implements  Filter{

    @Bean
    public FilterRegistrationBean<SessionKeyFilter> sessionKeyFilter(){
        FilterRegistrationBean<SessionKeyFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new SessionKeyFilter());
        registrationBean.addUrlPatterns("/bids/*");
        return registrationBean;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=========== DO FILTER ============");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
        for (int i =0; i <= request.getParameterMap().size(); i++){
                System.out.println("Parametro ========>" + request.getParameterMap().get(i));
        }
            filterChain.doFilter(request, response);

    }
}
