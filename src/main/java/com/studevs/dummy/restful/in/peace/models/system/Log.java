package com.studevs.dummy.restful.in.peace.models.system;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "system_logs", indexes = {
    @Index(columnList = "id", name = "log_list_id")
    ,
    @Index(columnList = "user_id", name = "log_list_user_id")
    ,
    @Index(columnList = "log_date", name = "log_list_log_date")
})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id and primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * User id for whom this error has been occurred.
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * Date and Time for this occurrence.
     */
    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /**
     * Error message or exception message.
     */
    @Column(name = "log_message", length = 1000)
    private String message;

    /**
     * Parent class. Class name where this occurrence has been happened.
     */
    @Column(name = "parent_class")
    private String parentClass;

    /**
     * Exception class name for debugging the system.
     */
    @Column(name = "exception_class")
    private String exceptionClass;

    /**
     * Object state while an error has been occurred.
     */
    @Column(name = "object_state", length = 2000)
    private String objectState;

    public Log() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParentClass() {
        return parentClass;
    }

    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }

    public String getExceptionClass() {
        return exceptionClass;
    }

    public void setExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    public String getObjectState() {
        return objectState;
    }

    public void setObjectState(String objectState) {
        this.objectState = objectState;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.userId);
        hash = 89 * hash + Objects.hashCode(this.date);
        hash = 89 * hash + Objects.hashCode(this.message);
        hash = 89 * hash + Objects.hashCode(this.parentClass);
        hash = 89 * hash + Objects.hashCode(this.exceptionClass);
        hash = 89 * hash + Objects.hashCode(this.objectState);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Log other = (Log) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.parentClass, other.parentClass)) {
            return false;
        }
        if (!Objects.equals(this.exceptionClass, other.exceptionClass)) {
            return false;
        }
        if (!Objects.equals(this.objectState, other.objectState)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", userId=" + userId + ", date=" + date + ", message=" + message + ", parentClass=" + parentClass + ", exceptionClass=" + exceptionClass + ", objectState=" + objectState + '}';
    }
}
