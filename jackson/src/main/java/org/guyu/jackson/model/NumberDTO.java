package org.guyu.jackson.model;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-31
 */
@Data
public class NumberDTO {
    @Max(value = 20, message = "一般违规分范围为0-20")
    private int intValue;
}
