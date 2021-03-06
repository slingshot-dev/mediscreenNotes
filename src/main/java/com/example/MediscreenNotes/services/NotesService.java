package com.example.MediscreenNotes.services;

import com.example.MediscreenNotes.Repositories.NotesRepository;
import com.example.MediscreenNotes.modeles.Notes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Couche service pour l'ensemble des actions CRUD pour le Modele Notes
 */

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }


    public List<Notes> findAll() {
        return notesRepository.findAll();
    }

    public Optional<Notes> findNoteById(String id) {
        return notesRepository.findById(id);
    }

    public List<Notes> findNotesByPatientId(String patientId) {
        return notesRepository.findByPatientId(patientId);
    }

    public Notes add(Notes notes) {
        return notesRepository.save(notes);
    }


    public Notes update(Notes notes) {
        return notesRepository.save(notes);
    }


    public void delete(Notes notes) {
        notesRepository.delete(notes);
    }

    public void deleteNoteById(String id) {
        notesRepository.deleteById(id);
    }


    public Integer findSymptom(String symptom, String patientId) {

        return notesRepository.findNotesByNoteContainsIgnoreCaseAndPatientId(symptom, patientId).size();

    }

}
