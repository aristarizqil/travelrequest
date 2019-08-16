/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.controller;

import ProjectTRA.ProjectTRA.interfaceserviceimplement.EmployeeServiceImplement;
import ProjectTRA.ProjectTRA.interfaceserviceimplement.LetterServiceImplement;
import ProjectTRA.ProjectTRA.interfaceserviceimplement.TraServiceImplement;
import ProjectTRA.ProjectTRA.model.Employee;
import ProjectTRA.ProjectTRA.model.Tra;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class ManagerController {
    
    @Autowired
    public TraServiceImplement tsi;

    @Autowired
    public EmployeeServiceImplement esi;

    @Autowired
    public LetterServiceImplement lsi;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    public String currentUserName() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String nama = auth.getName();
        System.out.println(nama);
        return nama;
    }
    
    @GetMapping("/manager")
    public String manager(Model model) {
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        return "manager";
    }

    @GetMapping("/managersurat")
    public String managersurat(Model model) {
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        model.addAttribute("letterAll", lsi.findAllLetter());
        return "managerSurat";
    }

    @PostMapping("/sendmanagersurat")
    public String sendemail(@RequestParam(value = "email") String to,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "files") MultipartFile file) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(to);

        helper.setSubject("Surat penugasan untuk "+name);

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("Hai "+ name + " anda mendapatkan surat penugasan baru !");

        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        //Resource resource = new ClassPathResource("android.png");
        //InputStream input = resource.getInputStream();

        //ResourceUtils.getFile("classpath:android.png");

        helper.addAttachment("file.pdf", file);

        javaMailSender.send(msg);
        return "redirect:/manageremployee";
    }

    @GetMapping("/managerrequest")
    public String managerrequest(Model model) {
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        model.addAttribute("tra", tsi.findAll());
        return "managerRequest";
    }

    @GetMapping("/manageremployee")
    public String manageremployee(Model model) {
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        model.addAttribute("empAll", esi.findAll());
        return "managerEmployee";
    }
    
    @GetMapping("/findByIdEmp/{empId}")
    public String empById(@PathVariable(value="empId", required = false)Integer id, Model model){
        model.addAttribute("empById", esi.findById(id).get());
        return"managerSurat";
    }
    
    @GetMapping("/managerlaporan")
    public String managerlaporan(Model model) {
        model.addAttribute("name", esi.findByEmail(currentUserName()).getName());
        return "managerLaporan";
    }
    
    @PostMapping("/detailrequest")
    public String saveData(@RequestParam(value = "address") String address,
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
            @RequestParam(value = "retCost") String retCost,
            @RequestParam(value = "idEmployee") Employee idEmployee,
            @RequestParam(value = "traId") Integer id,
            @RequestParam(value = "status") String status
            ){
        
        String approvalManager = "pending";
        String approvalHR = "pending";
        String approvalFinance = "pending";
        if("Diterima".equals(status)){
            approvalManager = "Diterima " + esi.findByEmail(currentUserName()).getName();
        } else {
            approvalManager = "Ditolak " + esi.findByEmail(currentUserName()).getName();
        }
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
        
        Tra tra = new Tra(id, address, type, date1, deptTime, deptTrans, deptCost, date2, retTime, retTrans, retCost, travelTime, living, livingCost, approvalManager, approvalHR, approvalFinance, idEmployee);
        
        tsi.save(tra);
        return "redirect:/managerrequest";
    }
    
    
}
