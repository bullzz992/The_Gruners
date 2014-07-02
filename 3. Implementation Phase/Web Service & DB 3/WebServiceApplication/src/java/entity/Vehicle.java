/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

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
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findByVehicleId", query = "SELECT v FROM Vehicle v WHERE v.vehicleId = :vehicleId"),
    @NamedQuery(name = "Vehicle.findByNumberPlate", query = "SELECT v FROM Vehicle v WHERE v.numberPlate = :numberPlate"),
    @NamedQuery(name = "Vehicle.findByOwnerId", query = "SELECT v FROM Vehicle v WHERE v.ownerId = :ownerId"),
    @NamedQuery(name = "Vehicle.findByFeatureId", query = "SELECT v FROM Vehicle v WHERE v.featureId = :featureId"),
    @NamedQuery(name = "Vehicle.findByStolen", query = "SELECT v FROM Vehicle v WHERE v.stolen = :stolen"),
    @NamedQuery(name = "Vehicle.findByFines", query = "SELECT v FROM Vehicle v WHERE v.fines = :fines"),
    @NamedQuery(name = "Vehicle.findByRoadworthy", query = "SELECT v FROM Vehicle v WHERE v.roadworthy = :roadworthy")})
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicle_id")
    private Integer vehicleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "number_plate")
    private String numberPlate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "owner_id")
    private int ownerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feature_id")
    private int featureId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "stolen")
    private String stolen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fines")
    private String fines;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "roadworthy")
    private String roadworthy;

    public Vehicle() {
    }

    public Vehicle(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Vehicle(Integer vehicleId, String numberPlate, int ownerId, int featureId, String stolen, String fines, String roadworthy) {
        this.vehicleId = vehicleId;
        this.numberPlate = numberPlate;
        this.ownerId = ownerId;
        this.featureId = featureId;
        this.stolen = stolen;
        this.fines = fines;
        this.roadworthy = roadworthy;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getStolen() {
        return stolen;
    }

    public void setStolen(String stolen) {
        this.stolen = stolen;
    }

    public String getFines() {
        return fines;
    }

    public void setFines(String fines) {
        this.fines = fines;
    }

    public String getRoadworthy() {
        return roadworthy;
    }

    public void setRoadworthy(String roadworthy) {
        this.roadworthy = roadworthy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleId != null ? vehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.vehicleId == null && other.vehicleId != null) || (this.vehicleId != null && !this.vehicleId.equals(other.vehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vehicle[ vehicleId=" + vehicleId + " ]";
    }
    
}
