package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MvoCommodityRepository extends JpaRepository<MvoCommodity, Integer>
{
    @Query("SELECT c FROM MvoCommodity c WHERE c.shop_id = ?1")
    List<MvoCommodity> getCommoditiesByShop_idIs(Integer shop_id);
}
