package com.studevs.dummy.restful.in.peace.models.user.provider;

import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.utility.service.Encrypt;
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
public class PatientProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This method will update any existing user from database.
     *
     * @param patient
     * @param beanProvider
     * @param passwordTrigger
     * @return
     */
    public boolean updatePatient(final Patient patient, final BeanProvider beanProvider, final boolean passwordTrigger) {

        boolean isUpdated = false;

        if (beanProvider != null && patient != null && this.hasNoError(patient) && patient.getId() != null) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;

            try {

                transaction = session.beginTransaction();
                session.update(patient);

                /**
                 * If the password trigger is true, it means that password has to be encrypt because it has been updated.
                 */
                if (!passwordTrigger) {

                    Encrypt encrypt = beanProvider.getBean("encrypt");
                    patient.setPassword(encrypt.generateHash(patient.getPassword(), patient.getId()));
                }
                transaction.commit();
                isUpdated = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, patient, patient.getId());
            }
        }

        return isUpdated;
    }

    /**
     * This method will fetch unique patient from database using username. If no data found then null this method will return null.
     *
     * @param username
     * @param beanProvider
     * @return
     */
    @SuppressWarnings("unchecked")
    public Patient getPatientByUsername(String username, BeanProvider beanProvider) {

        Patient patient = null;

        /**
         * beanProvider can't be null for provind beans and logger. username can't be null or empty string.
         */
        if (beanProvider != null && username != null && !username.isEmpty()) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            Query<Patient> query;

            try {

                transaction = session.beginTransaction();
                query = session.createQuery("FROM Patient P WHERE P.username = :id_1");
                query.setParameter("id_1", username);
                patient = query.uniqueResult();
                transaction.commit();
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, username, null);
            }
        }

        return patient;
    }

    /**
     * This method will check that all fields of Patient model have right property setup. That means Patient's model not null property should not be null. This method will check that all. If any field found null which should not be null then this method will return false. Otherwise this method will return true.
     *
     * @param patient
     * @return
     */
    private boolean hasNoError(final Patient patient) {

        if (patient.getUsername() == null || patient.getUsername().isEmpty()) {
            return false;
        }
        if (patient.getPassword() == null || patient.getPassword().isEmpty()) {
            return false;
        }
        if (patient.getEmail() == null || patient.getEmail().isEmpty()) {
            return false;
        }
        if (patient.getFirstName() == null || patient.getFirstName().isEmpty()) {
            return false;
        }
        if (patient.getLastName() == null || patient.getLastName().isEmpty()) {
            return false;
        }
        if (patient.getAddress() == null || patient.getAddress().isEmpty()) {
            return false;
        }
        if (patient.getCity() == null || patient.getCity().isEmpty()) {
            return false;
        }
        if (patient.getState() == null || patient.getState().isEmpty()) {
            return false;
        }
        if (patient.getCountry() == null || patient.getCountry().isEmpty()) {
            return false;
        }
        return patient.getGender() != null;
    }

    /**
     * This method will insert Patient's instance in database. It will take Patient and BeanProvider instance as parameter and patient is for persisting and beanProvider is for providing beans for this class. This method will return boolean type value. If a data is successfully persisted then it will return true otherwise it will return false.
     *
     * @param patient
     * @param beanProvider
     * @return
     */
    public boolean insertNewPatient(final Patient patient, final BeanProvider beanProvider) {

        boolean isComplete = false;

        /**
         * beanProvider should not be null for providing beans and logger. patient should not be null for persisting, a null value can't be persisted by hibernate.
         */
        if (beanProvider != null && patient != null && hasNoError(patient)) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            try {

                transaction = session.beginTransaction();
                session.persist(patient);
                Encrypt encrypt = beanProvider.getBean("encrypt");
                patient.setPassword(encrypt.generateHash(patient.getPassword(), patient.getId()));
                transaction.commit();
                isComplete = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, patient, patient.getId());
            }
        }

        return isComplete;
    }
}
