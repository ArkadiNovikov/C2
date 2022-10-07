/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs.models;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Novikov
 */
@XmlRootElement
@Data
@AllArgsConstructor
public class Crankset implements Serializable, IC2Model {

    private static final long serialVersionUID = -6512261512456314356L;

    private String name;
    private String manufacture;
    private List<Integer> tooths;

    public Crankset() {
	}

	@Override
    public String displayValue() {
        final List<String> stooths = Lists.transform(tooths, String::valueOf);
        return getName() + " (" + String.join("-", stooths) + ")";
    }
}

