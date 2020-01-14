package com.jzh.cq.event.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.jzh.cq.entity.CQGroupAnonymous;
import com.jzh.cq.entity.CQGroupUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CQGroupMessageEvent extends CQMessageEvent {
    @JSONField(name = "sub_type")
    private String subType;
    @JSONField(name = "group_id")
    private long groupId;
    @JSONField(name = "anonymous")
    private CQGroupAnonymous anonymous;
    @JSONField(name = "sender")
    private CQGroupUser sender;
}
