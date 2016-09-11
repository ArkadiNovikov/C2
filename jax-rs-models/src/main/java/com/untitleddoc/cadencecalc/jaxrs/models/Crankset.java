/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs.models;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Novikov
 */
@XmlRootElement
@Data
public class Crankset implements Serializable{

    private static final long serialVersionUID = -6512261512456314356L;

    private String name;
    private int outerGearTooth;
    private int middleGearTooth;
    private int innerGearTooth;

    public Crankset() {
    }
    
    public String getDisplayValue()
    {
        return getName() + " (" + getOuterGearTooth() + " - " + (getMiddleGearTooth() != 0 ? getMiddleGearTooth() + " - " : "") + getInnerGearTooth() + ")";
    }
}
