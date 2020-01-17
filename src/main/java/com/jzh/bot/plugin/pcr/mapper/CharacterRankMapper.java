package com.jzh.bot.plugin.pcr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzh.bot.plugin.pcr.entity.CharacterRank;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.plugin.pcr.mapper
 * @className: CharacterRankMapper
 * @description: CharacterRank类mapper
 * @date 2020/1/17 11:30
 */
public interface CharacterRankMapper extends BaseMapper<CharacterRank> {

    @Select("select id from PCR_CHARACTER_RANK")
    List<String> selectAllCharacterId();

    @Select("select * from PCR_CHARACTER_RANK")
    List<CharacterRank> selectAll();

    @Select("select * from PCR_CHARACTER_RANK where rank=#{rank}")
    List<CharacterRank> selectByRank(String rank);
}
