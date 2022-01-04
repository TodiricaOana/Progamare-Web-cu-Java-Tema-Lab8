package ro.unibuc.springlab8example1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.springlab8example1.domain.Points;
import ro.unibuc.springlab8example1.domain.StudyProgram;
import ro.unibuc.springlab8example1.dto.PointsDto;
import ro.unibuc.springlab8example1.dto.StudyProgramDto;
import ro.unibuc.springlab8example1.mapper.PointsMapper;
import ro.unibuc.springlab8example1.mapper.StudyProgramMapper;
import ro.unibuc.springlab8example1.repository.PointsRepository;
import ro.unibuc.springlab8example1.repository.StudyProgramRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudyProgramService {

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    @Autowired
    private StudyProgramMapper studyProgramMapper;

    public StudyProgramDto addStudyProgram(StudyProgramDto studyProgramDto) {
        StudyProgram studyProgram = studyProgramMapper.mapToEntity(studyProgramDto);

        StudyProgram savedStudyProgram = studyProgramRepository.save(studyProgram);
        return studyProgramMapper.mapToDto(savedStudyProgram);
    }

    public void deleteStudyProgramById(Long id) {
        StudyProgram studyProgram = studyProgramRepository.findById(id).get();

        studyProgramRepository.delete(studyProgram);
    }

    public List<StudyProgramDto> getAllStudyPrograms() {
        List<StudyProgram> studyPrograms = studyProgramRepository.findAll();
        List <StudyProgramDto> studyProgramDtos = studyPrograms.stream().map(studyProgram -> studyProgramMapper.mapToDto(studyProgram))
                .collect(Collectors.toList());
        return studyProgramDtos;
    }

    public StudyProgramDto updateStudyProgram(StudyProgramDto studyProgramDto, Long id) {
        StudyProgram studyProgram = studyProgramMapper.mapToEntity(studyProgramDto);
        studyProgram.setId(id);
        return studyProgramMapper.mapToDto(studyProgramRepository.save(studyProgram));
    }
}
