package com.example.homework.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;

    private String comment;

    @JsonProperty("full_name")
    private String fullName;

    @Getter(AccessLevel.NONE)
    private UserDto user;

    @JsonProperty("created_at")
    private Instant createdAt;

}
