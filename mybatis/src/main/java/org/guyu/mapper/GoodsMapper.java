package org.guyu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.guyu.Entry;
import org.guyu.domain.d0.GoodsDO;

import java.util.List;
import java.util.Map;

/**
 * @author guyu
 * created at 2019-09-02 19:53
 */
@Mapper
public interface GoodsMapper {
    int insert(@Param("goods") GoodsDO goodsDO);

    void updateJson(@Param("entries") List<Entry> entries);
}
