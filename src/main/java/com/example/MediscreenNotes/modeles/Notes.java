package com.example.MediscreenNotes.modeles;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "notes")
public class Notes {

    @Id
    private String regId;

    private String patientId;

    private String note;


    public Notes(String regId, String patientId, String note) {
        this.regId = regId;
        this.patientId = patientId;
        this.note = note;
    }

    public Notes() {
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Notes (id=" + regId + ", patient=" + patientId + "note=" + note + ")";
    }

}
