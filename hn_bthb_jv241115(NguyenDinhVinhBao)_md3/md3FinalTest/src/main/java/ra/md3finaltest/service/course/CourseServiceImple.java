package ra.md3finaltest.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.md3finaltest.dao.course.ICourseDao;
import ra.md3finaltest.entity.Course;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImple implements ICouseService{
    @Autowired
    private ICourseDao courseDao;
    @Override
    public List<Course> pagination(String keyword, int page, int size) {
        return courseDao.pagination(keyword, size, size*page);
    }

    @Override
    public int countTotalPages(int size) {
        int totalElements = courseDao.findAll().size();
        int mod = totalElements % size;
        int total = totalElements / size;
        return mod==0?total:total + 1;
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseDao.findById(id);
    }

    @Transactional
    @Override
    public void create(Course entity) {
        courseDao.save(entity);
    }

    @Transactional
    @Override
    public void update(Course entity, Integer id) {
        entity.setId(id);
        courseDao.save(entity);
    }




    @Transactional
    @Override
    public void delete(Integer id) {
        courseDao.delete(id);
    }
}
