package com.project.nyvia380server.common.user.group;

import com.project.nyvia380server.common.user.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Group {
    //TODO Implement Groups

    private String groupName;
    private Member groupLeader;
    private int userCount;
    private String groupDescription;
}
