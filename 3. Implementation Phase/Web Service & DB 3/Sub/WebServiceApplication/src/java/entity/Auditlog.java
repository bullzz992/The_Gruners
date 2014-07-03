/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

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
@Table(name = "auditlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditlog.findAll", query = "SELECT a FROM Auditlog a"),
    @NamedQuery(name = "Auditlog.findByLogId", query = "SELECT a FROM Auditlog a WHERE a.logId = :logId"),
    @NamedQuery(name = "Auditlog.findByDate", query = "SELECT a FROM Auditlog a WHERE a.date = :date"),
    @NamedQuery(name = "Auditlog.findByTableAccessed", query = "SELECT a FROM Auditlog a WHERE a.tableAccessed = :tableAccessed"),
    @NamedQuery(name = "Auditlog.findByAction", query = "SELECT a FROM Auditlog a WHERE a.action = :action"),
    @NamedQuery(name = "Auditlog.findByOldRow", query = "SELECT a FROM Auditlog a WHERE a.oldRow = :oldRow"),
    @NamedQuery(name = "Auditlog.findByNewRow", query = "SELECT a FROM Auditlog a WHERE a.newRow = :newRow")})
public class Auditlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "table_accessed")
    private String tableAccessed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "oldRow")
    private String oldRow;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "newRow")
    private String newRow;

    public Auditlog() {
    }

    public Auditlog(Integer logId) {
        this.logId = logId;
    }

    public Auditlog(Integer logId, Date date, String tableAccessed, String action, String oldRow, String newRow) {
        this.logId = logId;
        this.date = date;
        this.tableAccessed = tableAccessed;
        this.action = action;
        this.oldRow = oldRow;
        this.newRow = newRow;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTableAccessed() {
        return tableAccessed;
    }

    public void setTableAccessed(String tableAccessed) {
        this.tableAccessed = tableAccessed;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOldRow() {
        return oldRow;
    }

    public void setOldRow(String oldRow) {
        this.oldRow = oldRow;
    }

    public String getNewRow() {
        return newRow;
    }

    public void setNewRow(String newRow) {
        this.newRow = newRow;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditlog)) {
            return false;
        }
        Auditlog other = (Auditlog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Auditlog[ logId=" + logId + " ]";
    }
    
}
