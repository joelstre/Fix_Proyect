package com.Tienda.Controller;

import com.Tienda.domain.Articulo;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {
    
    @Autowired //cuando se use indexcontroller si existe un objeto articulo dao que lo use sino que lo crea
    private ArticuloService articuloService;
    
    @Autowired //cuando se use indexcontroller si existe un objeto articulo dao que lo use sino que lo crea
    private CategoriaService categoriaService;
    
       @GetMapping("/articulo/listado")
    public String inicio(Model model) {

       var Articulos = articuloService.getArticulos(false);
        
        model.addAttribute("Articulos", Articulos);
        return "/articulo/listado";

    }
    
    

    @GetMapping("/articulo/nuevo")
    public String articuloNuevo(Articulo articulo) {      
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String articuloGuardar(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/actualiza/{idArticulo}")
    public String articuloActualiza(Articulo articulo, Model model) {  
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo",articulo);
        
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        
        return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/elimina/{idArticulo}")
    public String articuloElimina(Articulo articulo) {  
        articuloService.delete(articulo);
       
        return "redirect:/articulo/listado";
    }
    
}
