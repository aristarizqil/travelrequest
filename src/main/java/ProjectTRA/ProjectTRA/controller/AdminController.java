/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.controller;

import ProjectTRA.ProjectTRA.interfaceserviceimplement.EmployeeServiceImplement;
import ProjectTRA.ProjectTRA.interfaceserviceimplement.RoleServiceImplement;
import ProjectTRA.ProjectTRA.model.Employee;
import ProjectTRA.ProjectTRA.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author USER
 */
@Controller
public class AdminController {
    
    @Autowired
    public EmployeeServiceImplement esi;
    
    @Autowired
    public RoleServiceImplement rsi;
    
    @GetMapping("/admin")
    public String index(Model model){
        model.addAttribute("employee", esi.findAll());
        model.addAttribute("email", esi.findByEmail(currentUserName()).getName());
        
//        Employee e = esi.findByEmail(currentUserName());
//        System.out.println(e.getId());
//        System.out.println(e.getName());
        return "admin";
    }
    
    public String currentUserName() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String nama = auth.getName();
        System.out.println(nama);
        return nama;
    }
    
    @GetMapping("/role")
    public String role(Model model){
        model.addAttribute("role", rsi.findall());
        return "role";
    }
    
    @GetMapping("/admindata")
    public String data(Model model){
        model.addAttribute("email", esi.findByEmail(currentUserName()).getName());
        model.addAttribute("employee", esi.findAll());
        model.addAttribute("role", rsi.findall());
        return "adminData";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        esi.delete(id);
        return "redirect:/admindata";
    }
    
    @PostMapping("/save")
    public String save(@RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "status") String status,
            @RequestParam(value = "role") int role
            ){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String chip = passwordEncoder.encode(password);
        
        boolean isactive = true;
        Employee employee = new Employee(id, name, email, password, gender, status, isactive, new Role(role));
        esi.save(employee);
        return "redirect:/admindata";
    }
    
    @PostMapping("/update")
    public String saveData(@RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "status") String status,
            @RequestParam(value = "role") int role
            ){
        
        
        boolean isactive = true;
        Employee employee = new Employee(id, name, email, password, gender, status, isactive, new Role(role));
        esi.save(employee);
        return "redirect:/admindata";
    }
//    
//    @GetMapping("/findById/{id}")
//    public String updateData(@RequestParam(value = "id") int id, Model model) {
//        model.addAttribute("employee", esi.findById(id));
//        return "redirect:/data";
//    }
}
