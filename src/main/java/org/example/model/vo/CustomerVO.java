package org.example.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import org.example.rest.jackson.CustomDateSerializer;

import java.util.Date;

@Data
@Builder
public class CustomerVO {
    private final String name;
    @JsonSerialize(using = CustomDateSerializer.class)
    private final Date birthday;

    public CustomerVO(
            @JsonProperty(value = "name", required = true) String name,
            @JsonProperty(value = "birthday") Date birthday
    ) {
        this.name = name;
        this.birthday = birthday;
    }
}
