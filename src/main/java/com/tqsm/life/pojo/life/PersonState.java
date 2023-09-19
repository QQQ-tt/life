package com.tqsm.life.pojo.life;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qtx
 * @since 2023/8/24
 */
@Data
public class PersonState implements Serializable {

    private String code;

    private String text;
}
