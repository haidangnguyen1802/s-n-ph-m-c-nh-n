package hunre.it.lecturers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecturers") // Sử dụng /lecturers làm URL gốc cho các API
public class LecturerController {
    
    @Autowired
    private LecturerService service;
    
    // Lấy danh sách tất cả giảng viên
    @GetMapping("")
    public List<Lecturer> list() {
        return service.listAll();
    }

    // Lấy thông tin giảng viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> get(@PathVariable Integer id) {
        try {
            Lecturer lecturer = service.get(id);
            return new ResponseEntity<>(lecturer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Thêm giảng viên mới
    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Lecturer lecturer) {
        try {
            Lecturer savedLecturer = service.save(lecturer);
            return new ResponseEntity<>(savedLecturer, HttpStatus.CREATED); // Trả về mã 201 (Created) và giảng viên mới
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add lecturer", HttpStatus.INTERNAL_SERVER_ERROR); // Trả về mã lỗi 500 nếu thêm thất bại
        }
    }

    // Cập nhật thông tin giảng viên
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Lecturer lecturer, @PathVariable Integer id) {
        try {
            Lecturer existingLecturer = service.get(id);
            // Cập nhật các thông tin mới cho giảng viên
            existingLecturer.setLecturerCode(lecturer.getLecturerCode());
            existingLecturer.setFullName(lecturer.getFullName());
            existingLecturer.setEmail(lecturer.getEmail());
            existingLecturer.setPhoneNumber(lecturer.getPhoneNumber());
            existingLecturer.setFaculty(lecturer.getFaculty());
            existingLecturer.setSubject(lecturer.getSubject());
            service.save(existingLecturer);
            return new ResponseEntity<>(existingLecturer, HttpStatus.OK); // Trả về giảng viên đã cập nhật
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Lecturer not found", HttpStatus.NOT_FOUND);
        }
    }

    // Xóa giảng viên
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về mã 204 (No Content) khi xóa thành công
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Tìm kiếm giảng viên
    @GetMapping("/search")
    public ResponseEntity<List<Lecturer>> searchLecturers(@RequestParam String query) {
        List<Lecturer> lecturers = service.searchLecturers(query);
        if (lecturers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Trả về mã 404 nếu không tìm thấy giảng viên
        }
        return new ResponseEntity<>(lecturers, HttpStatus.OK); // Trả về danh sách giảng viên tìm được
    }
}
