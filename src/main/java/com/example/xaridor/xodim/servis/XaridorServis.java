package com.example.xaridor.xodim.servis;

import com.example.xaridor.xodim.model.Xaridor;
import com.example.xaridor.xodim.repository.XaridorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XaridorServis {
    @Autowired
    XaridorRepository xaridorRepository;
    public String addXaridor(Xaridor xaridor){
        boolean b = xaridorRepository.existsByTelNomer(xaridor.getTelNomer());
        if (b){
            return "Bunday Xaridor Mavjud";
        }
        Xaridor xaridor1 = new Xaridor();
        xaridor1.setFamilyasi(xaridor.getFamilyasi());
        xaridor1.setIsmi(xaridor.getIsmi());
        xaridor1.setTelNomer(xaridor.getTelNomer());
        xaridor1.setManzil(xaridor.getManzil());
        xaridorRepository.save(xaridor1);
        return "Xaridorning Malumotlari Bazaga Joylandi";
    }
    public List<Xaridor> read(){
        List<Xaridor> all = xaridorRepository.findAll();
        return all;
    }
    public Xaridor oqishId(Integer id){
        Optional<Xaridor> optionalXaridor = xaridorRepository.findById(id);
        return optionalXaridor.orElse(null);
//        if (optionalXaridor.isPresent()){
//            Xaridor xaridor = optionalXaridor.get();
//            return xaridor;
//        }
//        return null;
    }
    public String update2(Integer id,Xaridor xaridor){
        Optional<Xaridor> optionalXaridor = xaridorRepository.findById(id);
        if (optionalXaridor.isPresent()){
            Xaridor xaridor1 = optionalXaridor.get();
            xaridor1.setManzil(xaridor.getManzil());
            xaridor1.setIsmi(xaridor.getIsmi());
            xaridor1.setFamilyasi(xaridor.getFamilyasi());
            xaridor1.setTelNomer(xaridor.getTelNomer());
            xaridorRepository.save(xaridor1);
            return "Malumot Tahrirlandi";
        }
        return "Malumot topilmadi";
    }
    public String delete2(Integer id){
        Optional<Xaridor> optionalXaridor = xaridorRepository.findById(id);
        if (optionalXaridor.isPresent()){
            xaridorRepository.deleteById(id);
            return "Malumot o'chirildi";
        }
        return "Malumot topilmadi";
    }
}