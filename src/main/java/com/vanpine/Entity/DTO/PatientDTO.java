package com.vanpine.Entity.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PatientDTO {
    @ApiModelProperty("病人名字")
    private String patientName;

    @ApiModelProperty("病人年龄")
    private String patientAge;

    @ApiModelProperty("病人性别")
    private String patientGender;

    @ApiModelProperty("病人连接id")
    private int patientConnectionId;
}
