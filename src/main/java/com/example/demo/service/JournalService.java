package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Journal;
import com.example.demo.repository.JournalRepository;

@Service
public class JournalService {

	@Autowired
	private JournalRepository journalRepository;
	
	/*
	 * Get all journals
	 */
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    /*
     * Get a journal by its ID
     */
    public Optional<Journal> getJournalById(Integer id) {
        return journalRepository.findById(id);
    }

    /*
     * Create a new journal
     */
    public Journal createJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    /*
     * Update a journal by its ID
     */
    public Optional<Journal> updateJournal(Integer id, Journal updatedJournal) {
        return journalRepository.findById(id).map(journal -> {
            journal.setDate(updatedJournal.getDate());
            journal.setTitle(updatedJournal.getTitle());
            journal.setContent(updatedJournal.getContent());
            return journalRepository.save(journal);
        });
    }

    /*
     * Delete a journal by its ID
     */
    public void deleteJournal(Integer id) {
        journalRepository.deleteById(id);
    }
}
