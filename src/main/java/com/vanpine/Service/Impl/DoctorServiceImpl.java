package com.vanpine.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vanpine.Entity.PO.Doctor;
import com.vanpine.Mapper.DoctorMapper;
import com.vanpine.Service.DoctorService;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
}
