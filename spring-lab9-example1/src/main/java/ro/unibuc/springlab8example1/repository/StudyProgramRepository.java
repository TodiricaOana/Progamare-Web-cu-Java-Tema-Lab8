package ro.unibuc.springlab8example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.unibuc.springlab8example1.domain.Points;
import ro.unibuc.springlab8example1.domain.StudyProgram;

import java.util.List;

@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {

    List<StudyProgram> findAll();
}
