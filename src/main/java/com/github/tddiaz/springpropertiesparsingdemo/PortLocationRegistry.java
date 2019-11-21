package com.github.tddiaz.springpropertiesparsingdemo;

import java.util.HashMap;
import java.util.Map;

public class PortLocationRegistry {

    private Map<String, PortLocation> portLocationMap = new HashMap<>();

    public void register(String key, PortLocation portLocation) {
        this.portLocationMap.put(key, portLocation);
    }

    public PortLocation get(String key) {
        return portLocationMap.get(key);
    }
}
