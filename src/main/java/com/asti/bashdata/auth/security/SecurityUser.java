package com.asti.bashdata.auth.security;

import com.asti.bashdata.auth.permission.Permission;
import com.asti.bashdata.auth.permission.RolePermission;
import com.asti.bashdata.user.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the authenticated application user.
 *
 * <p>
 * This class adapts the application's {@link User} entity
 * to Spring Security's {@link UserDetails} contract.
 * </p>
 *
 * <p>
 * Each authenticated user is assigned:
 * <ul>
 *     <li>A role authority (e.g. ROLE_ADMIN)</li>
 *     <li>Business permissions derived from the assigned role</li>
 * </ul>
 * </p>
 */
@Getter
public class SecurityUser implements UserDetails {

    /**
     * Wrapped application user.
     */
    private final User user;

    /**
     * Creates a security user.
     *
     * @param user application user
     */
    public SecurityUser(User user) {
        this.user = user;
    }

    /**
     * Returns all authorities granted to the authenticated user.
     *
     * <p>
     * Authorities include:
     * <ul>
     *     <li>Spring Security role (ROLE_*)</li>
     *     <li>Business permissions</li>
     * </ul>
     * </p>
     *
     * @return granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();

        // Add the user's role.
        authorities.add(
                new SimpleGrantedAuthority(
                        "ROLE_" + user.getRole().name()
                )
        );

        // Add all permissions assigned to the role.
        for (Permission permission :
                RolePermission.getPermissions(user.getRole())) {

            authorities.add(
                    new SimpleGrantedAuthority(
                            permission.name()
                    )
            );

        }

        return authorities;

    }

    /**
     * Returns the user's encoded password.
     *
     * @return password hash
     */
    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    /**
     * Returns the username used during authentication.
     *
     * @return email address
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Indicates whether the account has expired.
     *
     * @return true if account is valid
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the account is locked.
     *
     * @return true if account is not locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials have expired.
     *
     * @return true if credentials are valid
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the account is enabled.
     *
     * <p>
     * In future sprints this will depend on
     * the user's account status.
     * </p>
     *
     * @return true if enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}