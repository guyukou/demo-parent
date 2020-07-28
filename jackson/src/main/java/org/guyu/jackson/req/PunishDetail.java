package org.guyu.jackson.req;

import org.guyu.jackson.enums.PunishType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-27
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "punishType", visible = true)
@JsonSubTypes(value = {
        @JsonSubTypes.Type(value = PunishDetailProfile.class, name = "1"),
        @JsonSubTypes.Type(value = PunishDetailScore.class, name = "8"),
})
@Data
public class PunishDetail {
    private PunishType punishType;
}
