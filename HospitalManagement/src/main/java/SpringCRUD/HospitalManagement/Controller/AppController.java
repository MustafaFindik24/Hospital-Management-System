package SpringCRUD.HospitalManagement.Controller;

import SpringCRUD.HospitalManagement.Model.Appointment;
import SpringCRUD.HospitalManagement.Model.Doctor;
import SpringCRUD.HospitalManagement.Model.User;
import SpringCRUD.HospitalManagement.Services.AppointmentServices;
import SpringCRUD.HospitalManagement.Services.DoctorServices;
import SpringCRUD.HospitalManagement.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping
public class AppController {

    @Autowired
    private UserServices userService;

    @Autowired
    private DoctorServices doctorService;

    @Autowired
    private AppointmentServices appointmentService;


    @RequestMapping("/")
    public String viewHomePage1(Model model, HttpServletRequest request, HttpServletResponse response) {
        // create some cookies
        Cookie cookie1 = new Cookie("YoneticiCookie", "Mustafa");
        Cookie cookie2 = new Cookie("HospitalCookie", "HospitalManagement");

        cookie1.setMaxAge(10);
        // optional properties
        cookie1.setSecure(true);
        cookie1.setHttpOnly(true);
        cookie1.setPath("/");

        cookie2.setMaxAge(10);
        // optional properties
        cookie2.setSecure(true);
        cookie2.setHttpOnly(true);
        cookie2.setPath("/");

        // add cookie to response
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        return "homepage";
    }

    @RequestMapping("/about")
    public String viewAboutPage() {
        return "about";
    }


    @RequestMapping("/contact")
    public String viewContactPage() {
        return "contact";
    }


    @RequestMapping("/list_user")
    public String viewListUserPage(Model model, User user) {
        List <User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);
        return "index";
    }

    @RequestMapping("/list_doctor")
    public String viewListDoctorPage(Model model, Doctor doctor) {
        List <Doctor> listDoctor = doctorService.listAll();
        model.addAttribute("listDoctor", listDoctor);
        return "doctor_list";
    }

    @RequestMapping("/new")
    public String newUserPage(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "new_user";
    }

    @RequestMapping("/newDoc")
    public String newDoctorPage(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute(doctor);
        return "new_doctor";
    }

    @RequestMapping("/newAppointment")
    public String newRoomPage(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute(appointment);
        return "new_appointment";
    }

    @RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.save(appointment);
        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        return "redirect:/list_user";
    }

    @RequestMapping(value = "/saveDoc", method = RequestMethod.POST)
    public String listUser(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/list_doctor";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/list_user";
    }
    @RequestMapping(value = "/updateDoc", method = RequestMethod.POST)
    public String updateDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/list_doctor";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.get(id);
        mav.addObject("user", user);
        return mav;
    }
    @RequestMapping("/editDoc/{id}")
    public ModelAndView showEditDoctorPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_doctor");
        Doctor doctor = doctorService.get(id);
        mav.addObject("doctor", doctor);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUserPage(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return "redirect:/list_user";
    }
    @RequestMapping("/deleteDoc/{id}")
    public String deleteDocPage(@PathVariable(name = "id") Long id) {
        doctorService.delete(id);
        return "redirect:/list_doctor";
    }


    @RequestMapping("/appointments_list")
    public String viewListReservePage(Model model, Appointment appointment) {
        List<Appointment> listAllAppointment = appointmentService.listAll();
        model.addAttribute("listAllAppointment", listAllAppointment);
        return "appointment_list";
    }

    @RequestMapping("/deleteAppointment/{id}")
    public String deleteRoomPage(@PathVariable(name = "id") Long id) {
        appointmentService.delete(id);
        return "redirect:/appointments_list";
    }



}
