package com.hcl.usecase.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Long> {

}
