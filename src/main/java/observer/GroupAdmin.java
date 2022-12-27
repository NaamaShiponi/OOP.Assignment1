package observer;
import java.util.*;

/**
 * This class is designed to keep track of all the member registered to group and update them on changes
 *
 * @author Ben Dabush and Naana Shiponi
 * @version 1.0.0 Dec 26 2022
 */
public class GroupAdmin implements Sender{

    /**
     * Generic params for the class
     *
     * @param listUSB  - A list of members registered in the group
     * @param USB - Saves the text in UndoableStringBuilder class
     */
    private List<Member> listUSB;

    private UndoableStringBuilder USB;

    /**
     * A constructor of GroupAdmin class
     */
    public GroupAdmin (){
        USB=new UndoableStringBuilder();
        listUSB=new ArrayList<Member>();
    }

    /**
     * register function -
     * Make a member registration
     *
     * @param obj - object of Member
     */
    @Override
    public void register(Member obj) {
        obj.update(USB);
        listUSB.add(obj);
    }

    /**
     * unregister function -
     * Unsubscribing to member
     *
     * @param obj - object of Member
     */
    @Override
    public void unregister(Member obj) {
        obj.update(null);
        listUSB.remove(obj);
    }

    /**
     * insert function -
     * Inserts the string into the USB.
     *
     * @param offset -Enters from this character index
     * @param obj    -New text to be inserted
     */
    @Override
    public void insert(int offset, String obj) {
        USB.insert(offset,obj);
    }

    /**
     * append function -
     * Appends the specified string to the USB character string.
     *
     * @param obj - The new content of the repository.
     */
    @Override
    public void append(String obj) {
        USB.append(obj);
    }

    /**
     * delete function -
     * Delete a section of the text from the start-to-end index
     *
     * @param start - Removes characters from this index
     * @param end   - Removes characters up to this index
     */
    @Override
    public void delete(int start, int end) {
        USB.delete(start,end);
    }


    /**
     * undo function -
     * Returns to the previous text that was on the USB
     *
     */
    @Override
    public void undo() {
        USB.undo();
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

    /**
     * getUSB function -
     * get to USB
     *
     * @return UndoableStringBuilder
     */
    public UndoableStringBuilder getUSB() {
        return USB;
    }


}
