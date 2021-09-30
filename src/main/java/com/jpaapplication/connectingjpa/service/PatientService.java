package com.jpaapplication.connectingjpa.service;

import com.jpaapplication.connectingjpa.dao.PatientRepository;
import com.jpaapplication.connectingjpa.entities.Patient;
import com.jpaapplication.connectingjpa.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public Patient UpdatePatient( Patient patientDetails,Integer patientId){
        Patient patient = patientRepository.findById(patientId).get();

        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setAddress(patientDetails.getAddress());
        patient.setCity(patientDetails.getCity());
        patient.setState(patientDetails.getState());
        patient.setZipcode(patientDetails.getZipcode());
        patient.setNumber(patientDetails.getNumber());
        patient.setEmail(patientDetails.getEmail());
        return patientRepository.save(patient);
    }
public Map<String, Boolean> DeletePatient ( Integer patientId){

    Patient patient = patientRepository.findById(patientId).get();

    patientRepository.delete(patient);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}
public Patient createPatient(Patient patient){
        Patient createdPatient=patientRepository.save(patient);
        return createdPatient;
}
public Patient getPatient(Integer patientId) throws CustomException {

    Patient patient = patientRepository.findById(patientId).get();
    return patient;
}
public List<Patient> getAllPatient(){
    return (List<Patient>) patientRepository.findAll();

}

}
