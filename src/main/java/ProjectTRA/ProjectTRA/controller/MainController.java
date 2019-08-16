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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author USER
 */
@Controller
public class MainController {
    
    @Autowired
    public EmployeeServiceImplement esi;
    
    @Autowired
    public RoleServiceImplement rsi;
    
    @Autowired
    public JavaMailSender javaMailSender;
    
    
    @RequestMapping(value = {"/", "", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
//    @GetMapping("/")
//    public String index(Model model){
//        model.addAttribute("employee", esi.findAll());
//        return "index";
//    }
//    
//     @GetMapping("/user1")
//    public String user1(){
//        return "user_1";
//    }
    
//    @GetMapping("/role")
//    public String role(Model model){
//        model.addAttribute("role", rsi.findall());
//        return "role";
//    }
    
//    @GetMapping("/datasiswa")
//    public String data(Model model){
//        model.addAttribute("employee", esi.findAll());
//        model.addAttribute("role", rsi.findall());
//        return "data";
//    }
//    
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable(value = "id") int id){
//        esi.delete(id);
//        return "redirect:/data";
//    }
//    
//    @PostMapping("/save")
//    public String save(@RequestParam(value = "id") int id,
//            @RequestParam(value = "name") String name,
//            @RequestParam(value = "email") String email,
//            @RequestParam(value = "password") String password,
//            @RequestParam(value = "gender") String gender,
//            @RequestParam(value = "status") String status,
//            @RequestParam(value = "role") int role
//            ){
//        Employee employee = new Employee(id, name, email, password, gender, status, new Role(role));
//        esi.save(employee);
//        return "redirect:/data";
//    }
//    
//    @PostMapping("/update")
//    public String saveData(@RequestParam(value = "id") int id,
//            @RequestParam(value = "name") String name,
//            @RequestParam(value = "email") String email,
//            @RequestParam(value = "password") String password,
//            @RequestParam(value = "gender") String gender,
//            @RequestParam(value = "status") String status,
//            @RequestParam(value = "role") int role
//            ){
//        Employee employee = new Employee(id, name, email, password, gender, status, new Role(role));
//        esi.save(employee);
//        return "redirect:/data";
//    }
    
//    @GetMapping("/findById/{id}")
//    public String updateData(@RequestParam(value = "id") int id, Model model){
//        model.addAttribute("employee", esi.findById(id));
//        return "edit";
//    }
    
}
