package fr.polytech.michelin.controller;

import fr.polytech.michelin.dto.RestaurantDto;
import fr.polytech.michelin.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
//@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    public final RestaurantService restaurantService;

    public RestaurantController(RestaurantService service) {
        this.restaurantService = service;
    }

    @GetMapping("/restaurants/{id}")
    public @ResponseBody RestaurantDto getRestaurantById(@PathVariable int id) {
        return RestaurantDto.fromEntity(this.restaurantService.getRestaurantById(id));
    }

    @GetMapping("/restaurants")
    public @ResponseBody List<RestaurantDto> getRestaurants() {
        System.out.println("Retourne tous les restaurants");
        return this.restaurantService.getAllRestaurants().stream().map(entity -> RestaurantDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("/restaurants")
    public RestaurantDto postRestaurant(@Valid @RequestBody RestaurantDto resto) {
        return RestaurantDto.fromEntity(this.restaurantService.addRestaurant(resto.getNom(), resto.getAdresse()));
    }

    @PutMapping("/restaurants/{id}")
    public RestaurantDto putRestaurant(@PathVariable int id, @Valid @RequestBody RestaurantDto resto) {
        return RestaurantDto.fromEntity(this.restaurantService.updateRestaurant(id, resto.getNom(), resto.getAdresse()));
    }
}
