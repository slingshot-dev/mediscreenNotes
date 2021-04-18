package com.example.MediscreenNotes.Repositories;

import com.example.MediscreenNotes.modeles.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface NotesRepository extends MongoRepository<Notes, String> {

    List<Notes> findByPatientId(String patienId);


}