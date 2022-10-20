package com.Tienda.Controller;

import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired //cuando se use indexcontroller si existe un objeto cliente dao que lo use sino que lo crea
    private ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {

       /* String texto = "Estamos en semana 4";
        model.addAttribute("saludo", texto);
        
        Cliente cliente1 = new Cliente("Johel", "Sanchez Goussen", "joeldariosg15@gmail.com", "71356834");
        Cliente cliente2 = new Cliente("Pedro", "Jimenez Retana", "joeldariosg@gmail.com", "83212218");

         var Clientes = Arrays.asList(cliente1,cliente2);*/
       
       var Clientes = clienteService.getCliente();
        
        model.addAttribute("Clientes", Clientes);
        return "index";

    }
}
