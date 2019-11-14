package montp.data;

import montp.data.entity.ResourceTypeEntity;
import montp.data.entity.security.GroupEntity;
import montp.data.entity.security.UserEntity;
import montp.data.model.GroupModel;
import montp.services.ResourceTypeService;
import montp.services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class Seeder {
    
    @Inject private UserService userService;
    @Inject private ResourceTypeService resourceTypeService;

    @PersistenceContext private EntityManager em;
    
    @PostConstruct
    public void init() {
        if (userService.getGroup("USER") == null) {
            GroupEntity groupUser = new GroupEntity("USER");
            em.persist(groupUser);
            GroupEntity groupAdmin = new GroupEntity("ADMIN");
            em.persist(groupAdmin);
            UserEntity userAdmin = new UserEntity("admin", "admin");
            List<GroupModel> groupes = new ArrayList<>();
            groupes.add(groupUser);
            groupes.add(groupAdmin);
            userAdmin.setGroups(groupes);
            userService.insert(userAdmin);
        }

        if (resourceTypeService.getAll().isEmpty()) {
            ResourceTypeEntity test = new ResourceTypeEntity("test", true);

            em.persist(test);
        }
    }

}
