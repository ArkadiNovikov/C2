/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs.models;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Novikov
 */
@XmlRootElement
@Data
public class Sproket implements Serializable {

    private static final long serialVersionUID = -6668484495934477324L;

    private String name;
    private List<Integer> tooths;

    public Sproket() {
    }

    public String getDisplayValue() {
        String str = "";
        str += getName();
        str += " (";
        str += getTooths().stream().min((a, b) -> Integer.compare(a, b)).get();
        str += "-";
        str += getTooths().stream().max((a, b) -> Integer.compare(a, b)).get();
        str += ")";
        return str;
    }
}
