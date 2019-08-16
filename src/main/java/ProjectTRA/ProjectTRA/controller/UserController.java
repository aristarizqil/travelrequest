/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.controller;

import ProjectTRA.ProjectTRA.interfaceserviceimplement.EmployeeServiceImplement;
import ProjectTRA.ProjectTRA.interfaceserviceimplement.TraServiceImplement;
import ProjectTRA.ProjectTRA.model.Employee;
import ProjectTRA.ProjectTRA.model.Tra;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
public class UserController {
    
    @Autowired
    public TraServiceImplement trasi;
    
    @Autowired
    public EmployeeServiceImplement esi;
    
    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        return "user";
    }
    
    @GetMapping("/usersurat")
    public String usersurat(Model model){
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        return "userSurat";
    }
    
    @GetMapping("/userrequest")
    public String userrequest(Model model) {
        model.addAttribute("tra", trasi.findAll());
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        int id = esi.findByEmail(currentUserName()).getId();
        model.addAttribute("req", trasi.findByEmployee(id));
//        model.addAttribute("req", esi.findById(esi.findByEmail(currentUserName()).getId()));
//        System.out.println(esi.findById(esi.findByEmail(currentUserName()).ge));
        
        return "userRequest";
    }
    
    public String currentUserName() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String nama = auth.getName();
        System.out.println(nama);
        return nama;
    }
    
    @GetMapping("/userlaporan")
    public String userlaporan(Model model) {
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        int id = esi.findByEmail(currentUserName()).getId();
        model.addAttribute("req", trasi.findByEmployee(id));
        return "userLaporan";
    }
    
    @PostMapping("/savetra")
    public String saveTRA(@RequestParam(value = "address") String address,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "travelTime") String travelTime,
            @RequestParam(value = "deptDate") String deptDate,
            @RequestParam(value = "deptTime") String deptTime,
            @RequestParam(value = "deptTrans") String deptTrans,
            @RequestParam(value = "deptCost") String deptCost,
            @RequestParam(value = "living") String living,
            @RequestParam(value = "livingCost") String livingCost,
            @RequestParam(value = "retDate") String retDate,
            @RequestParam(value = "retTime") String retTime,
            @RequestParam(value = "retTrans") String retTrans,
            @RequestParam(value = "retCost") String retCost
            ){
        
        int id = esi.findByEmail(currentUserName()).getId();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        
        Date date1 = null;
        Date date2 = null;
//        Date time1 = null;
//        Date time2 = null;
        
        try {
            date1 = dateFormat.parse(deptDate);
            date2 = dateFormat.parse(retDate);
//            time1 = timeFormat.parse(deptTime);
//            time2 = timeFormat.parse(retTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String approvalManager = "pending";
        String approvalHR = "pending";
        String approvalFinance = "pending";
        
        Tra tra = new Tra(address, type, date1, deptTime, deptTrans, deptCost, date2, retTime, retTrans, retCost, travelTime, living, livingCost, approvalManager, approvalHR, approvalFinance, new Employee(id));
        
        trasi.save(tra);
        
        return "redirect:/userrequest";
    }
    
    @PostMapping("/updatetra")
    public String updateTRA(@RequestParam(value = "id") int id,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "travelTime") String travelTime,
            @RequestParam(value = "deptDate") String deptDate,
            @RequestParam(value = "deptTime") String deptTime,
            @RequestParam(value = "deptTrans") String deptTrans,
            @RequestParam(value = "deptCost") String deptCost,
            @RequestParam(value = "living") String living,
            @RequestParam(value = "livingCost") String livingCost,
            @RequestParam(value = "retDate") String retDate,
            @RequestParam(value = "retTime") String retTime,
            @RequestParam(value = "retTrans") String retTrans,
            @RequestParam(value = "retCost") String retCost
            ){
        
        int idEmployee = esi.findByEmail(currentUserName()).getId();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        
        Date date1 = null;
        Date date2 = null;
//        Date time1 = null;
//        Date time2 = null;
        
        try {
            date1 = dateFormat.parse(deptDate);
            date2 = dateFormat.parse(retDate);
//            time1 = timeFormat.parse(deptTime);
//            time2 = timeFormat.parse(retTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String approvalManager = "pending";
        String approvalHR = "pending";
        String approvalFinance = "pending";
        
        Tra tra = new Tra(id, address, type, date1, deptTime, deptTrans, deptCost, date2, retTime, retTrans, retCost, travelTime, living, livingCost, approvalManager, approvalHR, approvalFinance, new Employee(idEmployee));
        
        trasi.save(tra);
        
        return "redirect:/userrequest";
    }
}
