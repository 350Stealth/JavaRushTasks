package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;
    
    static {
        if (president == null)
        synchronized (OurPresident.president){
            president = new OurPresident();
        }
    }
    
    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        /*if (president == null) {
            president = new OurPresident();
            return president;
        } else {*/
            return president;
//        }
    }
}
