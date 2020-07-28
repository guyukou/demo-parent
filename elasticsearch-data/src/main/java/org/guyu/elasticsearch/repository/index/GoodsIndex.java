package org.guyu.elasticsearch.repository.index;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guyu
 * created at 2019-08-29 15:43
 */
@Data
@Document(indexName = "goods", type = "goods")
public class GoodsIndex {
    @Id
    private Long id;
    private Integer appId;
    private Long appGoodsId;
    private String name;
    private String title;
    private Map<String, Object> attrs;
    private byte goodsType;
    private BigDecimal originPrice;
    private BigDecimal sellPrice;
    private byte orderTypeVal;
    private byte status;
    private Date createTime;
    private Boolean isDeleted;
    private Integer sort;
    @JsonProperty("spuToGoods")
    private List<GoodsIndexSpu> spus;
    @JsonProperty("stockGoods")
    private GoodsIndexStock stock;
}
