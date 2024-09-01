package com.shyam.Rest_API.entity

import jakarta.persistence.*

@Entity
@Table(name = "employee")
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id : Int?,

    @Column(name = "first_name")
    var firstName : String?,

    @Column(name = "last_name")
    var lastName : String?,

    @Column(name = "email")
    var email : String?
){
    constructor(firstName: String?,lastName: String?,email: String?) : this(
        id = null,
        firstName = firstName,
        lastName = lastName,
        email = email
    )
}