package ra.md3finaltest.dao.course;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import ra.md3finaltest.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseDaoImpl implements ICourseDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> pagination(String keyword, int limit, int offset) {

        List<Course> l =  entityManager.createQuery("FROM Course C Where C.name like :name",Course.class)
                .setParameter("name", "%" + keyword + "%")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        return l;
    }

    @Override
    public boolean existByName(String name) {
        return !entityManager.createQuery("FROM Course C where C.name like :name ")
                                        .setParameter("name", "%"+name+"%")
                                        .getResultList()
                                        .isEmpty();
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course C", Course.class).getResultList();
    }

    @Override
    public Course findById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void save(Course course) {
        if(course.getId()==null){
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }

    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findById(id));

    }
}
