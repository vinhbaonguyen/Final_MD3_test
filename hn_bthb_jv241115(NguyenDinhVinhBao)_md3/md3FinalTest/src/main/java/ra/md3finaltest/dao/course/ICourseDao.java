package ra.md3finaltest.dao.course;

import ra.md3finaltest.dao.IGenericDao;
import ra.md3finaltest.entity.Course;

import java.util.List;

public interface ICourseDao extends IGenericDao<Course, Integer> {
    List<Course> pagination(String keyword, int limit, int offset);
    boolean existByName(String name);
}
