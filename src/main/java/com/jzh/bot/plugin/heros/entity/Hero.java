package com.jzh.bot.plugin.heros.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.vo
 * @className: Hero
 * @description: 英雄
 * @date 2020/1/8 15:46
 */
@Data
@TableName("TY_HERO")
public class Hero {

    private Integer id;
    private String name;
    private String nickName;

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Hero hero = (Hero) o;

        return (id != null ? id.equals(hero.id) : hero.id == null) && (name != null ? name.equals(hero.name) : hero.name == null);
    }
}
