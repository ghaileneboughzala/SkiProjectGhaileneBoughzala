package com.example.skighailene.controllers;
import com.example.skighailene.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.skighailene.services.ICoursService;
import java.util.List;

@RestController
@RequestMapping("/cours")
//localhost:9090
public class CoursController {
    @Autowired
    ICoursService coursService;
    //localhost:9090
    @GetMapping
    public List<Cours> getAll(){
        return coursService.retrieveAllCourses();
    }
    @PostMapping
    public  Cours addCours(@RequestBody Cours cours){
       return coursService.addCours(cours);
    }
    @DeleteMapping("{numCours}")
    public  void deleteCours(@PathVariable Long numCours){coursService.removeCours(numCours);
    }
@PutMapping
    public Cours updateCours(@RequestBody Cours cours){
        return coursService.updateCours(cours);
}
@GetMapping("{numCours}")
public Cours retrieveCours (@PathVariable Long numCours){
      return  coursService.retrieveCours(numCours);
}

}
