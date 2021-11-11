package com.project.nyvia380server.common.user;


public interface User {

    /*TODO
        Base:
         LogeIn()
         LogeOut()
         ConnectToChatRoom(%id%)
         DisconnectFromChat(%id%)
         SendMessage(%message%, %to%)
       */

    /*TODO
        Moderator:
         RemoveUserFromChat(%id%)
         DeleteUserMessage(%id%)
         SuspendUserFromChats(%uId%)
         BanUserFromChat(%uId%,%rId%)
         FreezeUserChatting(%id%,duration)
       */

    /*TODO
       Admin:
        AssignModerator(%id%)      : return new Moderator
        ReassignModerator(%id)
        DeleteUser(%id%)
        CreateUser(%user%)        : return new User

       */
    /*
       TODO
        EXTRA:
         EditMessage(%id%,%uId%)
         SearchMessage(%rId%,String)

    */

}
