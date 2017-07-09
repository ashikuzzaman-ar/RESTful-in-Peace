package com.studevs.dummy.restful.in.peace.utility.service.providers;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeansException;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 *
 * @author ashik
 */
public class BeanProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    private final XmlWebApplicationContext CONTEXT;

    protected BeanProvider() {

        this.CONTEXT = new XmlWebApplicationContext();
    }

    /**
     * Call this method for getting beans. Set bean name as string and if the bean is available then it'll provide you that bean. If the bean is not present or any exception occurred then null will be returned.
     *
     * @param <T>
     * @param beanName
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> T getBean(String beanName) {

        try {

            return (T) this.CONTEXT.getBean(beanName);
        } catch (BeansException e) {

            return null;
        }
    }

    /**
     * Call this method before calling getBeans method for initializing context object through HttpServletRequest object.
     *
     * @param request
     * @return
     */
    protected XmlWebApplicationContext createContext(HttpServletRequest request) {

        try {

            this.CONTEXT.setServletContext(request.getServletContext());
            this.CONTEXT.refresh();
            return this.CONTEXT;
        } catch (IllegalStateException | BeansException e) {

            throw new ExceptionInInitializerError(e);
        }
    }
}
