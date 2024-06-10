package StudentManagement;

/**
 * field of {@link StudentModule}
 *
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class Mark {
	private int mark;
	private String note;
	
	/**
	 * constructor for module mark
	 * @param markScore
	 * @param note
	 */
	public Mark(int markScore, String note) {
		if(mark >= 0 && mark <= 100) {
            this.mark = markScore;
        }
        this.note = note;
	}

	/**
	 * getter
	 * @return
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * getter
	 * @return
	 */
	public String getNote() {
		return note;
	}
	
	/**
	 * get mark to string
	 * @return
	 */
	public String getMarkToString() {
		return getMark()+ "\t"+getNote()+"\n";
	}

}
