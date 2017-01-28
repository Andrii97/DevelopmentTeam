package ua.training.config;

import ua.training.model.entity.Role;
import ua.training.utils.constants.PathsHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 28.01.17.
 */
public class DevelopmentTeamConfig {
    public static Map<Role, String> roleUrlMap = new HashMap<Role, String>() {{
        put(Role.CUSTOMER, PathsHolder.CUSTOMER_URL);
        put(Role.MANAGER, PathsHolder.MANAGER_URL);
        put(Role.DEVELOPER, PathsHolder.DEVELOPER_URL);
    }};
}
