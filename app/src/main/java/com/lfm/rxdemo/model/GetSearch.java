package com.lfm.rxdemo.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "r"
})
public class GetSearch {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("r")
    private List<R> r = new ArrayList<R>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return The r
     */
    @JsonProperty("r")
    public List<R> getR() {
        return r;
    }

    /**
     * @param r The r
     */
    @JsonProperty("r")
    public void setR(List<R> r) {
        this.r = r;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}