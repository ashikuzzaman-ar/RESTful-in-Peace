package com.studevs.dummy.restful.in.peace.utility.service.providers;

import com.studevs.dummy.restful.in.peace.models.system.Log;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

            this.logger(e, null, null);
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

    protected void logger(Exception e, Object object, Long userId) {

        Log log = this.getBean("log");
        Session session = ((SessionProvider) this.getBean("session")).getSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            log.setExceptionClass(e.getClass().getName());
            log.setMessage(e.getMessage());
            log.setParentClass(this.getClass().getName());
            if (userId != null) {

                log.setUserId(userId);
            }
            if (object != null) {

                log.setObjectState(object.toString());
            }
            session.persist(log);
            transaction.commit();
        } catch (Exception ex) {

            if (transaction != null) {

                transaction.rollback();
            }

            throw new ExceptionInInitializerError(ex);
        }
    }
}
