package com.technologie.zad3.Controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.technologie.zad3.Model.Cat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CatsController {

    private final List<Cat> cats = Stream.of(
            new Cat("Mars", "miau", "black", "dry", 2),
            new Cat("Izaya", "meow", "white", "wet", 3),
            new Cat("Sergiej", "me#@!@!ew", "Orange", "uranium", 73)).toList();

    @GetMapping("/cats")
    public List<Cat> getListOfCats() {
        return cats;
    }

    @GetMapping("/cats/name/{name}")
    public Stream<Cat> getCatByName(@PathVariable String name) {
        if (!name.isEmpty()) {
            return cats.stream().filter(cat -> Objects.equals(cat.Name(), name));
        } else {
            return Stream.empty();
        }
    }

    @GetMapping("/cats/age/{age}")
    public Stream<Cat> getCatByAge(@PathVariable Integer age) {
        if (age != null) {
            return cats.stream().filter(cat -> Objects.equals(cat.age(), age));
        } else {
            return Stream.empty();
        }
    }

    @GetMapping("/cats/furcolour/{furcolour}")
    public Stream<Cat> getCatByFurcolour(@PathVariable String furcolour) {
        if (!furcolour.isEmpty()) {
            return cats.stream().filter(cat -> Objects.equals(cat.furcolour(), furcolour));
        } else {
            return Stream.empty();
        }
    }

    @GetMapping("/cats/foodtype/{foodtype}")
    public Stream<Cat> getCatByFoodtype(@PathVariable String foodtype) {
        if (!foodtype.isEmpty()) {
            return cats.stream().filter(cat -> Objects.equals(cat.foodtype(), foodtype));
        } else {
            return Stream.empty();
        }
    }

    @GetMapping("/cats/sound/{sound}")
    public Stream<Cat> getCatBySound(@PathVariable String sound) {
        if (!sound.isEmpty()) {
            return cats.stream().filter(cat -> Objects.equals(cat.sound(), sound));
        } else {
            return Stream.empty();
        }
    }

    @GetMapping("/cats/void")
    public Stream<Cat> getCatByVoid() {
        return Stream.empty();
    }

    @GetMapping("/error")
    public String getError() {
        return "Error";
    }

}
