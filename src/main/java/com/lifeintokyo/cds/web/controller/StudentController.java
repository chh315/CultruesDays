package com.lifeintokyo.cds.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeintokyo.cds.domain.Student;
import com.lifeintokyo.cds.service.StudentService;
import com.lifeintokyo.cds.utils.DateFormatter;

@Controller
public class StudentController {

	@Autowired
	private SettingsForm settingsForm;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/students")
	public String list(Model model, Pageable pageable) {
		Page<Student> page = studentService.listStudents(pageable, null);
        model.addAttribute("page", page);
        model.addAttribute("students", page.getContent());
        model.addAttribute("url", "students/list");
        
		return "students/list";
	}

	@GetMapping(value = "/json/students")
	public @ResponseBody List<Student> getStudentJSON() {
		return studentService.listStudents();
	}
	
	@GetMapping(value = "/students/search")
	public String search(Model model, Pageable pageable, @RequestParam("kana") String kana) {
		Page<Student> page = studentService.listStudents(pageable, kana);
        model.addAttribute("page", page);
        model.addAttribute("students", page.getContent());
        model.addAttribute("url", "/students/search?" + kana);
        
		return "students/list";
	}
	
	@GetMapping(value = "/students/new")
	public String initCreationForm(Model model, HttpSession session) {
		settingsForm.setBuzdateSeldates(DateFormatter.populateBuzdateseldates(settingsForm.getBuzDate()));
		session.setAttribute("settingsForm", settingsForm);
		StudentForm student = new StudentForm();
		model.addAttribute(student);
		return "students/createOrUpdateForm";
	}
	
	@PostMapping(value = "/students/new")
    public String processCreationForm(@Valid StudentForm studentform,
    		BindingResult result) {
        if (result.hasErrors()) {
            return "students/createOrUpdateForm";
        } else {
        	Student studentDto = new Student();
        	BeanUtils.copyProperties(studentform, studentDto);
        	Long id = studentService.saveStudent(studentDto, settingsForm.getSchoolid(), settingsForm.getBuzDate());
            return "redirect:/students/" + id + "/show";
        }
    }

	@GetMapping(value = "/students/{studentid}/show")
    public String show(@PathVariable("studentid") Long studentid, Model model) {
		StudentForm student = new StudentForm();
		model.addAttribute(student);
        return "students/view";
    }

	@GetMapping(value = "/students/{studentid}/edit")
    public String initUpdateForm(@PathVariable("studentid") Long studentid, Model model) {
//		Student pet = this.clinicService.findById(studentid);
//        model.addAttribute("pet", pet);
        return "students/createOrUpdateForm";
    }

    @RequestMapping(value = "/students/{studentid}/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public String processUpdateForm(@Valid StudentForm student,
    		BindingResult result) {
        if (result.hasErrors()) {
            return "students/createOrUpdateForm";
        } else {
//            this.clinicService.savePet(pet);
//            status.setComplete();
            return "redirect:/owners/{ownerId}";
        }
    }
}
