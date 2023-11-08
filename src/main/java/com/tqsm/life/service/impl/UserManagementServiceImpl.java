package com.tqsm.life.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.config.exception.DataEnums;
import com.tqsm.life.config.exception.DataException;
import com.tqsm.life.entity.UserManagement;
import com.tqsm.life.mapper.UserManagementMapper;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.vo.UserManagementHisVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import com.tqsm.life.service.UserManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Service
public class UserManagementServiceImpl extends ServiceImpl<UserManagementMapper, UserManagement> implements UserManagementService {

    @Autowired
    private UserManagementMapper userManagementMapper;


    @Override
    public boolean saveOrUpdateNew(UserManagement dto) {
        String idCard = dto.getIdCard();
        if (StringUtils.isBlank(idCard)){
            throw  new DataException(DataEnums.ID_CARD_IS_FAIL);
        }
//        UserManagement one = getOne(Wrappers.lambdaQuery(UserManagement.class)
//                .eq(StringUtils.isNotBlank(dto.getName()),
//                        UserManagement::getName,
//                        dto.getName())
//                .eq(dto.getSex()!=null,
//                        UserManagement::getSex,
//                        dto.getSex())
//                .eq(StringUtils.isNotBlank(dto.getIdCard()),
//                        UserManagement::getIdCard,
//                        dto.getIdCard())
////                .eq(StringUtils.isNotBlank(dto.getTel()),
////                        UserManagement::getTel,
////                        dto.getTel())
//                .or()
//                .ne(dto.getId() == null,
//                        UserManagement::getId,
//                        dto.getId()));
//        if (Objects.isNull(one)) {
            return saveOrUpdate(dto);
//        } else {
//            throw new DataException(DataEnums.FAILED);
//        }
    }

    @Override
    public IPage<UserManagementVO> listUserManagementPage(UserManagementDTO dto) {
        Page<UserManagementVO> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        return userManagementMapper.listUserManagementPage(page, dto);
    }

    @Override
    @DS("his")
    public IPage<UserManagementHisVO> userForHisList(UserManagementDTO dto) {
        return userManagementMapper.userForHisList(dto);
    }
}
