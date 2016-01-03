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

/**
 *
 * @author Novikov
 */
@Entity
@XmlRootElement
@ToString
@NamedQueries({
	@NamedQuery(name = "Perimeter.findAll", query = "SELECT p FROM Perimeter p"),
	@NamedQuery(name = "Perimeter.findByIdPerimeter", query = "SELECT p FROM Perimeter p WHERE p.idPerimeter = :idPerimeter"),
	@NamedQuery(name = "Perimeter.findByEtrto", query = "SELECT p FROM Perimeter p WHERE p.etrto = :etrto"),
	@NamedQuery(name = "Perimeter.findByFrench", query = "SELECT p FROM Perimeter p WHERE p.french = :french"),
	@NamedQuery(name = "Perimeter.findByPerimeterValue", query = "SELECT p FROM Perimeter p WHERE p.perimeterValue = :perimeterValue")})
public class Perimeter implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Getter
	@Setter
	private Integer idPerimeter;
	@Size(max = 255)
	@Getter
	@Setter
	private String etrto;
	@Size(max = 255)
	@Getter
	@Setter
	private String french;
	@Basic(optional = false)
    @NotNull
	@Getter
	@Setter
	private int perimeterValue;

	public Perimeter() {
	}

	public Perimeter(Integer idperimeter) {
		this.idPerimeter = idperimeter;
	}

	public Perimeter(Integer idperimeter, int perimetervalue) {
		this.idPerimeter = idperimeter;
		this.perimeterValue = perimetervalue;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPerimeter != null ? idPerimeter.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Perimeter)) {
			return false;
		}
		Perimeter other = (Perimeter) object;
		if ((this.idPerimeter == null && other.idPerimeter != null) || (this.idPerimeter != null && !this.idPerimeter.equals(other.idPerimeter))) {
			return false;
		}
		return true;
	}
}
