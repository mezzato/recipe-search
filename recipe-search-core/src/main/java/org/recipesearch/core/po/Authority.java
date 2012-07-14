package org.recipesearch.core.po;

import java.util.List;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.ForeignKey;
import org.lambico.po.hibernate.EntityBase;

/**
 * A PO for Authority table.
 *
 * @author <a href="mailto:enrico.giurin@gmail.com">Enrico Giurin</a>
 * @version $Revision: 2c4d46632a31 $
 */
@javax.persistence.Entity
public class Authority extends EntityBase {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String description = null;
    private String role = null;
    private List<User> users;

    /**
     * Empty constructor.
     *
     */
    public Authority() {
    }

    /**
     * Constructor with role.
     * @param role The role.
     */
    public Authority(String role) {
        this.role = role;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "userAuthorities")
    @ForeignKey(name = "none", inverseName = "none")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "role: " + role + " - description: " + description;
    }
}
