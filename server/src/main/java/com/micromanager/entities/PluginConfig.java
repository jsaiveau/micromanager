package com.micromanager.entities;

import javax.persistence.*;

//@Entity
//@Table(name = "plugin_config")
public class PluginConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pluginName;

    private String key;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PluginConfig{" +
                "id=" + id +
                ", pluginName='" + pluginName + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public PluginConfig(String pluginName, String key, String value) {
        this.pluginName = pluginName;
        this.key = key;
        this.value = value;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    private String value;

    public PluginConfig() {
    }


}