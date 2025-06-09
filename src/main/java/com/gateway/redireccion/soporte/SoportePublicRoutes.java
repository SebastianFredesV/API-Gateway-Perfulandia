package com.gateway.redireccion.soporte;

public class SoportePublicRoutes {
    public static final String[] SOPORTE_PUBLIC_GET = {
        "/api/proxy/soporte",
        "/api/proxy/soporte/"
    };

    public static final String[] SOPORTE_PUBLIC_GET_ID = {
        "/api/proxy/soporte/{id}",
        "/api/proxy/soporte/{id}/"
    };

    public static final String[] SOPORTE_PUBLIC_GET_CLIENTE_ID = {
        "/api/proxy/soporte/cliente/{idCliente}",
        "/api/proxy/soporte/cliente/{idCliente}/"
    };

    public static final String[] SOPORTE_PUBLIC_POST = {
        "/api/proxy/soporte",
        "/api/proxy/soporte/"
    };

    public static final String[] SOPORTE_PUBLIC_PUT_ESTADO = {
        "/api/proxy/soporte/{id}/estado",
        "/api/proxy/soporte/{id}/estado/"
    };

}
