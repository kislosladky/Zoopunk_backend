package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.EntityList.RouteList;
import zoopunk.backend.Service.RouteService;
import zoopunk.backend.Entity.Route;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("/all")
    public ResponseEntity<RouteList> getAllRoutes() {
        Optional<RouteList> response = routeService.getAllRoutes();
        return ResponseEntity.of(response);
    }

    @GetMapping("/byId")
    public ResponseEntity<String> getRouteById(@RequestParam UUID id) {
        Optional<Route> response = routeService.findById(id);

        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response.get().getWaypoints());
        }
    }
}
