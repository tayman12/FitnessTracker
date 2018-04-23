package org.learning.spring.controller;

import org.learning.spring.model.Activity;
import org.learning.spring.model.Exercise;
import org.learning.spring.model.Goal;
import org.learning.spring.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MinutesController {

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
    public String getMinutes(@ModelAttribute("exercise") Exercise exercise) {
        System.out.println("Get method on addMinutes has been called");
        return "addMinutes";
    }

    @RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
    public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, HttpSession session, BindingResult result) {
        System.out.println("exercise: " + exercise.getMinutes());
        System.out.println("exercise activity: " + exercise.getActivity());

        if (result.hasErrors()) {
            return "addMinutes";
        } else {
            Goal goal = (Goal) session.getAttribute("goal");
            exercise.setGoal(goal);
            exerciseService.save(exercise);
        }

        return "redirect:index.html";
    }

    @ResponseBody
    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public List<Activity> findAllActivities() {
        return exerciseService.findAllActivities();
    }
}
