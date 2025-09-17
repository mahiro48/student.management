package raisetech.student.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
@RestController
public class Application {

	// スレッドセーフなフィールドに変更
	private final AtomicReference<String> name = new AtomicReference<>("Mahiro Ochiai");
	private final AtomicReference<String> age = new AtomicReference<>("27");

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo() {
		return name.get() + " " + age.get() + "歳";
	}

	@PostMapping("/studentInfo")
	public void setStudentInfo(@RequestParam String name, @RequestParam String age) {
		this.name.set(name);
		this.age.set(age);
	}

	@PostMapping("/studentName")
	public void updateStudentName(@RequestParam String name) {
		this.name.set(name);
	}
}






