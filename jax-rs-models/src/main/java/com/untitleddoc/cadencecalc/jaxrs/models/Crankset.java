/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs.models;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Crankset implements Serializable {

    private static final long serialVersionUID = -6512261512456314356L;

    private String name;
	private String manufacture;
    private List<Integer> tooths;

    public Crankset() {
	}

    public String displayValue() {
        List<String> stooths = new ArrayList<>();
		tooths.stream().forEach((i) -> {
			stooths.add(i.toString());
		});
        return getName() + " (" + String.join("-", stooths) + ")";
    }
}

