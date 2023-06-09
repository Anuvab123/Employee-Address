package com.geekster.EmployeeAddress.repository;

import com.geekster.EmployeeAddress.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address,Long> {

    public Address findAddressById(Long id);
}
