package com.jzh.bot.plugin.pcr.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.plugin.pcr.entity
 * @className: CharacterRank
 * @description: pcr 任务对象
 * @date 2020/1/16 19:58
 */
@Data
@TableName("PCR_CHARACTER_RANK")
public class CharacterRank {

    @TableId
    private String id;
    private String name;
    private String rank;
    private String url;
    private String imgUrl;
    private String chineseName;
    private String nickName;


}
