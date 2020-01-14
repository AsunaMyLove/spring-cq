package com.jzh.cq.event.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.jzh.cq.entity.CQUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CQDiscussMessageEvent extends CQMessageEvent {
    @JSONField(name = "discuss_id")
    private long discussId;
    @JSONField(name = "sender")
    private CQUser sender;
}
