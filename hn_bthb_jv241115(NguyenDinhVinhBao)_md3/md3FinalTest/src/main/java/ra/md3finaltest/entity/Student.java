package ra.md3finaltest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Student {
    @Id
    @Column(columnDefinition = "CHAR(5)")
    private String id;
    @Column(name="student_name",length = 200,nullable = false)
    private String studentName;
    @Column(columnDefinition = "text",nullable = false,unique = true)
    private String email;
    @Column(length = 15,nullable = false,unique = true)
    private String phone;
    @Column(nullable = false)
    private boolean sex;
    @Column(name="dob",nullable = false)
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(columnDefinition = "text")
    private String avatar;
    @Column(nullable = false)
    private boolean status;



}
