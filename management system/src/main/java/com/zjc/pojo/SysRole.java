package com.zjc.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="role")
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "tb_role_permission",
            joinColumns = {@JoinColumn(name = "r_id")},
            inverseJoinColumns = {@JoinColumn(name = "p_id")}
    )
    @OrderBy("id asc")
    private List<SysPermission> permissions;
}
