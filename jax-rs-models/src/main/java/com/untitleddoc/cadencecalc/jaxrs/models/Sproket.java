/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Novikov
 */
@XmlRootElement
@Data
@AllArgsConstructor
public class Sproket implements Serializable, IC2Model {

    private static final long serialVersionUID = -6668484495934477324L;

    private String name;
    private List<Double> tooths;

    public Sproket() {
    }

	@Override
    public String displayValue() {
        String str = "";
        str += getName();
        str += " (";
        str += new BigDecimal(tooths.get(0)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        str += "-";
        str += new BigDecimal(tooths.get(tooths.size()-1)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        str += ")";
        return str;
    }
}
