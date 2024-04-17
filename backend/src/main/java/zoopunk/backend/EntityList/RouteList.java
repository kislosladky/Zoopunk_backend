package zoopunk.backend.EntityList;

import lombok.AllArgsConstructor;
import lombok.Data;
import zoopunk.backend.dto.RouteDescription;

import java.util.List;

@AllArgsConstructor
@Data
public class RouteList {
    private List<RouteDescription> routeDescriptions;
}
