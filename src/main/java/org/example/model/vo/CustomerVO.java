package org.example.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.rest.jackson.CustomDateSerializer;

import java.util.Date;

@Builder
public record CustomerVO(String name, @JsonSerialize(using = CustomDateSerializer.class) Date birthday) {
    public CustomerVO(
            @JsonProperty(value = "name", required = true) String name,
            @JsonProperty(value = "birthday") Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
