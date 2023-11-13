package org.example.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Builder
public final class CustomerVO {
    private final String name;
    //todo: add serializer/deserializer
    private final Date birthday;
}
