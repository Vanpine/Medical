package com.vanpine.Entity.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "医生DTO类")
public class DoctorDTO {

    @ApiModelProperty("医生ID")
    private int id;

    @ApiModelProperty("医生名字")
    private String doctorName;

    @ApiModelProperty("部门")
    private String department;

}
