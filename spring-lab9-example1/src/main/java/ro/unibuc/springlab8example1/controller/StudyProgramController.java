package ro.unibuc.springlab8example1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.springlab8example1.dto.PointsDto;
import ro.unibuc.springlab8example1.dto.StudyProgramDto;
import ro.unibuc.springlab8example1.service.PointService;
import ro.unibuc.springlab8example1.service.StudyProgramService;

import java.util.List;

@RestController
@RequestMapping("/studyProgram")
public class StudyProgramController {

    @Autowired
    private StudyProgramService studyProgramService;

    @PostMapping("/add")
    public ResponseEntity<StudyProgramDto> addStudyProgram(@RequestBody StudyProgramDto studyProgramDto) {
        return ResponseEntity
                .ok()
                .body(studyProgramService.addStudyProgram(studyProgramDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudyProgramDto>> get() {
        return ResponseEntity
                .ok()
                .body(studyProgramService.getAllStudyPrograms());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudyProgramDto> updateStudyProgram(@RequestBody StudyProgramDto studyProgramDto, @PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(studyProgramService.updateStudyProgram(studyProgramDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudyProgramDto> delete(@PathVariable Long id) {
        studyProgramService.deleteStudyProgramById(id);
        return ResponseEntity.noContent().build();
    }
}
