package com.vanpine.Mapper;

import com.vanpine.Entity.VO.PatientAndDoctorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientAndDoctorMapper {

    List<PatientAndDoctorVO> multipleQuery(Integer patientConnectionId);

}
