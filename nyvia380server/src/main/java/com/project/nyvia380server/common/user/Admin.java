package com.project.nyvia380server.common.user;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.project.nyvia380server.common.user.Privilege.ADMIN;

@TypeAlias("Admins")
@SuperBuilder
public class Admin extends Moderator {
    @Field("Super")
    @Builder.Default
    protected final Privilege privilege = ADMIN;


}
