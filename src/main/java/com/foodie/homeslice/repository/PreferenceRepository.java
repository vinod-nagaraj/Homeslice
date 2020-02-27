package com.foodie.homeslice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodie.homeslice.entity.Preference;
import com.foodie.homeslice.util.HomeSliceEnum.Priority;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {

	@Query("select p.itemId from Preference p where p.customerId=?1 and p.priority=?2")
	List<Long> findAllByCustomerIdAndPriority(Long customerId, Priority priority);

	@Query("select p.itemId from Preference p where p.customerId=?1 and p.priority=?2 order by p.count desc")
	List<Long> findAllByCustomerIdAndPrioritySorted(Long customerId, Priority low);

}
