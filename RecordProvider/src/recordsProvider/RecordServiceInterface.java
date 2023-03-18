package recordsProvider;

public interface RecordServiceInterface {
	public void save(String descr, int custId);

	public void printHistory();

	public void printOngoing();

	public void update(String action, int reqID);

	public int getListLength();
}
