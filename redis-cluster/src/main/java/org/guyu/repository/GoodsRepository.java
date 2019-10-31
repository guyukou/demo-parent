package org.guyu.repository;

import org.guyu.entity.GoodsClientDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author guyu
 * @date 2019-10-22
 */
public interface GoodsRepository extends CrudRepository<GoodsClientDTO, Long> {

}