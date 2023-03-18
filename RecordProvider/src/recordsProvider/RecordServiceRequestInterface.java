package recordsProvider;

public interface RecordServiceRequestInterface {
	public void save(String descr, int custId);

	public void printHistory();

	public void printHistory(int custID);

	public void printOngoing();

	public void printOngoing(int custID);

	public void update(String action, int reqID);

	public int getListLength();
}
