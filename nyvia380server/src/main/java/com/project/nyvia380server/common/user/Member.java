package com.project.nyvia380server.common.user;


import com.project.nyvia380server.common.user.group.Group;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;
import java.util.UUID;

import static com.project.nyvia380server.common.user.Privilege.NONE;

@Document(collection = "Users")
@TypeAlias("Members")
@Getter
@SuperBuilder
@NoArgsConstructor(force = true)
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor)) //Sets @ReqArgsCons @PersistCons
public class Member implements User {

    @Id
    protected String id;
    protected String firstName;
    protected String lastName;
    protected int age;

    @Builder.Default // clears initialization of annotated field
    protected Privilege privilege = NONE;
    protected final String alias;
    protected Set<Group> groups; //FIXME returns null for non-final

    protected Set<Group> addGroup(Group group) {
        this.groups.add(group);
        return this.groups;
    }


}
