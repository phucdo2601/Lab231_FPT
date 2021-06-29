/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class RoleUserDTO implements Serializable{
    private String roleID;
    private String roleName;

    public RoleUserDTO() {
    }

    public RoleUserDTO(String roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
}
