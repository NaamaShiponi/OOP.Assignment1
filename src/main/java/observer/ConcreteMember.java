package observer;

/**
 * Class of a Member who can follow a GroupAdmin
 *
 * @author Ben Dabush and Naana Shiponi
 * @version 1.0.0 Dec 26 2022
 */
public class ConcreteMember implements Member{

    /**
     * Generic params for the class
     *
     * @param USB - Save the UndoableStringBuilder from GroupAdmin
     */
    private UndoableStringBuilder USB;

    /**
     * A constructor of ConcreteMember class
     */
    public ConcreteMember(){
        USB = new UndoableStringBuilder();
    }

    /**
     * delete function -
     * Updates the member to point to UndoableStringBuilder of GroupAdmin
     *
     * @param usb   - Save point to UndoableStringBuilder
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.USB = usb;
    }

    /**
     * getUSB function -
     * get to USB
     *
     * @return UndoableStringBuilder
     */
    public UndoableStringBuilder getUSB() {
        return USB;
    }

    /**
     * setUSB function -
     * set USB
     *
     * @param USB UndoableStringBuilder
     */
    public void setUSB(UndoableStringBuilder USB) {
        this.USB = USB;
    }
}
