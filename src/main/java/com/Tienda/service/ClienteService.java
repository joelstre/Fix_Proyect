package com.Tienda.service;

// Los metodos para poder hacer un CRUD

import com.Tienda.domain.Cliente;
import java.util.List;

//Create Read Update Delete

public interface ClienteService {

public List<Cliente> getCliente();

public Cliente getCliente (Cliente cliente);

public void save (Cliente cliente);

public void delete(Cliente cliente);
    
}
