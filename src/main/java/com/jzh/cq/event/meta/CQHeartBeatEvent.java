package com.jzh.cq.event.meta;

import com.alibaba.fastjson.annotation.JSONField;
import com.jzh.cq.entity.CQStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CQHeartBeatEvent extends CQMetaEvent {
    @JSONField(name = "status")
    private CQStatus status;
}
