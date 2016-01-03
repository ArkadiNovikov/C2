/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Novikov
 */
@Entity
@XmlRootElement
@ToString
@NamedQueries({
	@NamedQuery(name = "Crankset.findAll", query = "SELECT c FROM Crankset c"),
	@NamedQuery(name = "Crankset.findByIdCrankset", query = "SELECT c FROM Crankset c WHERE c.idCrankset = :idCrankset"),
	@NamedQuery(name = "Crankset.findByName", query = "SELECT c FROM Crankset c WHERE c.name = :name"),
	@NamedQuery(name = "Crankset.findByOuterGearTooth", query = "SELECT c FROM Crankset c WHERE c.outerGearTooth = :outerGearTooth"),
	@NamedQuery(name = "Crankset.findByMiddleGearTooth", query = "SELECT c FROM Crankset c WHERE c.middleGearTooth = :middleGearTooth"),
	@NamedQuery(name = "Crankset.findByInnerGearTooth", query = "SELECT c FROM Crankset c WHERE c.innerGearTooth = :innerGearTooth")})
public class Crankset implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Getter
	@Setter
	private Integer idCrankset;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private Integer outerGearTooth;
	@Getter
	@Setter
	private Integer middleGearTooth;
	@Getter
	@Setter
	private Integer innerGearTooth;

	public Crankset() {
	}

	public Crankset(Integer idCrankset) {
		this.idCrankset = idCrankset;
	}

	public Crankset(Integer idCrankset, String name) {
		this.idCrankset = idCrankset;
		this.name = name;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCrankset != null ? idCrankset.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Crankset)) {
			return false;
		}
		Crankset other = (Crankset) object;
		if ((this.idCrankset == null && other.idCrankset != null) || (this.idCrankset != null && !this.idCrankset.equals(other.idCrankset))) {
			return false;
		}
		return true;
	}
}
