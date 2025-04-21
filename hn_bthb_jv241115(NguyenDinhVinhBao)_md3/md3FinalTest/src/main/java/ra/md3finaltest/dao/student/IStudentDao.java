package ra.md3finaltest.dao.student;

import ra.md3finaltest.dao.IGenericDao;
import ra.md3finaltest.entity.Course;
import ra.md3finaltest.entity.Student;

import java.util.List;

public interface IStudentDao extends IGenericDao<Student, String> {
    List<Student> pagination(String keyword, int limit, int offset);
}
