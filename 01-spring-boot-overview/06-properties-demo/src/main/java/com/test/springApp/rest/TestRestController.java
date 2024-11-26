package com.test.springApp.rest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello world ";
    }


    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Go to gym and feed";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Tomorrow will be better.";
    }


    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/team")
    public String printTeamName(){
        return teamName;
    }

    @GetMapping("/coach")
    public String printCoachName(){
        return coachName;
    }
}
