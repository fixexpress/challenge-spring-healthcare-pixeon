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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pixel.challenge.healthcare.exception.ResourceNotFoundException;
import com.pixel.challenge.healthcare.model.Healthcareinstitution;
import com.pixel.challenge.healthcare.repository.HealthcareInstitutionRepository;

@Controller
public class HealthcareInstituitionController {
	
	@Autowired
	private HealthcareInstitutionRepository healthcareInstitutionRepository;

    @Value("${page.healthcareInstitution}")
    private String page;

    @GetMapping("healthcareInstitution")
    public String main(Model model) {
    	
    	model.addAttribute("page", page);
    	
		Healthcareinstitution healthcareInstitution = new Healthcareinstitution();
		model.addAttribute("healthcareInstitution", healthcareInstitution);
		
		List<Healthcareinstitution> listHhealthcareInstitution = healthcareInstitutionRepository.findAll();
		model.addAttribute("listHhealthcareInstitution", listHhealthcareInstitution);
		
        return "healthcareInstitution";
    }
    
	@GetMapping("/healthcareInstitutions")
	public List<Healthcareinstitution> getAllHealthcareinstitutions(){
		return healthcareInstitutionRepository.findAll();
	}		
    
	@GetMapping("/healthcareInstitution/{id}")
	public ResponseEntity<Healthcareinstitution> getHealthcareinstitutionById(@PathVariable Long id) {
		Healthcareinstitution healthcareInstitution = healthcareInstitutionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Healthcareinstitution not exist with id :" + id));
		return ResponseEntity.ok(healthcareInstitution);
	}
	
	
	@RequestMapping("/healthcareInstitution.delete/{id}")
	public String deleteHealthcareinstitution(@PathVariable Long id){
		healthcareInstitutionRepository.deleteById( id );
		return "redirect:/healthcareInstitution";
	}
	
	@RequestMapping(value = "/healthcareInstitution.save", method = RequestMethod.POST)
	public String saveHealthcare(@ModelAttribute("healthcareInstitution") Healthcareinstitution obj) {
		healthcareInstitutionRepository.save(obj);
		
		return "redirect:/healthcareInstitution";
	}

}