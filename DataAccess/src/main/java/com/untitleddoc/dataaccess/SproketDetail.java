/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Novikov
 */
@Entity
@XmlRootElement
@ToString(exclude = {"sproket"})
@NamedQueries({
	@NamedQuery(name = "Sproketdetail.findAll", query = "SELECT s FROM SproketDetail s"),
	@NamedQuery(name = "Sproketdetail.findByTooth", query = "SELECT s FROM SproketDetail s WHERE s.tooth = :tooth"),
	@NamedQuery(name = "Sproketdetail.findByIdsproket", query = "SELECT s FROM SproketDetail s WHERE s.sproketDetailPK.idSproket = :idsproket"),
	@NamedQuery(name = "Sproketdetail.findByToothindex", query = "SELECT s FROM SproketDetail s WHERE s.sproketDetailPK.toothIndex = :toothindex")})
public class SproketDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@Getter
	@Setter
	protected SproketDetailPK sproketDetailPK;
	@Getter
	@Setter
	private Integer tooth;
	@JoinColumn(name = "IDSPROKET", referencedColumnName = "IDSPROKET", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	@Getter
	@Setter
	private Sproket sproket;

	public SproketDetail() {
	}

	public SproketDetail(SproketDetailPK sproketdetailPK) {
		this.sproketDetailPK = sproketdetailPK;
	}

	public SproketDetail(int idsproket, int toothindex) {
		this.sproketDetailPK = new SproketDetailPK(idsproket, toothindex);
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sproketDetailPK != null ? sproketDetailPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SproketDetail)) {
			return false;
		}
		SproketDetail other = (SproketDetail) object;
		if ((this.sproketDetailPK == null && other.sproketDetailPK != null) || (this.sproketDetailPK != null && !this.sproketDetailPK.equals(other.sproketDetailPK))) {
			return false;
		}
		return true;
	}

}
