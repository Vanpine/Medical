package com.vanpine.Entity.PO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("病人类")
public class Patient {
    @ApiModelProperty("病人ID")
    private int id;
    @ApiModelProperty("病人名字")
    private String patientName;
    @ApiModelProperty("病人年龄")
    private String patientAge;
    @ApiModelProperty("病人性别")
    private String patientGender;
    @ApiModelProperty("病人连接id")
    private int patientConnectionId;
}
