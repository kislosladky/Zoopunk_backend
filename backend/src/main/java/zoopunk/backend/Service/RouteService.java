package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Entity.Route;
import zoopunk.backend.EntityList.RouteList;
import zoopunk.backend.Repository.RouteRepository;
import zoopunk.backend.dto.RouteDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    public Optional<RouteList> getAllRoutes() {
        List<Route> routes = routeRepository.findAll();
        List<RouteDescription> result = new ArrayList<>();
        for (Route route: routes) {
            result.add(RouteDescription.builder()
                    .id(route.getId())
                    .name(route.getName())
                    .description(route.getDescription())
                    .build());
        }

        if (result.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new RouteList(result));
    }

    public Optional<Route> findById(UUID id) {
        return routeRepository.findById(id);
    }
}
