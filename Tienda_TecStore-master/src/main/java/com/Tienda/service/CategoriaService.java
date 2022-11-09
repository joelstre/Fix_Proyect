package com.Tienda.service;

// Los metodos para poder hacer un CRUD

import com.Tienda.domain.Categoria;
import java.util.List;

//Create Read Update Delete

public interface CategoriaService {

public List<Categoria> getCategorias(boolean activos);

public Categoria getCategoria (Categoria categoria);

public void save (Categoria categoria);

public void delete(Categoria categoria);
    
}
