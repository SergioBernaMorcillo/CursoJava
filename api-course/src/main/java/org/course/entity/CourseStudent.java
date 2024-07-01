package org.course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor  // Constructor sin argumentos requerido por JPA
@Entity
@Table(name = "COURSE_STUDENT")
public class CourseStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STUDENT_ID", nullable = false)
    private Long student_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COURSE_ID", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_CourseStudent_Course"))
    @JsonIgnore
    private Course course;

    // Constructor adicional sin id, útil para persistencia
    public CourseStudent(Course course, Long idStudent) {
        this.course = course;
        this.student_id = idStudent;
    }
}
