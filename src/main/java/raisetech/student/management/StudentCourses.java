package raisetech.student.management;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter

public class StudentCourses {
  private int id;
  private int studentId;
  private String courseName;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
}

