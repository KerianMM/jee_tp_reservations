package montp.data.entity;

import montp.data.model.ResourceTypeModel;

import javax.persistence.*;

@Entity
@Table(name = "resource_type")
public class ResourceTypeEntity extends ResourceTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) protected Long id;
    @Column(nullable = false) protected String title;
    @Column(nullable = false) protected Boolean shareable = false;

    public ResourceTypeEntity() { super(); }
    public ResourceTypeEntity(String title, Boolean shareable) { super(title, shareable); }
}
