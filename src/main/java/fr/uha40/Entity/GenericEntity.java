package fr.uha40.Entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;

/**
 * GenericEntity
 * Package : fr.uha40.Entity
 * Created : 13/09/2016 10:50
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@MappedSuperclass
public abstract class GenericEntity {

    @Column(name = "creation_ts", updatable = false)
    private Timestamp dateCreaTech;

    @Column(name = "update_ts", insertable = false)
    private Timestamp dateMajTech;

    @PrePersist
    void onCreate() {
        this.setDateCreaTech(new Timestamp(new Date().getTime()));
    }

    @PreUpdate
    void onPersist() {
        this.setDateMajTech(new Timestamp(new Date().getTime()));
    }

    public Timestamp getDateCreaTech() {
        return dateCreaTech;
    }

    public void setDateCreaTech(Timestamp dateCreaTech) {
        this.dateCreaTech = dateCreaTech;
    }

    public Timestamp getDateMajTech() {
        return dateMajTech;
    }

    public void setDateMajTech(Timestamp dateMajTech) {
        this.dateMajTech = dateMajTech;
    }
}
