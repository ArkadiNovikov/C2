/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs.models;

import java.io.Serializable;
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
public class Sproket implements Serializable {

    private static final long serialVersionUID = -6668484495934477324L;

    private String name;
    private List<Integer> tooths;

    public Sproket() {
    }

    public String displayValue() {
        String str = "";
        str += getName();
        str += " (";
        str += tooths.get(0);
        str += "-";
        str += tooths.get(tooths.size()-1);
        str += ")";
        return str;
    }
}
