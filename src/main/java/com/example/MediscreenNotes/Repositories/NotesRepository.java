package com.example.MediscreenNotes.Repositories;

import com.example.MediscreenNotes.modeles.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Couche Repository pour le Modele Note
 */

public interface NotesRepository extends MongoRepository<Notes, String> {

    List<Notes> findByPatientId(String patienId);

    List<Notes> findNotesByNoteContainsIgnoreCaseAndPatientId(String trigger, String patientId);

    List<Notes> findNotesByNoteContainingIgnoreCaseAndPatientId(String trigger, String patientId);


}
