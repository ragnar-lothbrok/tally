package com.home.jsonconversion;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Vertical implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer verticalId;
    private String name;
//    private Integer id;

//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getId() {
//        return id;
//    }

    public Integer getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(Integer verticalId) {
        this.verticalId = verticalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vertical [verticalId=" + verticalId + ", name=" + name /*+ ", id=" + id */+ "]";
    }

}
