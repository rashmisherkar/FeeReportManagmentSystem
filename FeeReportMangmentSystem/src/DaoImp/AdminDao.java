package DaoImp;

import java.util.List;

import Entity.AccountantPojo;

public interface AdminDao {

	boolean save(AccountantPojo ap);
	List<AccountantPojo> view(AccountantPojo ap);
	
	
}
