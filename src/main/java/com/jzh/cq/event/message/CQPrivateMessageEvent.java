package com.jzh.cq.event.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.jzh.cq.entity.CQUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CQPrivateMessageEvent extends CQMessageEvent {
    @JSONField(name = "sub_type")
    private String subType;
    @JSONField(name = "sender")
    private CQUser sender;
}
