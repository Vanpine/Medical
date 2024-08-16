package com.vanpine.Controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.vanpine.Entity.DTO.DoctorDTO;
import com.vanpine.Entity.PO.Doctor;
import com.vanpine.Entity.Result;
import com.vanpine.Entity.VO.DoctorVO;
import com.vanpine.Service.DoctorService;
import com.vanpine.Util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
@Api(tags = "医生列表")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/getList")
    @ApiOperation("获取医生信息")
    public Result<List<DoctorVO>> getDoctorInfoList() {
        List<Doctor> doctorList = doctorService.getBaseMapper().selectList(new LambdaQueryWrapper<Doctor>().eq(Doctor::getConnectionId, ThreadLocalUtil.get().get("userId")));
        // 将User转化为VO
        List<DoctorVO> doctorVOList = BeanUtil.copyToList(doctorList, DoctorVO.class);
        return Result.success(doctorVOList);
    }

    @PostMapping("/addDoctorInfo")
    @ApiOperation("新增医生信息")
    public Result<Boolean> addDoctorInfo(@RequestBody DoctorDTO doctorDTO) {
        int userId = (Integer) ThreadLocalUtil.get().get("userId");
        // 将DTO转换成PO
        Doctor doctor = BeanUtil.copyProperties(doctorDTO, Doctor.class);
        doctor.setConnectionId(userId);
        return Result.success(doctorService.save(doctor));
    }

    @GetMapping("/isEmptyDoctorInfoById")
    @ApiOperation("通过Id查询对应的医生是否存在")
    public Boolean isEmptyDoctorInfoById(@RequestParam("id") Integer id) {
        return doctorService.getById(id).equals("");
    }

    @PutMapping("/updateDoctorInfo")
    @ApiOperation("修改医生信息")
    public Result<Boolean> updateDoctorInfo(@RequestBody DoctorDTO doctorDTO) {
        Map<String, Object> stringObjectMap = ThreadLocalUtil.get();
        Doctor doctor = BeanUtil.copyProperties(doctorDTO, Doctor.class);
        doctor.setConnectionId((Integer) stringObjectMap.get("userId"));
        if (!isEmptyDoctorInfoById(doctor.getId())) {
            return Result.error("对应的医生不存在");
        } else {
            doctorService.update(new LambdaUpdateWrapper<Doctor>()
                    .set(Doctor::getDoctorName, doctor.getDoctorName())
                    .set(Doctor::getDepartment, doctor.getDepartment())
                    .eq(Doctor::getId, doctor.getId())
                    .eq(Doctor::getConnectionId, doctor.getConnectionId())
            );
        }
        return Result.success(true);
    }

    @DeleteMapping("/deleteDoctorInfo")
    @ApiOperation("通过ID删除医生信息")
    public Result<Boolean> deleteDoctorInfo(@RequestParam Integer id) {
        return Result.success(doctorService.removeById(id));
    }


}
