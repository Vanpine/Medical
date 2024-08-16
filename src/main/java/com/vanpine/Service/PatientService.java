package com.vanpine.Service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vanpine.Entity.DTO.PatientDTO;
import com.vanpine.Entity.PO.Patient;

public interface PatientService extends IService<Patient> {


    Boolean updatePatientInfo(LambdaUpdateWrapper<Patient> patientLambdaUpdateWrapper, PatientDTO patientDTO, Integer id);
}
