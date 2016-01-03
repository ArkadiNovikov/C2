/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Novikov
 */
@Embeddable
@ToString
@EqualsAndHashCode
public class SproketDetailPK implements Serializable {

	@Basic(optional = false)
    @NotNull
	@Getter
	@Setter
	private int idSproket;
	@Basic(optional = false)
    @NotNull
	@Getter
	@Setter
	private int toothIndex;

	public SproketDetailPK() {
	}

	public SproketDetailPK(int idsproket, int toothindex) {
		this.idSproket = idsproket;
		this.toothIndex = toothindex;
	}
}
