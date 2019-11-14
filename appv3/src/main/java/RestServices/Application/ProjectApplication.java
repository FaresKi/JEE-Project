package RestServices.Application;

import RestServices.service.EmployeeFacadeREST;
import RestServices.service.UserFacadeREST;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/Project")
public class ProjectApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(EmployeeFacadeREST.class);
        h.add(UserFacadeREST.class);
        return h;
    }

}
