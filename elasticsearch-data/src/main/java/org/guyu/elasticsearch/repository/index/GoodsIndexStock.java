package org.guyu.elasticsearch.repository.index;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author guyu
 * created at 2019-08-29 15:51
 */
@Data
public class GoodsIndexStock {
    @JsonProperty("soldQuantity")
    private Integer sales;
    @JsonProperty("effectiveQuantity")
    private Integer stock;
    @JsonProperty("status")
    private Byte soldStatus;
}
