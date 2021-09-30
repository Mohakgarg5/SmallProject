package com.jpaapplication.connectingjpa.mapper;

import com.jpaapplication.connectingjpa.dto.PatientDto;
import com.jpaapplication.connectingjpa.entities.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    public PatientDto entityToDto(Patient patient){
        PatientDto dto = new PatientDto();
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setAddress(patient.getAddress());
        dto.setCity(patient.getCity());

        return dto;
    }

    public List<PatientDto> entityToDto(List<Patient> patient){
       return patient.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Patient dtoToEntity(PatientDto dto)
    {
        Patient pt=new Patient();
        pt.setFirstName(dto.getFirstName());
        pt.setLastName(dto.getLastName());
        pt.setAddress(dto.getAddress());
        pt.setCity(dto.getCity());
        return pt;
    }
    public List<Patient> dtoToEntity(List<PatientDto> dto)
    {
      return  dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }


}

/**
 * Service Layer Implemented
 * Lambda In Java ( Functional Interfaces)
 * Validations Completed
 * Custom Exceptions
 * Threads In Java
 * Observer Patter with Observable
 * 25/26 10:00 AM
 */
