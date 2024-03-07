package com.msastory.search.domain;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * CharacterData
 */
@Data
public class CharacterBasicData {
    private LocalDateTime date;
    private String character_name;
    private String world_name;
    private String character_gender;
    private String character_class;
    private String character_class_level;
    private Long character_level;
    private Long character_exp;
    private String character_exp_rate;
    private String character_guild_name;
    private String character_image;
}