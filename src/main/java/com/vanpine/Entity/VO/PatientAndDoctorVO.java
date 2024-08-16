package com.vanpine.Entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("病人和医生的DTO")
@Data
public class PatientAndDoctorVO {
    @ApiModelProperty("病人ID")
    private int id;

    @ApiModelProperty("病人名字")
    private String patientName;

    @ApiModelProperty("病人年龄")
    private String patientAge;

    @ApiModelProperty("病人性别")
    private String patientGender;


    @ApiModelProperty("医生名字")
    private String doctorName;

    @ApiModelProperty("部门")
    private String department;
}
