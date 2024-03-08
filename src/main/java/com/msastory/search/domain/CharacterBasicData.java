package com.msastory.search.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.msastory.search.config.ZonedDateTimeDeserializer;

import lombok.Data;
import lombok.ToString;

/**
 * CharacterData
 */
@Data
@ToString
public class CharacterBasicData {
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime date;
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