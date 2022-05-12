package com.example.xaridor.xodim.controller;

import com.example.xaridor.xodim.model.Xaridor;
import com.example.xaridor.xodim.servis.XaridorServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("xaridor")
public class xodimController {
@Autowired
    XaridorServis xaridorServis;
    @PostMapping("/joylash")
        public String xaridorQoshish(@RequestBody Xaridor xaridor){
            return xaridorServis.addXaridor(xaridor);
        }
    @GetMapping(value = "/get")
        public List<Xaridor> view(){
            return xaridorServis.read();
        }
    @GetMapping(value = "/get2/{id}")
    public Xaridor oqish(@PathVariable Integer id){
        return xaridorServis.oqishId(id);
    }
    @PutMapping(value = "/edit/{id}")
    public String update(@PathVariable Integer id,@RequestBody Xaridor xaridor){
        return xaridorServis.update2(id,xaridor);
    }
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        return xaridorServis.delete2(id);
    }
}
