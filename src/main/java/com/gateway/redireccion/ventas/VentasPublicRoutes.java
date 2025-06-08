package com.gateway.redireccion.ventas;

public class VentasPublicRoutes {
    public static final String[] VENTAS_PUBLIC_GET = {
        "/api/proxy/ventas",
        "/api/proxy/ventas/"
    };

    public static final String[] VENTAS_PUBLIC_GET_ID = {
        "/api/proxy/ventas/{id}",
        "/api/proxy/ventas/{id}/"
    };

    public static final String[] VENTAS_PUBLIC_GET_ID_CLIENTE = {
        "/api/proxy/ventas/cliente/{idCliente}",
        "/api/proxy/ventas/cliente/{idCliente}/"
    };

    public static final String[] VENTAS_PUBLIC_POST = {
        "/api/proxy/ventas",
        "/api/proxy/ventas/"
    };

    public static final String[] VENTAS_PUBLIC_POST_ID = {
        "/api/proxy/ventas/{id}",
        "/api/proxy/ventas/{id}/"
    };

    public static final String[] VENTAS_PUBLIC_PUT = {
        "/api/proxy/ventas",
        "/api/proxy/ventas/"
    };

    public static final String[] VENTAS_PUBLIC_DELETE = {
        "/api/proxy/ventas",
        "/api/proxy/ventas/"
    };
}
