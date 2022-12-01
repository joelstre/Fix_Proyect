
package com.Tienda.dao;

import com.Tienda.domain.Cliente;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente,Long> {
}
