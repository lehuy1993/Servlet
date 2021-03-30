package fa.training.idao;

public interface AccountDao<T, ID>  extends IDao<T, ID>{

	
	public  boolean login(String username, String password) throws  ClassNotFoundException;
}
