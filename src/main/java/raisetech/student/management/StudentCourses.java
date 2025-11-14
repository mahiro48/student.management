package raisetech.student.management;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourses {
  private int courseId;
  private int studentId;
  private String courseName;
  private Timestamp startDate;
  private Timestamp endDate;
}