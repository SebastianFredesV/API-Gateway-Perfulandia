package com.gateway.redireccion.inventario;

public class InventarioPublicRoutes {
    public static final String[] INVENTARIO_PUBLIC_GET = {
        "/api/proxy/inventario",
        "/api/proxy/inventario/"
    };

    public static final String[] INVENTARIO_PUBLIC_GET_ID = {
        "/api/proxy/inventario/{id}",
        "/api/proxy/inventario/{id}/"
    };

    public static final String[] INVENTARIO_PUBLIC_GET_ID_PRODUCTO = {
        "/api/proxy/inventario/producto/{idProducto}",
        "/api/proxy/inventario/producto/{idProducto}/"
    };

    public static final String[] INVENTARIO_PUBLIC_POST = {
        "/api/proxy/inventario",
        "/api/proxy/inventario/"
    };

    public static final String[] INVENTARIO_PUBLIC_PUT = {
        "/api/proxy/inventario/ajuste/{id}",
        "/api/proxy/inventario/ajuste/{id}/"
    };

    public static final String[] INVENTARIO_PUBLIC_DELETE = {
        "/api/proxy/inventario/{id}",
        "/api/proxy/inventario/{id}/"
    };
}
