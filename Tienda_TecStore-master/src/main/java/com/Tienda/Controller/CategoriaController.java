package com.Tienda.Controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    
    @Autowired //cuando se use indexcontroller si existe un objeto cliente dao que lo use sino que lo crea
    private ClienteService clienteService;
    
    
       @GetMapping("/cliente/listado")
    public String inicio(Model model) {

       var Clientes = clienteService.getCliente();
        
        model.addAttribute("Clientes", Clientes);
        return "/cliente/listado";

    }
    
    

    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {      
        return "/cliente/modificar";
    }
    
    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/actualiza/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model) {  
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "/cliente/modificar";
    }
    
    @GetMapping("/cliente/elimina/{idCliente}")
    public String clienteElimina(Cliente cliente) {  
        clienteService.delete(cliente);
       
        return "redirect:/cliente/listado";
    }
    
}
