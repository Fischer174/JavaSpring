package java.controller;

import java.entity.Employee;
import java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService service;

    @RequestMapping("/")
    public String showAllEmployees(Model model){
        List<Employee> allEmployees = service.getAll();
        model.addAttribute("all", allEmployees);
        return "all_employees";
    }

    @RequestMapping("/add")
    public String addNewEmployee(Model model) {
        Employee newEmployee = new Employee();
        model.addAttribute("employee", newEmployee);
        return "add_info";
    }

    @RequestMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_info";
        }
        service.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = service.getEmployee(id);
        model.addAttribute("employee", employee);
        return "add_info";
    }

    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("empId") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
