package com.jpaapplication.connectingjpa.controller;

import com.jpaapplication.connectingjpa.dto.PatientDto;
import com.jpaapplication.connectingjpa.entities.Patient;
import com.jpaapplication.connectingjpa.exception.CustomException;
import com.jpaapplication.connectingjpa.exception.GlobalExceptionHandler;
import com.jpaapplication.connectingjpa.service.PatientService;
import com.jpaapplication.connectingjpa.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    PatientMapper converter;

//    @GetMapping("/get-all-patients")
//    public List<PatientDto> getAllPatient(){
//        List<Patient>getAllPatient=patientRepository.findAll();
//        return converter.entityToDto(getAllPatient);
//    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatient(){
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientbyId(@PathVariable(value = "id") Integer PatientId) throws CustomException

    {
       return ResponseEntity.ok(patientService.getPatient(PatientId));
    }

    @PostMapping("/create-patient")
    public ResponseEntity<PatientDto> createPatient(@RequestBody @Valid PatientDto patientDto) throws CustomException{

        return ResponseEntity.ok(converter.entityToDto(patientService.createPatient(converter.dtoToEntity(patientDto))));
    }

    @PostMapping("/create-patients")
    public ResponseEntity<Patient> createPatient(@RequestBody @Valid Patient patient) throws Exception {

       return ResponseEntity.ok(patientService.createPatient(patient));
    }
    //dto

    @PutMapping("/update-patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Integer patientId,
                                                 @RequestBody @Valid Patient patientDetails) {

        return ResponseEntity.ok(patientService.UpdatePatient(patientDetails,patientId));
    }
    @DeleteMapping("/delete-patients/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable(value = "id") Integer patientId)
    {
        return ResponseEntity.ok(patientService.DeletePatient(patientId));
    }
}

