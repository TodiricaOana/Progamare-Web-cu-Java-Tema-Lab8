package ro.unibuc.springlab8example1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.unibuc.springlab8example1.domain.StudyProgram;
import ro.unibuc.springlab8example1.domain.User;
import ro.unibuc.springlab8example1.dto.StudyProgramDto;
import ro.unibuc.springlab8example1.dto.UserDto;

@Mapper(componentModel = "spring")
public interface StudyProgramMapper {

    StudyProgramDto mapToDto(StudyProgram studyProgram);

    StudyProgram mapToEntity(StudyProgramDto studyProgramDto);
}
