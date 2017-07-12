package com.studevs.dummy.restful.in.peace.models.user.provider;

import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.utility.service.Encrypt;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.SessionProvider;
import java.io.Serializable;
import java.util.List;
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
     * This method will fetch admin from database and return as a list.
     *
     * @param from
     * @param to
     * @param beanProvider
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Admin> getAdmins(final Long from, final Long to, final BeanProvider beanProvider) {

        List<Admin> admins = null;

        if (beanProvider != null && from > 0L && to > 0L) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            Query<Admin> query;

            try {

                transaction = session.beginTransaction();
                if (from <= to) {

                    query = session.createQuery("FROM Admin A WHERE (A.id >= :id_1 AND A.id <= :id_2)");
                    query.setParameter("id_1", from);
                    query.setParameter("id_2", to);
                } else {

                    query = session.createQuery("FROM Admin A");
                }
                admins = query.list();
                transaction.commit();
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, null, null);
            }
        }

        return admins;
    }

    /**
     * This method will delete an existing admin from database.
     *
     * @param admin
     * @param beanProvider
     * @return
     */
    public boolean deleteAdmin(final Admin admin, final BeanProvider beanProvider) {

        boolean isDeleted = false;

        if (beanProvider != null && admin != null && admin.getId() != null) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            try {

                transaction = session.beginTransaction();
                session.delete(admin);
                transaction.commit();
                isDeleted = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, admin, admin.getId());
            }
        }

        return isDeleted;
    }

    /**
     * This method will update an existing admin to database.
     *
     * @param admin
     * @param beanProvider
     * @param passwordTrigger
     * @return
     */
    public boolean updateAdmin(final Admin admin, final BeanProvider beanProvider, final boolean passwordTrigger) {

        boolean isUpdated = false;

        if (beanProvider != null && admin != null && this.hasNoError(admin)) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;

            try {

                transaction = session.beginTransaction();
                session.update(admin);

                if (!passwordTrigger) {

                    /**
                     * Encrypting password.
                     */
                    Encrypt encrypt = beanProvider.getBean("encrypt");
                    admin.setPassword(encrypt.generateHash(admin.getPassword(), admin.getId()));
                }
                transaction.commit();
                isUpdated = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }
                beanProvider.logger(e, admin, admin.getId());
            }
        }
        return isUpdated;
    }

    /**
     * This method will insert new admin to database.
     *
     * @param admin
     * @param beanProvider
     * @return
     */
    public boolean insertNewAdmin(final Admin admin, final BeanProvider beanProvider) {

        boolean isInserted = false;

        if (beanProvider != null && admin != null && this.hasNoError(admin)) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;

            try {

                transaction = session.beginTransaction();
                session.persist(admin);
                /**
                 * Encrypting password.
                 */
                Encrypt encrypt = beanProvider.getBean("encrypt");
                admin.setPassword(encrypt.generateHash(admin.getPassword(), admin.getId()));
                transaction.commit();
                isInserted = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }
                beanProvider.logger(e, admin, admin.getId());
            }
        }
        return isInserted;
    }

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

    /**
     * This method will check an admin if it has any error to persist or not.
     *
     * @param admin
     * @return
     */
    private boolean hasNoError(final Admin admin) {

        if (admin.getAdminPrivilege() == null) {
            return false;
        }

        if (admin.getPassword() == null || admin.getPassword().isEmpty()) {
            return false;
        }

        return !(admin.getUsername() == null || admin.getUsername().isEmpty());
    }
}
