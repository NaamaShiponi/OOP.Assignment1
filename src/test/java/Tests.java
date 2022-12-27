import static org.junit.jupiter.api.Assertions.assertEquals;

import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);


    @Test
    public  void GroupAdminTest(){
        GroupAdmin a1=new GroupAdmin();

        // Insert new text
        a1.append("first text");
        assertEquals(a1.getUSB().toString(),"first text");

        //Delete part of the text
        a1.delete(0,5);
        assertEquals(a1.getUSB().toString()," text");

        //Insert new text into existing text
        a1.insert(0, "second");
        assertEquals(a1.getUSB().toString(),"second text");

        //Do undo twice
        a1.undo();
        a1.undo();
        assertEquals(a1.getUSB().toString(),"first text");

        //test with JvmUtilities
        logger.info(()->JvmUtilities.jvmInfo());
        GroupAdmin a2=new GroupAdmin();

        //We can see that the total memory increases when increasing the text
        logger.info(()->"GroupAdmin without information inside "+JvmUtilities.objectTotalSize(a2.getUSB()));
        a2.append("m");
        logger.info(()->"GroupAdmin with only small text inside"+JvmUtilities.objectTotalSize(a2.getUSB()));
        a2.append("pppppppppppppppppppppppppppppppppp");
        logger.info(()->"GroupAdmin with large text inside"+JvmUtilities.objectTotalSize(a2.getUSB()));

        //We can see that the total memory increases when adding members to the group
        logger.info(()->"The size of GroupAdmin without members in the list" + JvmUtilities.objectTotalSize(a2));
        ConcreteMember mm1=new ConcreteMember();
        ConcreteMember mm2=new ConcreteMember();
        ConcreteMember mm3=new ConcreteMember();
        ConcreteMember mm4=new ConcreteMember();
        a2.register(mm1);
        a2.register(mm2);
        a2.register(mm3);
        a2.register(mm4);
        logger.info(()->"The size of GroupAdmin with 4 members in the list"+JvmUtilities.objectTotalSize(a1));

        logger.info(()->"objectFootprint to GroupAdmin"+JvmUtilities.objectFootprint(a2));

        logger.info(()->JvmUtilities.jvmInfo());
    }
    @Test
    public  void ConcreteMemberTest(){
        ConcreteMember m1=new ConcreteMember();
        ConcreteMember m2=new ConcreteMember();
        GroupAdmin a1=new GroupAdmin();

        //Insert a member and after that insert text and check that a member points to current text
        a1.register(m1);
        a1.append("first text");
        assertEquals(a1.getUSB().toString(),m1.getUSB().toString());

        //Insert a member after there is already a text and check that the group has updated the member
        a1.register(m2);
        assertEquals(a1.getUSB().toString(),m2.getUSB().toString());

        //To check that after unregister member in the list the member points to NULL
        a1.unregister(m2);
        assertEquals(null,m2.getUSB());

        //Check that the member is updated after deletion in the text
        a1.delete(0,5);
        assertEquals(a1.getUSB().toString(),m1.getUSB().toString());

        //Check that the member is updated after insert to the text
        a1.insert(0, "second");
        assertEquals(a1.getUSB().toString(),m1.getUSB().toString());

        //Check that the member is updated after undo
        a1.undo();
        a1.undo();
        assertEquals(a1.getUSB().toString(),m1.getUSB().toString());

        //test with JvmUtilities
        logger.info(()->JvmUtilities.jvmInfo());
        ConcreteMember mm1=new ConcreteMember();
        ConcreteMember mm2=new ConcreteMember();
        GroupAdmin a2=new GroupAdmin();


        //Size of a member without a group and with a group
        logger.info(()->"Size of the member without being connected to the group "+JvmUtilities.objectTotalSize(mm1.getUSB()));
        a2.append("m");
        a2.register(mm1);
        logger.info(()->"Size of a member when connected to a group "+JvmUtilities.objectTotalSize(mm1.getUSB()));

        //Size of two members in the same group is equal
        a2.register(mm2);
        assertEquals(JvmUtilities.objectTotalSize(mm1.getUSB()),JvmUtilities.objectTotalSize(mm2.getUSB()));
        logger.info(()->"objectFootprint to member"+JvmUtilities.objectFootprint(mm1));

        logger.info(()->JvmUtilities.jvmInfo());
    }


    // stub method to check external dependencies compatibility
    @Test
    public void JvmUtilitiesTest(){
        ConcreteMember m1=new ConcreteMember();
        ConcreteMember m2=new ConcreteMember();
        ConcreteMember m3=new ConcreteMember();
        ConcreteMember m4=new ConcreteMember();

        GroupAdmin a1=new GroupAdmin();
        logger.info(()->JvmUtilities.objectFootprint(a1));
        a1.append("klklklk");

    }
}
