/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jay
 */
@Entity
@Table(name = "detection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detection.findAll", query = "SELECT d FROM Detection d"),
    @NamedQuery(name = "Detection.findByDetectionId", query = "SELECT d FROM Detection d WHERE d.detectionId = :detectionId"),
    @NamedQuery(name = "Detection.findByDate", query = "SELECT d FROM Detection d WHERE d.date = :date"),
    @NamedQuery(name = "Detection.findByLocation", query = "SELECT d FROM Detection d WHERE d.location = :location"),
    @NamedQuery(name = "Detection.findByDeviceIp", query = "SELECT d FROM Detection d WHERE d.deviceIp = :deviceIp"),
    @NamedQuery(name = "Detection.findByFeatureId", query = "SELECT d FROM Detection d WHERE d.featureId = :featureId")})
public class Detection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "detection_id")
    private Integer detectionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "device_ip")
    private String deviceIp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feature_id")
    private int featureId;

    public Detection() {
    }

    public Detection(Integer detectionId) {
        this.detectionId = detectionId;
    }

    public Detection(Integer detectionId, Date date, String location, String deviceIp, int featureId) {
        this.detectionId = detectionId;
        this.date = date;
        this.location = location;
        this.deviceIp = deviceIp;
        this.featureId = featureId;
    }

    public Integer getDetectionId() {
        return detectionId;
    }

    public void setDetectionId(Integer detectionId) {
        this.detectionId = detectionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detectionId != null ? detectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detection)) {
            return false;
        }
        Detection other = (Detection) object;
        if ((this.detectionId == null && other.detectionId != null) || (this.detectionId != null && !this.detectionId.equals(other.detectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detection[ detectionId=" + detectionId + " ]";
    }
    
}