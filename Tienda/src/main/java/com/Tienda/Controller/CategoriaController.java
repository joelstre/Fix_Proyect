package com.Tienda.Controller;

import com.Tienda.domain.Categoria;
import com.Tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    
    @Autowired //cuando se use indexcontroller si existe un objeto categoria dao que lo use sino que lo crea
    private CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {

       var Categorias = categoriaService.getCategorias(false); 
        model.addAttribute("Categorias", Categorias);
        return "/categoria/listado";

    }
    

    @GetMapping("/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria) {      
        return "/categoria/modificar";
    }
    
    @PostMapping("/categoria/guardar")
    public String categoriaGuardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/actualiza/{idCategoria}")
    public String categoriaActualiza(Categoria categoria, Model model) {  
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria",categoria);
        return "/categoria/modificar";
    }
    
    @GetMapping("/categoria/elimina/{idCategoria}")
    public String categoriaElimina(Categoria categoria) {  
        categoriaService.delete(categoria);
       
        return "redirect:/categoria/listado";
    }
    
}
