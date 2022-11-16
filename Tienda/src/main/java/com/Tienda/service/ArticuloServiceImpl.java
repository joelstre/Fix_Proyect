package com.Tienda.service;
import com.Tienda.dao.ArticuloDao;
import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Create Read Update Delete
@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean filtro) {
        var lista = (List<Articulo>) articuloDao.findAll();
        
        if(filtro){
        
         lista.removeIf(e -> !e.isActivo());//Remueva los elementos que nop esten activos    
            
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {

        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Articulo articulo) {

        articuloDao.save(articulo);
        
    }

    @Override
@Transactional
    public void delete(Articulo articulo){
    articuloDao.delete(articulo);
    }

}
