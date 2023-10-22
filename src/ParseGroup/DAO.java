package ParseGroup;

public class DAO {


    public enum ConduomStatus {NONE, HELD, GONE};
    public static ConduomStatus conduomStatus = ConduomStatus.NONE;


    static {
        conduomStatus = ConduomStatus.NONE;
    }

}
