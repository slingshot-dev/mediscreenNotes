package com.example.MediscreenNotes.controllers;

import com.example.MediscreenNotes.modeles.Notes;
import com.example.MediscreenNotes.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/notes")
@CrossOrigin
public class Notescontroller  {



    @Autowired
    NotesService notesService;

    /**
     * Methode pour recuperer toutes les notes.
     * @return : Retourne une liste de toutes les notes de tous les patients
     */
    @GetMapping
    public Collection<Notes> getAll() {
        System.out.println("-------> : getAllNotes");
//        logger.debug("Getting all notes.");
        return notesService.findAll();
    }


    /**
     * Methode pour recuperer une note en fonction de son id
     * @param id : id de la note
     * @return : Retourne la note liée a cet id
     */
    @GetMapping("/list")
    public Optional<Notes> getById(@RequestParam String id) {
//        logger.debug("Getting users with user-id= {}.", id);
        return notesService.findNoteById(id);
    }

    /**
     * Methode pour recuperer une note en fonction du parentId
     * @param patientId : id de la note
     * @return : Retourne la note liée a cet id
     */
    @GetMapping("/listpatient")
    public List<Notes> getByParentId(@RequestParam String patientId) {
//        logger.debug("Getting users with user-id= {}.", id);
        return notesService.findNotesByPatientId(patientId);
    }



    /**
     * Methode pour ajouter une note
     * @param note : note
     * @return : Retourne l'objet complet 'note'
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String add(@RequestBody Notes note) {
//        logger.debug("Updating user with user-id= {}.", id);
        notesService.add(note);
        return "note recorded for patient: ";
    }



    /**
     * Methode pour mettre a jour une note.
     * @param note : note
     * @return : retourn l'objet note updaté
     */
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody Notes note) {
//        logger.debug("Updating user with user-id= {}.", id);
        notesService.update(note);
        return "note record for patient updated.";
    }


    /**
     * Methode pour supprimer une note.
     * @param id : id de la note
     * @return : Retour l'info de la note supprimée
     */
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestParam String id) {
//        logger.debug("Deleting user with user-id= {}.", id);
        notesService.deleteNoteById(id);
        return "note record for PatientId= " + id + " deleted.";
    }


    /**
     * Methode pour recuperer des notes en fonction d'un symptome
     * @param symptom : symptom recherché dans lma note
     * @return : Retourne la note liée a cet id
     */
    @GetMapping("/symptom")
    public Integer getBySymptom(@RequestParam String symptom, @RequestParam String patientId) {
//        logger.debug("Getting users with user-id= {}.", id);
        return notesService.findSymptom(symptom, patientId);
    }


}
