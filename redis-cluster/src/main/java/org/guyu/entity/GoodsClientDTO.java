package org.guyu.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guyu
 * created at 2019-09-14 10:32
 */
@Data
public class GoodsClientDTO {
    private Long id;
    private Long appGoodsId;
    private String title;
    private String description;
    private BigDecimal originPrice;
    private BigDecimal sellPrice;
    private Long spuId;
    private String spuName;
    private Integer sales;
    private Integer stock;
    private Map<String, Object> attrs;
    private String cover;
    private String detailPic;
    private String videoSrc;
}
