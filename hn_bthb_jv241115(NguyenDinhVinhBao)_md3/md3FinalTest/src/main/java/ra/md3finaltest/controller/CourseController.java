package ra.md3finaltest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.md3finaltest.entity.Course;
import ra.md3finaltest.service.course.ICouseService;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICouseService courseService;
    @GetMapping({"","/list"})
    public String list(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "5") int size,
                       @RequestParam(value = "keyword", defaultValue = "") String keyword,
                       @RequestParam(value = "error", defaultValue = "") String message,
                       Model model){
        model.addAttribute("course", courseService.pagination(keyword,page,size));
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages",courseService.countTotalPages(size));
        if (!Objects.equals(message, "")){
            model.addAttribute("error", message);
        }
        return "course/list";
    }
    @GetMapping("/new")
    public String showAddForm(Model model){
        model.addAttribute("course", new Course());
        return "course/add";
    }

    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute("course") Course request, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("course", request);
            return "category/add";
        }
        courseService.create(request);
        return "redirect:/course";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        Course entity = courseService.findById(id);

        model.addAttribute("course", entity);
        model.addAttribute("id", id);

        return "course/edit";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("course") Course course,
                           @RequestParam("courseId") Integer id, Model model){

        courseService.update(course,id);

        return "redirect:/course";}

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        courseService.delete(id);

        return "redirect:/course";
    }

}
