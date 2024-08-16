package com.vanpine.Entity.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
    @ApiModelProperty("医生ID")
    private int id;
    @ApiModelProperty("医生日期")
    private LocalDateTime date = LocalDateTime.now();
    @ApiModelProperty("医生名字")
    private String doctorName;
    @ApiModelProperty("预约时间段")
    private LocalDateTime reservationDataSegment;
    @ApiModelProperty("部门")
    private String department;
}
