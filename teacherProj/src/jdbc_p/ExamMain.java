package jdbc_p;

import sun.security.jca.GetInstance.Instance;

public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(ExamDTO dto: new ExamDAO().getList())
		{
			System.out.println(dto.getSid() instanceof String );
			
			
			
		}
	}

}
