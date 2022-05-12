package com.example.xaridor.xodim.repository;

import com.example.xaridor.xodim.model.Xaridor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface XaridorRepository extends JpaRepository<Xaridor,Integer> {
    boolean existsByTelNomer(String telNomer);

}
