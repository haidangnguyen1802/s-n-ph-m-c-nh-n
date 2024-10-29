package hunre.it.lecturers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer>{
	// Tìm kiếm giảng viên theo mã giảng viên hoặc họ và tên
    List<Lecturer> findByLecturerCodeContainingOrFullNameContaining(String lecturerCode, String fullName);
}
