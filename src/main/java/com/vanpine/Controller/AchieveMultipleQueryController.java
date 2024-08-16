package com.vanpine.Controller;

import com.vanpine.Entity.Result;
import com.vanpine.Entity.VO.PatientAndDoctorVO;
import com.vanpine.Mapper.PatientAndDoctorMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "实现多表联查接口")
@RequiredArgsConstructor
public class AchieveMultipleQueryController {

    private final PatientAndDoctorMapper patientAndDoctorMapper;

    @GetMapping("/multipleQuery")
    @ApiOperation("根据Id查询病人对应的医生信息")
    public Result<List<PatientAndDoctorVO>> MultipleQuery(@RequestParam("id") Integer patientConnectionId) {
        return Result.success(patientAndDoctorMapper.multipleQuery(patientConnectionId));
    }
}
