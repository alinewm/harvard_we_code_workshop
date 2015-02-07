package harvardWeCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("")
    @ResponseBody
    Map home() {
        return studentService.list().get("All races and ethnicities");
    }

    @RequestMapping("/{raceOrEthnicity}")
    @ResponseBody
    public Map<String,Object> get(@PathVariable(value = "raceOrEthnicity") String raceOrEthnicity) {
        return new HashMap<>();
    }
}
