package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Journal;
import com.example.demo.service.JournalService;

@Controller
public class JournalController {

	@Autowired
	private JournalService journalService;
	
	/*
	 * Display the list of journals
	 */
	@GetMapping("/journal/index")
    public String getAllJournals(Model model) {
        model.addAttribute("journals", journalService.getAllJournals());
        return "journal/index";
    }
	
	/*
	 * Display the journal registration form
	 */
    @GetMapping("/journal/new")
    public String showRegistrationForm(Model model) {
        model.addAttribute("journal", new Journal());
        return "journal/new";
    }

    /*
     * Register a new journal
     */
    @PostMapping("/journal/new")
    public String registerJournal(@ModelAttribute Journal journal) {
        journalService.createJournal(journal);
        return "redirect:/journal/index";
    }
    
    /*
     * Display the details of a specific journal
     */
    @GetMapping("/journal/show/{id}")
    public String showJournal(@PathVariable Integer id, Model model) {
    	Optional<Journal> journal = journalService.getJournalById(id);
        if (journal.isPresent()) {
            model.addAttribute("journal", journal.get());
            return "journal/show";
        } else {
            return "redirect:/journal/index";
        }
    }
    
    /*
     * Display the journal edit form
     */
    @GetMapping("/journal/edit/{id}")
    public String editJournal(@PathVariable Integer id, Model model) {
        Optional<Journal> journal = journalService.getJournalById(id);
        if (journal.isPresent()) {
            model.addAttribute("journal", journal.get());
            return "journal/edit";
        } else {
            return "redirect:/journal/index";
        }
    }
    
    /*
     * Update the journal
     */
    @PostMapping("/journal/update/{id}")
    public String updateJournal(@PathVariable Integer id, @ModelAttribute("jornal") Journal updatedJournal) {
        journalService.updateJournal(id, updatedJournal);
        return "redirect:/journal/index";
    }
    
    /*
     * Delete a journal
     */
    @PostMapping("/journal/delete/{id}")
    public String deleteJournal(@PathVariable Integer id) {
        journalService.deleteJournal(id);
        return "redirect:/journal/index";
    }
}
