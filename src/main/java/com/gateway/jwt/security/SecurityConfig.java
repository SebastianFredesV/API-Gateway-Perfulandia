package com.gateway.jwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.gateway.jwt.security.PublicRoutes.PUBLIC_GET;
import static com.gateway.jwt.security.PublicRoutes.PUBLIC_POST; // Asegúrate de importar esto arriba
import static com.gateway.redireccion.clientes.ClientesPublicRoutes.CLIENTES_PUBLIC_GET; //importa las rutas publicas de jwt
import static com.gateway.redireccion.cupones.CuponesPublicRoutes.CUPONES_PUBLIC_POST; //importa las rutas publicas de API Gateway
import static com.gateway.redireccion.gestion.GestionPublicRoutes.GESTION_PUBLIC_GET; //importa las rutas publicas de API Productos

import com.gateway.redireccion.envios.EnviosPublicRoutes;
import com.gateway.redireccion.inventario.InventarioPublicRoutes; //importa las rutas publicas de API Clientes
import com.gateway.redireccion.soporte.SoportePublicRoutes;
import com.gateway.redireccion.vendedores.VendedoresPublicRoutes;

import static com.gateway.redireccion.productos.ProductosPublicRoutes.PRODUCTOS_PUBLIC_GET; //importa las rutas publicas de API Cupones
import com.gateway.redireccion.ventas.VentasPublicRoutes; //importa las rutas publicas de API Inventario

import lombok.RequiredArgsConstructor; //importa las rutas publicas de API Ventas

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // URL públicas JWT
                .requestMatchers(HttpMethod.POST, PUBLIC_POST).permitAll() // rutas publicas POST de PublicRoutes de JWT
                .requestMatchers(HttpMethod.GET, PUBLIC_GET).permitAll() // rutas publicas GET de PublicRoutes de JWT

                // URL públicas API Gestion
                .requestMatchers(HttpMethod.GET, GESTION_PUBLIC_GET).permitAll()   // lista pública api GESTION GET

                // URL públicas API Productos
                .requestMatchers(HttpMethod.GET, PRODUCTOS_PUBLIC_GET).permitAll()   // lista pública api Productos GET

                // URL públicas API Clientes
                .requestMatchers(HttpMethod.GET, CLIENTES_PUBLIC_GET).permitAll()   // lista pública api Clientes GET

                // URL públicas API Ventas
                .requestMatchers(HttpMethod.GET, VentasPublicRoutes.VENTAS_PUBLIC_GET).permitAll()
                .requestMatchers(HttpMethod.POST, VentasPublicRoutes.VENTAS_PUBLIC_POST).permitAll()
                .requestMatchers(HttpMethod.PUT, VentasPublicRoutes.VENTAS_PUBLIC_PUT).permitAll()
                .requestMatchers(HttpMethod.DELETE, VentasPublicRoutes.VENTAS_PUBLIC_DELETE).permitAll()
                .requestMatchers(HttpMethod.GET, VentasPublicRoutes.VENTAS_PUBLIC_GET_ID).permitAll()
                .requestMatchers(HttpMethod.GET, VentasPublicRoutes.VENTAS_PUBLIC_GET_ID_CLIENTE).permitAll()
                .requestMatchers(HttpMethod.POST, CUPONES_PUBLIC_POST).permitAll()

                // URL públicas API Inventario
                .requestMatchers(HttpMethod.GET, InventarioPublicRoutes.INVENTARIO_PUBLIC_GET).permitAll()
                .requestMatchers(HttpMethod.GET, InventarioPublicRoutes.INVENTARIO_PUBLIC_GET_ID).permitAll()
                .requestMatchers(HttpMethod.GET, InventarioPublicRoutes.INVENTARIO_PUBLIC_GET_ID_PRODUCTO).permitAll()
                .requestMatchers(HttpMethod.POST, InventarioPublicRoutes.INVENTARIO_PUBLIC_POST).permitAll()
                .requestMatchers(HttpMethod.PUT, InventarioPublicRoutes.INVENTARIO_PUBLIC_PUT).permitAll()
                .requestMatchers(HttpMethod.DELETE, InventarioPublicRoutes.INVENTARIO_PUBLIC_DELETE).permitAll()

                // URL públicas API Vendedores
                .requestMatchers(HttpMethod.GET, VendedoresPublicRoutes.VENDEDORES_PUBLIC_GET).permitAll()
                .requestMatchers(HttpMethod.GET, VendedoresPublicRoutes.VENDEDORES_PUBLIC_GET_ID).permitAll()
                .requestMatchers(HttpMethod.POST, VendedoresPublicRoutes.VENDEDORES_PUBLIC_POST).permitAll()
                .requestMatchers(HttpMethod.PUT, VendedoresPublicRoutes.VENDEDORES_PUBLIC_PUT).permitAll()
                .requestMatchers(HttpMethod.DELETE, VendedoresPublicRoutes.VENDEDORES_PUBLIC_DELETE).permitAll()

                // URL públicas API Envios
                .requestMatchers(HttpMethod.GET, EnviosPublicRoutes.ENVIOS_PUBLIC_GET).permitAll()
                .requestMatchers(HttpMethod.GET, EnviosPublicRoutes.ENVIOS_PUBLIC_GET_ID).permitAll()
                .requestMatchers(HttpMethod.POST, EnviosPublicRoutes.ENVIOS_PUBLIC_POST).permitAll()
                .requestMatchers(HttpMethod.PUT, EnviosPublicRoutes.ENVIOS_PUBLIC_PUT).permitAll()
                .requestMatchers(HttpMethod.DELETE, EnviosPublicRoutes.ENVIOS_PUBLIC_DELETE).permitAll()

                // URL públicas API Soporte
                .requestMatchers(HttpMethod.GET, SoportePublicRoutes.SOPORTE_PUBLIC_GET).permitAll()
                .requestMatchers(HttpMethod.GET, SoportePublicRoutes.SOPORTE_PUBLIC_GET_ID).permitAll()
                .requestMatchers(HttpMethod.GET, SoportePublicRoutes.SOPORTE_PUBLIC_GET_CLIENTE_ID).permitAll()
                .requestMatchers(HttpMethod.POST, SoportePublicRoutes.SOPORTE_PUBLIC_POST).permitAll()
                .requestMatchers(HttpMethod.PUT, SoportePublicRoutes.SOPORTE_PUBLIC_PUT_ESTADO).permitAll()

                // Otras URL Token obligatorio
                .anyRequest().authenticated()

            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
