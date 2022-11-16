package com.Tienda.Controller;

import com.Tienda.service.ArticuloService;
import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired //cuando se use indexcontroller si existe un objeto cliente dao que lo use sino que lo crea
    private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {

       var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";

    }
}
