package com.wang.spring6.test;

import com.wang.spring6.web.UserAction;
import org.junit.Test;

public class UserActionTest {
    UserAction userAction = new UserAction();
    @Test
    public void testUserAction(){
        userAction.deleteRequest();
    }

}
