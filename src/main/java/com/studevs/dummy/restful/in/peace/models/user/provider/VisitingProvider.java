package com.studevs.dummy.restful.in.peace.models.user.provider;

import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.Visiting;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.SessionProvider;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class VisitingProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This method will update an existing visiting entity from database.
     *
     * @param visiting
     * @param beanProvider
     * @return
     */
    public boolean updateVisiting(final Visiting visiting, final BeanProvider beanProvider) {

        boolean isUpdated = false;

        if (beanProvider != null && visiting != null && visiting.getId() != null && visiting.getId() > 0L) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;

            try {

                transaction = session.beginTransaction();
                Visiting visitingFromDB = session.get(Visiting.class, visiting.getId());

                if (visitingFromDB != null) {

                    visitingFromDB.replicate(visiting);
                }

                transaction.commit();
                isUpdated = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, visiting, visiting.getId());
            }
        }

        return isUpdated;
    }

    /**
     * This method will provide visiting entity by visiting id.
     *
     * @param id
     * @param beanProvider
     * @return
     */
    public Visiting getVisitingById(final Long id, final BeanProvider beanProvider) {

        Visiting visiting = null;

        if (beanProvider != null && id != null && id > 0L) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;

            try {

                transaction = session.beginTransaction();
                visiting = session.get(Visiting.class, id);
                transaction.commit();
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, null, id);
            }
        }

        return visiting;
    }

    /**
     * This method will insert new visiting associated with provided patient and doctor id.
     *
     * @param visiting
     * @param patientId
     * @param doctorId
     * @param beanProvider
     * @return
     */
    public boolean insertNewVisiting(final Visiting visiting, final Long patientId, final Long doctorId, final BeanProvider beanProvider) {

        boolean isInserted = false;

        if (beanProvider != null && visiting != null && doctorId != null && doctorId > 0L && patientId != null && patientId > 0L) {

            Session session = ((SessionProvider) beanProvider.getBean("session")).getSession();
            Transaction transaction = null;
            try {

                transaction = session.beginTransaction();
                Doctor doctor = session.get(Doctor.class, doctorId);
                visiting.setDoctor(doctor);
                doctor.getVisitings().add(visiting);
                Patient patient = session.get(Patient.class, patientId);
                patient.getVisitings().add(visiting);
                visiting.setPatient(patient);
                session.persist(visiting);
                transaction.commit();
                isInserted = true;
            } catch (Exception e) {

                if (transaction != null) {

                    transaction.rollback();
                }

                beanProvider.logger(e, visiting, doctorId);
            }
        }

        return isInserted;
    }
}
