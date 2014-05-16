package io.undertow.servlet.api;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

/**
 * Class that is run around invocations of servlet and filter lifecycle methods (init and destroy).
 *
 * Note that this only deals with lifecycle methods that are defined by the servlet spec. @POstConstruct,
 * PreDestroy and Inject methods are not handled.
 *
 * @author Stuart Douglas
 */
public interface LifecycleInterceptor {

    void init(ServletInfo servletInfo, Servlet servlet, LifecycleContext context);

    void init(FilterInfo filterInfo, Filter filter,  LifecycleContext context);

    void destroy(ServletInfo servletInfo, Servlet servlet,  LifecycleContext context);

    void destroy(FilterInfo filterInfo, Filter filter, LifecycleContext context);

    public interface LifecycleContext {
        void proceed() throws ServletException;
    }
}

