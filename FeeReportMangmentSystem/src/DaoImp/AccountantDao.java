package DaoImp;


import java.util.ArrayList;
import java.util.List;

import Entity.StudentPojo;

public interface AccountantDao {

	 boolean save(StudentPojo s);
	boolean update(StudentPojo s);
	ArrayList<StudentPojo> view(StudentPojo sPojo);
	List<StudentPojo> due(StudentPojo spPojo);
	
	
	 boolean validate(String name,String password);
}
