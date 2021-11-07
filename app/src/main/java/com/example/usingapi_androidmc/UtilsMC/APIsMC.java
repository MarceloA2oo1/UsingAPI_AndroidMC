package com.example.usingapi_androidmc.UtilsMC;

import com.example.usingapi_androidmc.ControllersMC.UserMC;

public class APIsMC {
    public static final String URL_001 = "http://192.168.0.11:8080/notas/";

    public static NotasServiceMC getNotasServiceMC(){
        return UserMC.getUserMC(URL_001).create(NotasServiceMC.class);
    }
}
