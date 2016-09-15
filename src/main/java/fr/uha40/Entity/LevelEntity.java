package fr.uha40.Entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * LevelEntity
 * Package : fr.uha40.Entity
 * Created : 14/09/2016 12:22
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Entity
@Table(name = "levels")
public class LevelEntity extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private int number;

    @OneToMany(mappedBy = "level")
    private Collection<UserEntity> users;

    public LevelEntity() {
        super();
    }

    public LevelEntity(int number) {
        this.number = number;
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

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }
}
