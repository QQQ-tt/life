package com.tqsm.life.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/31 11:36
 */
@Data
public class PageDTO<T> {

    private long pageNum;

    private long pageSize;

    @JsonIgnore
    public IPage<T> getPage() {
        return com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO.of(pageNum, pageSize);
    }
}
