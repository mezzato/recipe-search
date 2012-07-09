package org.recipesearch.hibernatesearch.po;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.search.annotations.DocumentId;
import org.lambico.po.hibernate.Entity;


@MappedSuperclass
public abstract class SearchableEntityBase implements Entity, Serializable {

    /**
     * Creates a new instance of EntityBase.
     */
    public SearchableEntityBase() {
    }
    /**
     * The entity id.
     */
    protected Long id;
    /**
     * The entity version for optimistic locking.
     */
//    protected Integer version;

    /**
     * Get the entity id.
     *
     * @return the entity id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return this.id;
    }

//    /**
//     * Get the version for optimistic locking.
//     *
//     * @return The version fooptimistic locking
//     */
//    @Version
//    public Integer getVersion() {
//        return this.version;
//    }
    /**
     * Set the entity id.
     *
     * @param id the entity id
     */
    public void setId(final Long id) {
        this.id = id;
    }

//
//    /**
//     * Set the version for optimistic locking
//     *
//     * @param version The version for optimistic locking
//     */
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
    /**
     * Default implementation of the equals method.
     * It return true if the objects are of the same type and have
     * the same id.
     *
     * @param obj The object to compare with this
     * @return true if the objects are equals
     */
    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (obj != null) {
            String className = obj.getClass().getName();
            if (className.indexOf("$$EnhancerByCGLIB$$") > 0) {
                className = className.substring(0, className.indexOf("$$EnhancerByCGLIB$$"));
            }
            if (this.getClass().getName().equals(className)) {
                if (this.getId() != null && this.getId().equals(((SearchableEntityBase) obj).getId())) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Default implementation of the hashcode method for an Entity.
     * It return the hascode of the Id, if the Id is not null.
     * It return the hascode of the Object, if the Id is null.
     *
     * @return The hashcode of the entity instance.
     */
    @Override
    public int hashCode() {
        int result;
        if (this.getId() != null) {
            result = this.getId().hashCode();
        } else {
            result = super.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[id=" + this.id + "]";
    }
}
