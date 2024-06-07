package com.example.ecshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByName(String name);

}
