package by.cromwell.fastcache.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cache")
public class CacheItem {

    @Id
    @Column(name = "key", unique = true, nullable = false)
    private String key;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String value;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "key is " + getKey() + " value is " + getValue();
    }

}
