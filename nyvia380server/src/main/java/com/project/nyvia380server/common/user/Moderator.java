package com.project.nyvia380server.common.user;


import com.project.nyvia380server.common.user.group.Group;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

import static com.project.nyvia380server.common.user.Privilege.MODERATOR;

@TypeAlias("Moderators")
@SuperBuilder
@NoArgsConstructor
public class Moderator extends Member {

    @Builder.Default
    @Field("Moderator")
    private Privilege privilege = MODERATOR;

}

