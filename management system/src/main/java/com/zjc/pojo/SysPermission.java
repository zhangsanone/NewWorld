package com.zjc.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="permission")
public class SysPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String code;
}
