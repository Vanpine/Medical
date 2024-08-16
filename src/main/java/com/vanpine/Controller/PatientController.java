package com.vanpine.Controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.vanpine.Entity.DTO.PatientDTO;
import com.vanpine.Entity.PO.Patient;
import com.vanpine.Entity.Result;
import com.vanpine.Service.PatientService;
import com.vanpine.Util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@Api(tags = "病人表现层")
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/queryPatientInfo")
    @ApiOperation("查询病人")
    public Result<List<Patient>> queryPatientInfo() {
        return Result.success(patientService.list());
    }

    @ApiOperation("添加病人")
    @PostMapping("/addPatientInfo")
    public Result<Boolean> addPatientInfo(@RequestBody PatientDTO patientDTO) {
        // 从线程集合中获取id
        Map<String, Object> stringObjectMap = ThreadLocalUtil.get();
        Integer userId = (Integer) stringObjectMap.get("userId");
        System.out.println(userId);
        patientDTO.setPatientConnectionId(userId);
        Patient patient = BeanUtil.copyProperties(patientDTO, Patient.class);
        return Result.success(patientService.save(patient));
    }

    @GetMapping("/queryById")
    @ApiOperation("根据id查询病人信息")
    public Boolean queryById(@RequestParam Integer id) {
        return patientService.getById(id).equals("");
    }

    @ApiOperation("修改病人信息")
    @PutMapping("/updatePatientInfo")
    public Result<Boolean> updatePatientInfo(@RequestBody PatientDTO patientDTO, @RequestParam Integer id) {
        if (queryById(id)) {
            return Result.error("用户不存在");
        } else {
            return Result.success(patientService.updatePatientInfo(new LambdaUpdateWrapper<Patient>(), patientDTO, id));
        }
    }
}
//update(new LambdaUpdateWrapper<Patient>()
//                    .set(Patient::getPatientName, patientDTO.getPatientName())
//        .set(Patient::getPatientAge, patientDTO.getPatientAge())
//        .set(Patient::getPatientGender, patientDTO.getPatientGender())
//        .eq(Patient::getId, id)
