package com.tqsm.life.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/11/6 9:48
 */
@Data
public class UserManagementHisVO {

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "年龄")
    private String age;

    @Schema(description = "性别（女：0，男：1）")
    private Integer sex;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "手机号")
    private String tel;

    @Schema(description = "科室名称")
    private String deptName;

    @Schema(description = "诊断名称")
    private String diagName;

    @Schema(description = "住院证号")
    private String inpatientNo;
}
