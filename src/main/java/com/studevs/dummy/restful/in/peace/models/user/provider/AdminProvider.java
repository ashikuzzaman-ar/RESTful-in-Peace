package com.studevs.dummy.restful.in.peace.models.user.provider;

import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.SessionProvider;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ashik
 */
public class AdminProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This method will return Admin object which will be persisted from database by using username. beanProrovider will be used for providing beans and logger. username will be used for querying admin instance from database. If any data found with this username then this method will return that admin object otherwise this method will return null.
     *
     * @param username
     * @param beanProvider
     * @return
     */
    @SuppressWarnings("unchecked")
    public Admin getAdminByUsername(final String username, final BeanProvider beanProvider) {

        Admin admin = null;

        /**
         * beanProvider should not be null for providing beans and logger. username should not be null nor empty string. This field is unique and this is the key to query admin from database.
         */
        if (beanProvider != null && username != null && !username.isEmpty()) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            Query<Admin> query;

            try {

                transaction = session.beginTransaction();
                query = session.createQuery("FROM Admin A WHERE A.username = :id_1");
                query.setParameter("id_1", username);
                admin = query.uniqueResult();
                transaction.commit();
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }
                beanProvider.logger(e, null, null);
            }
        }

        return admin;
    }
}
