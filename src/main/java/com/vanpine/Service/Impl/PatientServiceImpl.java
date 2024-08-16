package com.vanpine.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vanpine.Entity.DTO.PatientDTO;
import com.vanpine.Entity.PO.Patient;
import com.vanpine.Mapper.PatientMapper;
import com.vanpine.Service.PatientService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {


    @Override
    public Boolean updatePatientInfo(LambdaUpdateWrapper<Patient> patientLambdaUpdateWrapper, PatientDTO patientDTO, Integer id) {

        if (!(Objects.equals(patientDTO.getPatientName(), null) || Objects.equals(patientDTO.getPatientName(), ""))) {
            patientLambdaUpdateWrapper.set(Patient::getPatientName, patientDTO.getPatientName());
        }
        if (!(Objects.equals(patientDTO.getPatientAge(), null) || Objects.equals(patientDTO.getPatientAge(), ""))) {
            patientLambdaUpdateWrapper.set(Patient::getPatientAge, patientDTO.getPatientAge());
        }
        if (!(Objects.equals(patientDTO.getPatientGender(), null) || Objects.equals(patientDTO.getPatientGender(), ""))) {
            patientLambdaUpdateWrapper.set(Patient::getPatientGender, patientDTO.getPatientGender());
        }
        patientLambdaUpdateWrapper.eq(Patient::getId, id);
        boolean temp;
        if (baseMapper.update(patientLambdaUpdateWrapper) != 0) {
            temp = true;
        } else {
            temp = false;
        }
        return temp;
    }
}
