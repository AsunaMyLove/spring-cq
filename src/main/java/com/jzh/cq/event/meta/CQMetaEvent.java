package com.jzh.cq.event.meta;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.jzh.cq.event.CQEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class CQMetaEvent extends CQEvent {
    @JSONField(name = "meta_event_type")
    private String metaEventType;
}
