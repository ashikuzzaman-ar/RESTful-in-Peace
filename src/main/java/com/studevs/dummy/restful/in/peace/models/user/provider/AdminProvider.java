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

    @SuppressWarnings("unchecked")
    public Admin getAdminByUsername(final String username, final BeanProvider beanProvider) {

        Admin admin = null;

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
