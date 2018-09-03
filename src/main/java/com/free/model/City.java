package com.free.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Table(name = "city")

public class City implements Serializable {
    private static final long serialVersionUID = -474427187317051116L;
    @Id
    private Long id;

    @Column(name = "province_code")
    private String provinceCode;

    @Column(name = "city_name")
    private String cityName;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static City toObject(Map<String, Object> map) {
        City city = new City();
        city.setId((Long) map.get("id"));
        city.setProvinceCode((String) map.get("province_code"));
        city.setCityName((String) map.get("city_name"));
        city.setDescription((String) map.get("description"));
        return city;
    }

    public static List<City> toObject(List<Map<String, Object>> lists){
        List<City> list = new ArrayList<>();
        for (Map<String, Object> map : lists) {
            City info =  City.toObject(map);
            if (info != null) {
                list.add(info);
            }
        }
        return list;
    }
}
