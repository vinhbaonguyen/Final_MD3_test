package ra.md3finaltest.service.student;

import org.springframework.stereotype.Service;
import ra.md3finaltest.entity.Course;
import ra.md3finaltest.entity.Student;
import ra.md3finaltest.service.IGenericService;

import java.util.List;

@Service
public interface IStudentService extends IGenericService<Student,String> {
    List<Student> pagination(String keyword, int page, int size);

}
