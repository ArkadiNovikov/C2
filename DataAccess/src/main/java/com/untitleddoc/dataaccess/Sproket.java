/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Novikov
 */
@Entity
@XmlRootElement
@ToString(exclude = {"sproketdetailCollection"})
@NamedQueries({
	@NamedQuery(name = "Sproket.findAll", query = "SELECT s FROM Sproket s"),
	@NamedQuery(name = "Sproket.findByIdsproket", query = "SELECT s FROM Sproket s WHERE s.idSproket = :idSproket"),
	@NamedQuery(name = "Sproket.findByName", query = "SELECT s FROM Sproket s WHERE s.name = :name")})
public class Sproket implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Getter
	@Setter
	private Integer idSproket;
	@Size(max = 255)
	@Getter
	@Setter
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sproket", fetch = FetchType.EAGER)
	private Collection<SproketDetail> sproketdetailCollection;

	public Sproket() {
	}

	public Sproket(Integer idsproket) {
		this.idSproket = idsproket;
	}

	@XmlTransient
	public Collection<SproketDetail> getSproketdetailCollection() {
		return sproketdetailCollection;
	}

	public void setSproketdetailCollection(Collection<SproketDetail> sproketdetailCollection) {
		this.sproketdetailCollection = sproketdetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idSproket != null ? idSproket.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Sproket)) {
			return false;
		}
		Sproket other = (Sproket) object;
		if ((this.idSproket == null && other.idSproket != null) || (this.idSproket != null && !this.idSproket.equals(other.idSproket))) {
			return false;
		}
		return true;
	}
}
