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
public class Perimeter implements Serializable {

    private static final long serialVersionUID = 165573926447503641L;
    
    private String etrto;
    private String french;
    private int perimeterValue;

    public Perimeter() {
    }

    public String getDisplayValue()
    {
        return getEtrto() + " (" + getFrench() + ")";
    }

}
