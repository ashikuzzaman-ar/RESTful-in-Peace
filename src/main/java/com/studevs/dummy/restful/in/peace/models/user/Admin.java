package com.studevs.dummy.restful.in.peace.models.user;

import com.studevs.dummy.restful.in.peace.models.enums.AdminPrivilege;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "admin_authentication")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private byte[] password;

    @Column(name = "admin_privilege", nullable = false)
    private AdminPrivilege adminPrivilege;

    public Admin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {

        String result = "";
        for (byte b : this.password) {

            result += ((char) b);
        }
        return result;
    }

    public void setPassword(String password) {
        this.password = password.getBytes();
    }

    public AdminPrivilege getAdminPrivilege() {
        return adminPrivilege;
    }

    public void setAdminPrivilege(AdminPrivilege adminPrivilege) {
        this.adminPrivilege = adminPrivilege;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Arrays.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.adminPrivilege);
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
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Arrays.equals(this.password, other.password)) {
            return false;
        }
        return this.adminPrivilege == other.adminPrivilege;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", username=" + username + ", adminPrivilege=" + adminPrivilege + '}';
    }
}
