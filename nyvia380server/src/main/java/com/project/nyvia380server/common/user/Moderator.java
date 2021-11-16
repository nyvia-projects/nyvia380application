package com.project.nyvia380server.common.user;


import com.project.nyvia380server.common.user.group.Group;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Set;

import static com.project.nyvia380server.common.user.Privilege.MODERATOR;

@SuperBuilder
public class Moderator extends Member {

    //FIXME fix child classes
    /*protected final String id;
    protected final String firstName;
    protected final String lastName;
    protected final int age;
    @Builder.Default // clears initialization of annotated field
    protected final Privilege privilege = MODERATOR;
    protected final String alias;
    protected Set<Group> groups;*/

}
