package frc.robot;

public class States {
    public enum armPos {
        thirty(0), sixty(1), ninety(2), oneEighty(3), twoSeventy(4), threeSixity(5), NOTHING(99);
                public int val;
                armPos(int val) {
                        this.val = val;

                }
        
    }
    
}
