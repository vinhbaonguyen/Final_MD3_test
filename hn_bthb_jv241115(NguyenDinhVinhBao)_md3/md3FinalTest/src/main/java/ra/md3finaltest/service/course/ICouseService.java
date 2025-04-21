package ra.md3finaltest.service.course;

import ra.md3finaltest.entity.Course;
import ra.md3finaltest.service.IGenericService;

import java.util.List;

public interface ICouseService extends IGenericService<Course,Integer> {
    List<Course> pagination(String keyword, int page, int size);
    int countTotalPages(int size);
}
