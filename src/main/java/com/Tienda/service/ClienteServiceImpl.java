package com.Tienda.service;

// Los metodos para poder hacer un CRUD
//Autowired Provoca que si el objeto ya esta en memoria no se crea y usa ese
// si no esta en memoria se crea el objeto
import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Create Read Update Delete
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getCliente() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {

        return clienteDao.findById(cliente.getIdCliente()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        clienteDao.save(cliente);
        
    }

    @Override
@Transactional
    public void delete(Cliente cliente){
    clienteDao.delete(cliente);
    }

}
