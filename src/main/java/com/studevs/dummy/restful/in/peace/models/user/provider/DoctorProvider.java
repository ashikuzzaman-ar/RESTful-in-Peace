package com.studevs.dummy.restful.in.peace.models.user.provider;

import com.studevs.dummy.restful.in.peace.models.user.Doctor;
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
public class DoctorProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This method will fetch unique doctor from database using username. If no data found then null this method will return null.
     *
     * @param username
     * @param beanProvider
     * @return
     */
    @SuppressWarnings("unchecked")
    public Doctor getDoctorByUsername(String username, BeanProvider beanProvider) {

        Doctor doctor = null;

        /**
         * beanProvider can't be null for provind beans and logger. username can't be null or empty string.
         */
        if (beanProvider != null && username != null && !username.isEmpty()) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            Query<Doctor> query;

            try {

                transaction = session.beginTransaction();
                query = session.createQuery("FROM Doctor D WHERE D.username = :id_1");
                query.setParameter("id_1", username);
                doctor = query.uniqueResult();
                transaction.commit();
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, username, null);
            }
        }

        return doctor;
    }

    /**
     * This method will check that all fields of Doctor model have right property setup. That means Doctor's model not null property should not be null. This method will check that all. If any field found null which should not be null then this method will return false. Otherwise this method will return true.
     *
     * @param doctor
     * @return
     */
    private boolean hasNoError(final Doctor doctor) {

        if (doctor.getUsername() == null || doctor.getUsername().isEmpty()) {
            return false;
        }
        if (doctor.getPassword() == null || doctor.getPassword().isEmpty()) {
            return false;
        }
        if (doctor.getEmail() == null || doctor.getEmail().isEmpty()) {
            return false;
        }
        if (doctor.getFirstName() == null || doctor.getFirstName().isEmpty()) {
            return false;
        }
        if (doctor.getLastName() == null || doctor.getLastName().isEmpty()) {
            return false;
        }
        if (doctor.getAddress() == null || doctor.getAddress().isEmpty()) {
            return false;
        }
        if (doctor.getCity() == null || doctor.getCity().isEmpty()) {
            return false;
        }
        if (doctor.getState() == null || doctor.getState().isEmpty()) {
            return false;
        }
        if (doctor.getCountry() == null || doctor.getCountry().isEmpty()) {
            return false;
        }
        return doctor.getGender() != null;
    }

    /**
     * This method will insert Doctor's instance in database. It will take Doctor and BeanProvider instance as parameter and doctor is for persisting and beanProvider is for providing beans for this class. This method will return boolean type value. If a data is successfully persisted then it will return true otherwise it will return false.
     *
     * @param doctor
     * @param beanProvider
     * @return
     */
    public boolean insertNewDoctor(final Doctor doctor, final BeanProvider beanProvider) {

        boolean isComplete = false;

        /**
         * beanProvider should not be null for providing beans and logger. doctor should not be null for persisting, a null value can't be persisted by hibernate.
         */
        if (beanProvider != null && doctor != null && hasNoError(doctor)) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            try {

                transaction = session.beginTransaction();
                session.persist(doctor);
                transaction.commit();
                isComplete = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, doctor, doctor.getId());
            }
        }

        return isComplete;
    }
}
