package com.studevs.dummy.restful.in.peace.models.user.provider;

import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.SessionProvider;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class DoctorProvider implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public boolean insertNewDoctor(final Doctor doctor, final BeanProvider beanProvider) {

        boolean isComplete = false;

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
