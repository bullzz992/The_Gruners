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
@Table(name = "vehiclefeatures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiclefeatures.findAll", query = "SELECT v FROM Vehiclefeatures v"),
    @NamedQuery(name = "Vehiclefeatures.findByFeatureId", query = "SELECT v FROM Vehiclefeatures v WHERE v.featureId = :featureId"),
    @NamedQuery(name = "Vehiclefeatures.findByMake", query = "SELECT v FROM Vehiclefeatures v WHERE v.make = :make"),
    @NamedQuery(name = "Vehiclefeatures.findByType", query = "SELECT v FROM Vehiclefeatures v WHERE v.type = :type"),
    @NamedQuery(name = "Vehiclefeatures.findByModel", query = "SELECT v FROM Vehiclefeatures v WHERE v.model = :model"),
    @NamedQuery(name = "Vehiclefeatures.findByColour", query = "SELECT v FROM Vehiclefeatures v WHERE v.colour = :colour")})
public class Vehiclefeatures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "feature_id")
    private Integer featureId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "make")
    private String make;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "colour")
    private String colour;

    public Vehiclefeatures() {
    }

    public Vehiclefeatures(Integer featureId) {
        this.featureId = featureId;
    }

    public Vehiclefeatures(Integer featureId, String make, String type, String model, String colour) {
        this.featureId = featureId;
        this.make = make;
        this.type = type;
        this.model = model;
        this.colour = colour;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (featureId != null ? featureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiclefeatures)) {
            return false;
        }
        Vehiclefeatures other = (Vehiclefeatures) object;
        if ((this.featureId == null && other.featureId != null) || (this.featureId != null && !this.featureId.equals(other.featureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vehiclefeatures[ featureId=" + featureId + " ]";
    }
    
}
