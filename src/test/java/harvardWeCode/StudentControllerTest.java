package harvardWeCode;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentControllerTest {

    @Test
    public void shouldReturnAMap() {
        StudentController studentController = new StudentController();
        studentController.studentService = mock(StudentService.class);

        Map freshmenMajorsByRaceEthnicityAndGender = createTestMajorIntendedData();
        when(studentController.studentService.list()).thenReturn(freshmenMajorsByRaceEthnicityAndGender);

        assertThat(studentController.home(), is(freshmenMajorsByRaceEthnicityAndGender.get("All races and ethnicities")));
    }

    @Test
    public void shouldOnlyReturnDataForAllRacesAndEthnicities() {
        StudentController studentController = new StudentController();
        studentController.studentService = mock(StudentService.class);

        HashMap freshmenMajorsByRaceEthnicityAndGender = createTestMajorIntendedData();
        when(studentController.studentService.list()).thenReturn(freshmenMajorsByRaceEthnicityAndGender);

        assertThat(studentController.home().containsKey("Female"), is(true));
        assertThat(studentController.home().containsKey("Male"), is(true));
        assertThat(studentController.home().containsKey("Total"), is(true));
    }

    @Ignore
    @Test
    public void shouldReturnDataForTheSpecifiedRace() {
        StudentController studentController = new StudentController();
        studentController.studentService = mock(StudentService.class);

        HashMap freshmenMajorsByRaceEthnicityAndGender = createTestMajorIntendedData();
        when(studentController.studentService.list()).thenReturn(freshmenMajorsByRaceEthnicityAndGender);

        Map<String, Object>  studentIntentionsToMajor = studentController.get("White");

        assertThat(studentIntentionsToMajor.containsKey("Female"), is(true));
        assertThat(studentIntentionsToMajor.containsKey("Male"), is(true));
        assertThat(studentIntentionsToMajor.containsKey("Total"), is(true));
    }

    private HashMap createTestMajorIntendedData() {
        HashMap freshmenMajorsByRaceEthnicityAndGender = new HashMap();
        Map percentagesByMajor = new HashMap<>();
        percentagesByMajor.put("Total", createMajor("Engineering",31.3));
        percentagesByMajor.put("Female", createMajor("Engineering", 1.3));
        percentagesByMajor.put("Male", createMajor("Engineering", 3.9));
        freshmenMajorsByRaceEthnicityAndGender.put("Hispanic or Latino", percentagesByMajor);

        percentagesByMajor.put("Total", createMajor("Engineering",31.3));
        percentagesByMajor.put("Female", createMajor("Engineering", 1.3));
        percentagesByMajor.put("Male", createMajor("Engineering", 3.9));
        freshmenMajorsByRaceEthnicityAndGender.put("All races and ethnicities", percentagesByMajor);
        return freshmenMajorsByRaceEthnicityAndGender;
    }

    private List createMajor(String majorName, Double percentage) {
        List major = new ArrayList<>();
        Map<String, Double> nameToPercentage = new HashMap<>();

        nameToPercentage.put(majorName, percentage);
        major.add(nameToPercentage);

        return major;
    }
}