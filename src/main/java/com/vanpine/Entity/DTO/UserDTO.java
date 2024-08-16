package com.vanpine.Entity.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("病人DTO")
public class UserDTO {
    @ApiModelProperty("医生ID")
    private int id;
    @ApiModelProperty("医生名字")
    private String doctorName;
    @ApiModelProperty("预约时间段")
    private LocalDateTime reservationDataSegment;
    @ApiModelProperty("部门")
    private String department;
}
