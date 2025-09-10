package frc.robot;

public class States {
    public enum armPos {
        acute(0), right(1), obtuse(2), striaght(3), fullRot(4), NOTHING(99);
                public int val;
                armPos(int val) {
                        this.val = val;

                }
        
    }
    
}
