package com.tqsm.life.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/31 10:26
 */
@Data
public class UserManagementVO {

    @Schema(description = "id")
    private Integer id;

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
}
