package org.recipesearch.core.po;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;
import org.lambico.po.hibernate.EntityBase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * A PO for UserProfile table.
 *
 * @author <a href="mailto:enrico.giurin@gmail.com">Enrico Giurin</a>
 * @author <a href="mailto:michele.franzin@seesaw.it">Michele Franzin</a>
 * @author Lucio Benfante <lucio.benfante@gmail.com>
 * @version $Revision$
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "PSEC_USER")
@NamedQueries(value = {
    @NamedQuery(name = "User.findAuthoritiesByPartialUsername", query =
    "SELECT u.userAuthorities from User u where upper(u.username) like upper(?)"),
    @NamedQuery(name = "User.findByPartialUsername", query =
    "from User u where upper(u.username) like concat(concat('%', upper(?)), '%')")
})
public class User extends EntityBase implements UserDetails {

    private static final long serialVersionUID = 832363948575562242L;
    private String username = null;
    private String password = null;
    private String oldPassword = null;
    private boolean enabled = true;
    private String firstName;
    private String lastName;
    private List<Authority> userAuthorities = new ArrayList<Authority>();

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @NotBlank
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @ForeignKey(name = "none", inverseName = "none")
    @JoinTable(name = "USER_AUTHORITY",
    joinColumns = {
        @JoinColumn(name = "USER_ID")},
    inverseJoinColumns = {
        @JoinColumn(name = "AUTHORITY_ID")})
    public List<Authority> getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(List<Authority> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    @Override
    public String toString() {
        return "username: " + username + " - password: <XXX> - enabled: " + enabled;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getExposedName() {
        String result = null;
        if (StringUtils.isNotBlank(getFirstName()) || StringUtils.isNotBlank(getLastName())) {
            result = StringUtils.defaultString(getFirstName()) + " " + StringUtils.defaultString(
                    getLastName());
        } else {
            result = getUsername();
        }
        return result;
    }

    @Transient
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> result = new ArrayList<GrantedAuthority>(getUserAuthorities().size());
        int i = 0;
        for (Authority authority : getUserAuthorities()) {
            result.add(new GrantedAuthorityImpl(authority.getRole()));
        }
        return result;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
