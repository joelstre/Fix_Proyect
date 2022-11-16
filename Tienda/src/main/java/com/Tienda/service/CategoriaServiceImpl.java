package com.Tienda.service;

// Los metodos para poder hacer un CRUD
//Autowired Provoca que si el objeto ya esta en memoria no se crea y usa ese
// si no esta en memoria se crea el objeto
import com.Tienda.dao.CategoriaDao;
import com.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Create Read Update Delete
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean filtro) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        
        if(filtro){
        
         lista.removeIf(e -> !e.isActivo());//Remueva los elementos que nop esten activos    
            
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {

        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Categoria categoria) {

        categoriaDao.save(categoria);
        
    }

    @Override
@Transactional
    public void delete(Categoria categoria){
    categoriaDao.delete(categoria);
    }

}
