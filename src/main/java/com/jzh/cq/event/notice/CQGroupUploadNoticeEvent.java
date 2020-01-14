package com.jzh.cq.event.notice;

import com.alibaba.fastjson.annotation.JSONField;
import com.jzh.cq.entity.CQFile;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CQGroupUploadNoticeEvent extends CQNoticeEvent {
    @JSONField(name = "group_id")
    private long groupId;
    @JSONField(name = "file")
    private CQFile file;
}
