package com.example.thithuchanhmd4.controller;

import com.example.thithuchanhmd4.model.City;
import com.example.thithuchanhmd4.model.Nation;
import com.example.thithuchanhmd4.service.ICityService;
import com.example.thithuchanhmd4.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private INationService nationService;

    @ModelAttribute("nations")
    public Iterable<Nation> suppliers() {
        return nationService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView showPCities() {
        return new ModelAndView("city/list", "cities", cityService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("city/create", "city", new City());
    }

    @PostMapping("/save")
    public ModelAndView saveCity(@Validated City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Có lỗi, xử lý lỗi ở đây
            return new ModelAndView("city/create", "city", city);
        }

        cityService.save(city);
        return new ModelAndView("city/list", "message", "City created successfully");
    }

    @GetMapping("/details/{id}")
    public ModelAndView showDetails(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        return city.map(value -> new ModelAndView("city/details", "city", value)).orElseGet(() -> new ModelAndView("error/404"));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        return city.map(value -> new ModelAndView("city/edit", "city", value)).orElseGet(() -> new ModelAndView("error/404"));
    }

    @PostMapping("/update")
    public ModelAndView updateCity(@Validated City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("city/edit", "city", city);
        }

        cityService.save(city);
        return new ModelAndView("city/list", "message", "City updated successfully");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<City> product = cityService.findById(id);
        return product.map(value -> new ModelAndView("city/delete", "city", value))
                .orElseGet(() -> new ModelAndView("error/404"));
    }

    @PostMapping("/delete")
    public ModelAndView deleteProduct(@ModelAttribute City city) {
        cityService.remove(city.getId());
        return new ModelAndView("city/list", "message", "City deleted successfully");
    }
}
