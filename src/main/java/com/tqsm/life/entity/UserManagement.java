package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tqsm.life.config.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Getter
@Setter
@TableName("user_management")
public class UserManagement extends BaseEntity {

    /**
     * 姓名
     */
    @Schema(description = "姓名")
    @TableField("name")
    private String name;

    /**
     * 男：1 女：0
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 身份证号
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 手机号
     */
    @TableField("tel")
    private String tel;

    /**
     * 住院证号
     */
    @TableField("inpatient_no")
    private String inpatientNo;
}
