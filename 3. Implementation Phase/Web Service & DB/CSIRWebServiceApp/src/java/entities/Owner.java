/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jay
 */
@Entity
@Table(name = "owner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o"),
    @NamedQuery(name = "Owner.findByOwnerId", query = "SELECT o FROM Owner o WHERE o.ownerId = :ownerId"),
    @NamedQuery(name = "Owner.findByName", query = "SELECT o FROM Owner o WHERE o.name = :name"),
    @NamedQuery(name = "Owner.findByType", query = "SELECT o FROM Owner o WHERE o.type = :type"),
    @NamedQuery(name = "Owner.findByAddress", query = "SELECT o FROM Owner o WHERE o.address = :address"),
    @NamedQuery(name = "Owner.findByIdOrRegNumber", query = "SELECT o FROM Owner o WHERE o.idOrRegNumber = :idOrRegNumber")})
public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "owner_id")
    private Integer ownerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id_or_reg_number")
    private String idOrRegNumber;

    public Owner() {
    }

    public Owner(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Owner(Integer ownerId, String name, String type, String address, String idOrRegNumber) {
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
        this.address = address;
        this.idOrRegNumber = idOrRegNumber;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdOrRegNumber() {
        return idOrRegNumber;
    }

    public void setIdOrRegNumber(String idOrRegNumber) {
        this.idOrRegNumber = idOrRegNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownerId != null ? ownerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.ownerId == null && other.ownerId != null) || (this.ownerId != null && !this.ownerId.equals(other.ownerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Owner[ ownerId=" + ownerId + " ]";
    }
    
}
