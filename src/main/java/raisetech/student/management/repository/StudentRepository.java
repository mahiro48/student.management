package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;


/**
 * 受講生情報を扱うリポジトリーです。
 *
 * 全件検索や単一条件での検索、コース情報の検索ができるクラスです。
 *
 *
 */


@Mapper
public interface StudentRepository {

  /**
   * 全件検索します。
   *
   * @return 全件検索した受講生情報の一覧。
   */

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchStudentCoursesList();

  @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
  List<StudentCourses> searchStudentCourses(String studentId);

  @Insert("INSERT INTO students(name, kanaName, nickname, email, region, age, sex, remark, isDeleted) "
      + "VALUES(#{name}, #{kanaName}, #{nickname}, #{email}, #{region}, #{age}, #{sex}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(student_id, course_name, start_date, end_date)"
      + "VALUES(#{studentId}, #{courseName}, #{startDate}, #{endDate})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentCourses studentCourses);


  //受講生更新
  @Update(
      "UPDATE students SET name = #{name},kanaName = #{kanaName},nickname = #{nickname},email = #{email},region = #{region}"
          + ",age = #{age},sex = #{sex},remark = #{remark},isDeleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET course_name = #{courseName} WHERE id = #{id}")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void updateStudentsCourses(StudentCourses studentCourses);


}
