package org.learning.spring.controller;

import org.learning.spring.model.Goal;
import org.learning.spring.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("goal")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @RequestMapping(value = "addGoal", method = RequestMethod.GET)
    public String addGoal(Model model) {
        Goal goal = new Goal();
        goal.setMinutes(10);
        model.addAttribute("goal", goal);

        return "addGoal";
    }

    @RequestMapping(value = "addGoal", method = RequestMethod.POST)
    public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
        System.out.println("result has errors: " + result.hasErrors());
        System.out.println("Goal set: " + goal.getMinutes());

        if (result.hasErrors()) {
            return "addGoal";
        } else {
            goalService.save(goal);
        }
        return "redirect:index.html";
    }

    @RequestMapping(value = "/getGoals", method = RequestMethod.GET)
    public String getGoals(Model model) {
        List<Goal> goals = goalService.findAll();
        model.addAttribute("goals", goals);
        return "getGoals";
    }
}