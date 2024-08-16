package com.vanpine.Entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "医生VO类")
public class DoctorVO {
    @ApiModelProperty("医生ID")
    private int id;
    @ApiModelProperty("医生名字")
    private String doctorName;
    @ApiModelProperty("部门")
    private String department;
    @ApiModelProperty("医生日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now();

    @ApiModelProperty("预约时间段")
    @JsonFormat(pattern = "HH:mm")
    private LocalDateTime reservationDateSegment = LocalDateTime.now();


}
