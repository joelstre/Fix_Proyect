package com.Tienda.service;

// Los metodos para poder hacer un CRUD

import com.Tienda.domain.Articulo;
import java.util.List;

//Create Read Update Delete

public interface ArticuloService {

public List<Articulo> getArticulos(boolean activos);

public Articulo getArticulo ( Articulo articulo);

public void save (Articulo articulo);

public void delete(Articulo articulo);
    
}
