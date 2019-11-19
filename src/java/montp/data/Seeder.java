package montp.data;

import montp.data.entity.*;
import montp.data.entity.security.*;
import montp.services.*;

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
    @Inject private ResourceService resourceService;
    @Inject private PersonService personService;

    @PersistenceContext private EntityManager em;
    
    @PostConstruct
    public void init() {
        if (resourceTypeService.isEmpty() &&
            resourceService.isEmpty() &&
            personService.isEmpty()
        ) {
            //region RESOURCE_TYPE
            ResourceTypeEntity salleDeCours = new ResourceTypeEntity("Salle de cours", true, true);
            ResourceTypeEntity gymnase = new ResourceTypeEntity("Gymnase", true, true);

            resourceTypeService.insert(salleDeCours);
            resourceTypeService.insert(gymnase);
            //endregion

            //region PERSON
            PersonEntity kerian = new PersonEntity("Kérian", "MONTES-MORIN", "kerianmontes@test.com");
            PersonEntity ben    = new PersonEntity("Ben", "Clément", "ben@test.com");
            PersonEntity loic   = new PersonEntity("Loic", "Wernert", "lw@test.com");

            PersonEntity esimed     = new PersonEntity("Esi", "med", "esimed@test.com");
            PersonEntity aubanel    = new PersonEntity("Théodore", "Aubanel", "aubanel@test.com");

            personService.insert(kerian);
            personService.insert(ben);
            personService.insert(loic);

            personService.insert(esimed);
            personService.insert(aubanel);
            //endregion

            //region RESOURCE
            ResourceEntity salleA = new ResourceEntity(salleDeCours, esimed, 10);
            ResourceEntity salleB = new ResourceEntity(salleDeCours, esimed, 20);
            ResourceEntity stadeDeFoot = new ResourceEntity(gymnase, aubanel, 100);
            ResourceEntity stadeDeBasket = new ResourceEntity(gymnase, aubanel, 80);

            resourceService.insert(salleA);
            resourceService.insert(salleB);
            resourceService.insert(stadeDeFoot);
            resourceService.insert(stadeDeBasket);
            //endregion

            if (userService.getGroup("USER") == null) {
                GroupEntity groupUser = new GroupEntity("USER");
                GroupEntity groupAdmin = new GroupEntity("ADMIN");
                em.persist(groupUser);
                em.persist(groupAdmin);

                UserEntity userAdmin = new UserEntity("kerian", "kerian", kerian);
                UserEntity userUser = new UserEntity("ben", "ben", ben);

                List<GroupEntity> groupesAdmin  = new ArrayList<>();
                List<GroupEntity> groupesUser   = new ArrayList<>();

                groupesUser.add(groupUser);
                userUser.setGroups(groupesUser);

                groupesAdmin.add(groupUser);
                groupesAdmin.add(groupAdmin);
                userAdmin.setGroups(groupesAdmin);

                userService.insert(userAdmin);
                userService.insert(userUser);
            }
        }
    }

}
