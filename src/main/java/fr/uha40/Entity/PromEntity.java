package fr.uha40.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * PromEntity
 * Package : fr.uha40.Entity
 * Created : 14/09/2016 12:19
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Entity
@Table(name = "proms")
public class PromEntity extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int number;

    @DateTimeFormat
    private Date entryDate;

    @OneToMany(mappedBy = "prom")
    private Collection<UserEntity> users;

    public PromEntity() {
        super();
    }

    public PromEntity(int number, Date entryDate) {
        this.number = number;
        this.entryDate = entryDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }
}
