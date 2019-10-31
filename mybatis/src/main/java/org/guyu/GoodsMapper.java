package org.guyu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guyu
 * created at 2019-09-02 19:53
 */
@Mapper
public interface GoodsMapper {

    void updateJson(@Param("entries") List<Entry> entries);
}
