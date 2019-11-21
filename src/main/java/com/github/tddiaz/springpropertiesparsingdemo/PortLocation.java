package com.github.tddiaz.springpropertiesparsingdemo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class PortLocation {
    private String locationName;
    private String compassLocationCode;
    private String spName;
    private String spCode;
}
