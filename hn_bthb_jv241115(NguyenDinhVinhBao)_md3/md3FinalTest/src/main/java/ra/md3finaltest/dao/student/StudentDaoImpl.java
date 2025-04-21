package ra.md3finaltest.dao.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.md3finaltest.entity.Course;
import ra.md3finaltest.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StudentDaoImpl implements IStudentDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> pagination(String keyword, int limit, int offset) {
        List<Student> s =  entityManager.createQuery("FROM Student S Where S.studentName like :name",Student.class)
                .setParameter("name", "%" + keyword + "%")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        return s;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void delete(String id) {

    }
}
