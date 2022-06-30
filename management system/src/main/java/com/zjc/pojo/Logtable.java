package com.zjc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "log")
public class Logtable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String operateClassName;
    @Column
    private String operateMethodName;
    @Column
    private String operateType;
    @Column
    private String operateExplain;
    @Column
    private String operateUser;
    @Column
    private String operateDate;
    @Column
    private String operateResult;
    @Column
    private String remark;
}
