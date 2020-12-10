package com.pixel.challenge.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pixel.challenge.healthcare.exception.ResourceNotFoundException;
import com.pixel.challenge.healthcare.model.Exam;
import com.pixel.challenge.healthcare.model.Healthcareinstitution;
import com.pixel.challenge.healthcare.repository.ExamRepository;
import com.pixel.challenge.healthcare.repository.HealthcareInstitutionRepository;

@Controller
public class ExamController {
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private HealthcareInstitutionRepository healthcareInstitutionRepository;

    @Value("${page.exam}")
    private String page;
    
    @Value("${page.examedit}")
    private String pageExamEdit;
    

    @GetMapping("examInitial")
    public String main(Model model) {
    	model.addAttribute("page", page);
		model.addAttribute("exam", new Exam());
		//Only for testes
		//model.addAttribute("listExam", this.getAllExams());
		
        return "exam";
    }
    
	@GetMapping("/exams")
	public List<Exam> getAllExams(){
		return examRepository.findAll();
	}		
    
	@GetMapping("/exam/{id}")
	public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
		Exam exam = examRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id :" + id));
		return ResponseEntity.ok(exam);
	}
	
	@RequestMapping("/examsFromHealthcare/exam.delete/{id}")
	public String deleteExam1(@PathVariable Long id){
		examRepository.deleteById( id );		
		
		//TODO: return "/exam";
		return "redirect:/healthcareInstitution";
	}	

	@RequestMapping("/exam.delete/{id}")
	public String deleteExam2(@PathVariable Long id){
		examRepository.deleteById( id );		
		
		//TODO: return "/exam";
		return "redirect:/healthcareInstitution";
	}	
	
	@RequestMapping("/examsFromHealthcare/{id}")
	public String getHealthcareinstitutionExams(Model model, @PathVariable Long id){
		Healthcareinstitution healthcareInstitution = healthcareInstitutionRepository.findById(id).orElseThrow();

    	model.addAttribute("page", page);
    	Exam exam= new Exam();
    	exam.setIdHealthcareInstitution(healthcareInstitution);
		model.addAttribute("exam", exam);
		model.addAttribute("idHealthcareInstitution", healthcareInstitution.getIdHealthcareInstitution());
		model.addAttribute("listExam", healthcareInstitution.getExamCollection());
		
		return "/exam";
    }

	@RequestMapping("/examNewEdit/{id}")
	public String newEdit(Model model, @PathVariable Long id){
		
		Exam exam = examRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id :" + id));
		
		model.addAttribute(exam);
		model.addAttribute("page",pageExamEdit);
		
		return "/examEdit";
	}	
	
	
	@RequestMapping(value = "/examsFromHealthcare/examSave", method = RequestMethod.POST)
	public String saveExam(@ModelAttribute("exam") Exam obj) {
		examRepository.save(obj);
		
		//TODO: return "/exam";
		return "redirect:/healthcareInstitution";
	}	
	

//	//@PutMapping("/exam.saveedit/{id}")
//	//@PutMapping("/exam.saveedit")
//	@RequestMapping(value="/exam.saveedit",method = RequestMethod.POST) 
//	public String updateExam(@RequestBody Exam examDetails){
//		
//		Exam exam = examRepository.findById(examDetails.getIdExam()).get();
//
//		exam.setPatientAge(examDetails.getPatientAge());
//		exam.setPatientGender(examDetails.getPatientGender());
//		exam.setPatientName(examDetails.getPatientName());
//		exam.setPhysicianCRM(examDetails.getPhysicianCRM());
//		exam.setPhysicianName(examDetails.getPhysicianName());
//		exam.setProcedureName(examDetails.getProcedureName());
//		examRepository.save(exam);
//		
//		return "redirect:/healthcareInstitution";
//	}	
	
	@RequestMapping(value = "/examNewEdit/examSaveEdit", method = RequestMethod.POST)
	public String saveExamEdit1(@ModelAttribute("exam") Exam examDetails) {
		
		Exam exam = examRepository.findById(examDetails.getIdExam()).get();

		exam.setPatientAge(examDetails.getPatientAge());
		exam.setPatientGender(examDetails.getPatientGender());
		exam.setPatientName(examDetails.getPatientName());
		exam.setPhysicianCRM(examDetails.getPhysicianCRM());
		exam.setPhysicianName(examDetails.getPhysicianName());
		exam.setProcedureName(examDetails.getProcedureName());
		examRepository.save(exam);
		
		return "redirect:/healthcareInstitution";
	}

	@RequestMapping(value = "/examSaveEdit", method = RequestMethod.POST)
	public String saveExamEdit2(@ModelAttribute("exam") Exam examDetails) {
		
		Exam exam = examRepository.findById(examDetails.getIdExam()).get();

		exam.setPatientAge(examDetails.getPatientAge());
		exam.setPatientGender(examDetails.getPatientGender());
		exam.setPatientName(examDetails.getPatientName());
		exam.setPhysicianCRM(examDetails.getPhysicianCRM());
		exam.setPhysicianName(examDetails.getPhysicianName());
		exam.setProcedureName(examDetails.getProcedureName());
		examRepository.save(exam);
		
		return "redirect:/healthcareInstitution";
	}
	
//	@RequestMapping(value = "exam.saveedit", method = RequestMethod.POST)
//	public String saveExamEdit3(@ModelAttribute("exam") Exam examDetails) {
//		Exam exam = examRepository.findById(examDetails.getIdExam()).get();
//
//		exam.setPatientAge(examDetails.getPatientAge());
//		exam.setPatientGender(examDetails.getPatientGender());
//		exam.setPatientName(examDetails.getPatientName());
//		exam.setPhysicianCRM(examDetails.getPhysicianCRM());
//		exam.setPhysicianName(examDetails.getPhysicianName());
//		exam.setProcedureName(examDetails.getProcedureName());
//		examRepository.save(exam);
//		
//		return "redirect:/healthcareInstitution";
//	}
	
	
}