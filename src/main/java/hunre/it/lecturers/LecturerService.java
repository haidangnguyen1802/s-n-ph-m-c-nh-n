package hunre.it.lecturers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository repository;

    // Lấy danh sách tất cả giảng viên
    public List<Lecturer> listAll() {
        return repository.findAll();
    }

    // Lấy giảng viên theo ID
    public Lecturer get(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Lưu giảng viên
    public Lecturer save(Lecturer lecturer) {
        return repository.save(lecturer);
    }

    // Xóa giảng viên
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // Tìm kiếm giảng viên theo mã giảng viên hoặc tên
    public List<Lecturer> searchLecturers(String query) {
        return repository.findByLecturerCodeContainingOrFullNameContaining(query, query);
    }
}