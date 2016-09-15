package fr.uha40.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.uha40.Enums.Role;

import javax.persistence.*;
import java.io.Serializable;

/**
 * UserEntity
 * Package : fr.uha40.Entity
 * Created : 13/09/2016 07:36
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Entity
@Table(name = "users")
public class UserEntity extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String firstName;

    private String lastName;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String email;

    @ManyToOne(targetEntity = LevelEntity.class)
    private LevelEntity level;

    @ManyToOne(targetEntity = PromEntity.class)
    private PromEntity prom;

    public UserEntity() {
        super();
    }

    public UserEntity(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, username=%s, firstName=%s, lastName=%s, role=%s, email=%s]", id, username, firstName, lastName, role, email);
    }
}
