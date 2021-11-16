package com.project.nyvia380server.common.user;

import com.project.nyvia380server.common.user.group.Group;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Set;

import static com.project.nyvia380server.common.user.Privilege.ADMIN;


@SuperBuilder
public class Admin extends Moderator {

    //FIXME fix child classes

   /* private final String id;
    private final String firstName;
    private final String lastName;
    private final int age;
    @Builder.Default // clears initialization of annotated field
    private final Privilege privilege = ADMIN;
    private final String alias;
    private Set<Group> groups;
*/


}
