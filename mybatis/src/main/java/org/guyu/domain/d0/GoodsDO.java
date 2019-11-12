package org.guyu.domain.d0;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Data
public class GoodsDO  {
    private Long id;

    /**
     * 归属方id
     */
    private Integer appId;

    /**
     * 应用方商品id
     */
    private Long appGoodsId;

    private Byte status;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品前台名称
     */
    private String title;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 动态属性
     */
    private String attrs;


    private BigDecimal originPrice;

    private BigDecimal sellPrice;

    /**
    private String description;

    /**
     * 状态 1未上架2.已上架 3.已下架
     */

    /**
     * 是否赠品
     */
    private Boolean gift;

    /**
     * 是否可用
     */
    private Boolean deleted;

    /**
     * 排序
     */
    private Integer sort;

    private Long creatorId;

    private Long updaterId;

    /**
     * 头图url
     */
    private String cover;

    /**
     * 详情页url
     */
    private String detailPic;

    /**
     * 试听课视频url
     */
    private String videoSrc;

    private Date createTime;


    private Date updateTime;

}