package org.guyu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.guyu.domain.d0.TJsonDO;

import java.util.List;

/**
 * @author guyu
 * @date 2019-11-10
 */
@Mapper
public interface TJsonMapper {
    int insert(@Param("params") TJsonDO tJsonDO);

    List<TJsonDO> selectAll();
}
