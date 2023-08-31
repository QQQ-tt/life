package com.tqsm.life.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.tqsm.life.config.PageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/31 10:27
 */
@Data
public class UserManagementDTO  extends PageDTO {

    @Schema(description = "姓名")
    @TableField("name")
    private String name;

    @Schema(description = "性别（女：0，男：1）")
    @TableField("sex")
    private Integer sex;

    @Schema(description = "身份证号")
    @TableField("id_card")
    private String idCard;


}
