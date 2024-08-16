package com.vanpine.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vanpine.Entity.PO.Patient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
  
}
