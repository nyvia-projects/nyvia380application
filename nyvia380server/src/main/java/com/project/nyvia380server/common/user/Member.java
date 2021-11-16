package com.project.nyvia380server.common.user;


import com.project.nyvia380server.common.user.group.Group;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.UUID;

import static com.project.nyvia380server.common.user.Privilege.NONE;

@Document(collection = "Users")
@Data
@SuperBuilder
@NoArgsConstructor(force = true)
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor)) //Sets @ReqArgsCons @PersistCons
public class Member implements User {

    @Id
    protected final String id;
    protected final String firstName;
    protected final String lastName;
    protected final int age;
    @Builder.Default // clears initialization of annotated field
    protected final Privilege privilege = NONE;
    protected final String alias;
    protected Set<Group> groups; //FIXME returns null for non-final

    protected Set<Group> addGroup(Group group) {
        this.groups.add(group);
        return this.groups;
    }


}
