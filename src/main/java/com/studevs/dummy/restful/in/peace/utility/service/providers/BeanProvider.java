package com.studevs.dummy.restful.in.peace.utility.service.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studevs.dummy.restful.in.peace.models.system.Log;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
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

    private ObjectMapper mapper;
    private List<String> message;
    private Map<String, List<String>> messages;

    protected BeanProvider() {

        this.CONTEXT = new XmlWebApplicationContext();
    }

    /**
     * This method will initialize some necessary fields before starting other works.
     *
     * @param request
     */
    protected void initializer(HttpServletRequest request) {

        this.createContext(request);
        this.mapper = this.getBean("mapper");
        this.message = this.getBean("message");
        this.message.clear();
        this.messages = this.getBean("messages");
        this.messages.put("messages", this.message);
    }

    /**
     * Call this method for getting beans. Set bean name as string and if the bean is available then it'll provide you that bean. If the bean is not present or any exception occurred then null will be returned.
     *
     * @param <T>
     * @param beanName
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName) {

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

    /**
     * This method will log any exception happened in runtime. Exception instance e will be used for making trace of the bug. Object instance o will be used for object state of that time and userId will be used for understanding for whom this exception has been happened.
     *
     * @param e
     * @param object
     * @param userId
     */
    public void logger(final Exception e, Object object, Long userId) {

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

    protected ObjectMapper getMapper() {
        return mapper;
    }

    protected List<String> getMessage() {
        return message;
    }

    protected Map<String, List<String>> getMessages() {
        return messages;
    }
}
