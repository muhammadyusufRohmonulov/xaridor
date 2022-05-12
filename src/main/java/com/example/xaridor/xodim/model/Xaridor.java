package com.example.xaridor.xodim.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Xaridor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false)
    private String ismi;
    @Column (nullable = false)
    private String familyasi;
    @Column (nullable = false,unique = true)
    private String telNomer;
    @Column (nullable = false)
    private String manzil;

}
